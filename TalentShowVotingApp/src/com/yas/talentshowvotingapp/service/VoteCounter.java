package com.yas.talentshowvotingapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.AGateway.GatewayStatuses;
import org.smslib.AGateway.Protocols;
import org.smslib.GatewayException;
import org.smslib.ICallNotification;
import org.smslib.IGatewayStatusNotification;
import org.smslib.IInboundMessageNotification;
import org.smslib.IOrphanedMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.Library;
import org.smslib.Message.MessageTypes;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.crypto.AESKey;
import org.smslib.modem.SerialModemGateway;

import com.yas.talentshowvotingapp.dao.DataManager;
import com.yas.talentshowvotingapp.other.PropertyHandler;

public class VoteCounter {

	public Service service;

	final static Logger logger = Logger.getLogger(DataManager.class);

	public VoteCounter() {
		super();
		// Define a list which will hold the read messages.
		List<InboundMessage> msgList;
		// Create the notification callback method for inbound & status report
		// messages.
		InboundNotification inboundNotification = new InboundNotification();
		// Create the notification callback method for inbound voice calls.
		CallNotification callNotification = new CallNotification();
		// Create the notification callback method for gateway statuses.
		GatewayStatusNotification statusNotification = new GatewayStatusNotification();
		OrphanedMessageNotification orphanedMessageNotification = new OrphanedMessageNotification();
		try {
			logger.info("Read messages from a serial gsm modem.");
			logger.info(Library.getLibraryDescription());
			logger.info("Version: " + Library.getLibraryVersion());

			// Create the Gateway representing the serial GSM modem.
			SerialModemGateway gateway = new SerialModemGateway(
					PropertyHandler.getInstance().getStringValue("serialModemGateway.id"),
					PropertyHandler.getInstance().getStringValue("serialModemGateway.comPort"),
					PropertyHandler.getInstance().getIntegerValue("serialModemGateway.baudRate"),
					PropertyHandler.getInstance().getStringValue("serialModemGateway.manufacturer"),
					PropertyHandler.getInstance().getStringValue("serialModemGateway.model"));
			// Set the modem protocol to PDU (alternative is TEXT). PDU is the
			// default, anyway...
			gateway.setProtocol(Protocols.PDU);
			// Do we want the Gateway to be used for Inbound messages?
			gateway.setInbound(true);
			// Do we want the Gateway to be used for Outbound messages?
			gateway.setOutbound(true);
			// Let SMSLib know which is the SIM PIN.
			gateway.setSimPin(PropertyHandler.getInstance().getStringValue("simPin"));
			// Set up the notification methods.

			gateway.getATHandler().setStorageLocations(PropertyHandler.getInstance().getStringValue("storageLocation"));
			// String SMSC = "+940713980848";
			// gateway.setSmscNumber(SMSC);

			Service.getInstance().setInboundMessageNotification(inboundNotification);
			Service.getInstance().setCallNotification(callNotification);
			Service.getInstance().setGatewayStatusNotification(statusNotification);
			Service.getInstance().setOrphanedMessageNotification(orphanedMessageNotification);
			// Add the Gateway to the Service object.
			Service.getInstance().addGateway(gateway);
			// Similarly, you may define as many Gateway objects, representing
			// various GSM modems, add them in the Service object and control
			// all of them.
			// Start! (i.e. connect to all defined Gateways)
			Service.getInstance().startService();

			service = Service.getInstance();

			// Printout some general information about the modem.

			logger.info("Modem Information:");
			logger.info("Manufacturer: " + gateway.getManufacturer());
			logger.info("Model: " + gateway.getModel());
			logger.info("Serial No: " + gateway.getSerialNo());
			logger.info("SIM IMSI: " + gateway.getImsi());
			logger.info("Signal Level: " + gateway.getSignalLevel() + " dBm");
			logger.info("Battery Level: " + gateway.getBatteryLevel() + "%");

			// In case you work with encrypted messages, its a good time to
			// declare your keys.
			// Create a new AES Key with a known key value.
			// Register it in KeyManager in order to keep it active. SMSLib will
			// then automatically
			// encrypt / decrypt all messages send to / received from this
			// number.
			Service.getInstance().getKeyManager().registerKey("+306948494037",
					new AESKey(new SecretKeySpec("0011223344556677".getBytes(), "AES")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Service getService() {
		return service;
	}

	public List<InboundMessage> readVoteMessages() {

		List<InboundMessage> msgList;

		msgList = new ArrayList<InboundMessage>();
		try {
			getService().getInstance().readMessages(msgList, MessageClasses.ALL);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msgList;

	}

	public boolean deleteMessage(InboundMessage msg) {
		try {
			return getService().getInstance().deleteMessage(msg);
		} catch (TimeoutException | GatewayException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static class InboundNotification implements IInboundMessageNotification {
		public void process(AGateway gateway, MessageTypes msgType, InboundMessage msg) {
			if (msgType == MessageTypes.INBOUND) {

				logger.info("New Inbound message detected from Gateway: " + gateway.getGatewayId());
				logger.info(msg.getOriginator());

			} else if (msgType == MessageTypes.STATUSREPORT) {

				logger.info("New Inbound Status Report message detected from Gateway: " + gateway.getGatewayId());
			}
			logger.info(msg);
		}
	}

	public static class CallNotification implements ICallNotification {
		public void process(AGateway gateway, String callerId) {
			logger.info("New call detected from Gateway: " + gateway.getGatewayId() + " : " + callerId);
		}
	}

	public static class GatewayStatusNotification implements IGatewayStatusNotification {
		public void process(AGateway gateway, GatewayStatuses oldStatus, GatewayStatuses newStatus) {
			logger.info("Gateway Status change for " + gateway.getGatewayId() + ", OLD: " + oldStatus + " -> NEW: "
					+ newStatus);
		}
	}

	public static class OrphanedMessageNotification implements IOrphanedMessageNotification {
		public boolean process(AGateway gateway, InboundMessage msg) {
			logger.info("Orphaned message part detected from " + gateway.getGatewayId());
			logger.info(msg);
			// Since we are just testing, return FALSE and keep the orphaned
			// message part.
			return false;
		}
	}

}
