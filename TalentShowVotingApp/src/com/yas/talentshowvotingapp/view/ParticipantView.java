package com.yas.talentshowvotingapp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.yas.talentshowvotingapp.controller.AppController;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.model.Vote;
import com.yas.talentshowvotingapp.other.AppStatus;

public class ParticipantView extends JFrame {

	private JPanel contentPane;
	private JTextField txtParticipantname;
	private JTextField txtReferancenumber;
	private JTable table;
	JButton btnUpdate;
	JButton btnAdd;
	JButton btnNext;
	private final DefaultTableModel tbleModel = new DefaultTableModel(
			new String[] { "Participant Id", "Name", "Ref No", "Group Name", "Vote Count" }, 0);
	private JLabel lblPreferedItem;
	private JComboBox comboBoxItems;
	private JButton btnCancel;
	private JTextField txtGroupname;

	/**
	 * Create the frame.
	 */
	public ParticipantView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 638, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblAddParticipants = new JLabel("Add Participants");
		GridBagConstraints gbc_lblAddParticipants = new GridBagConstraints();
		gbc_lblAddParticipants.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddParticipants.gridx = 0;
		gbc_lblAddParticipants.gridy = 0;
		contentPane.add(lblAddParticipants, gbc_lblAddParticipants);

		JLabel lblParticipantName = new JLabel("Participant Name");
		GridBagConstraints gbc_lblParticipantName = new GridBagConstraints();
		gbc_lblParticipantName.insets = new Insets(0, 0, 5, 5);
		gbc_lblParticipantName.anchor = GridBagConstraints.EAST;
		gbc_lblParticipantName.gridx = 0;
		gbc_lblParticipantName.gridy = 1;
		contentPane.add(lblParticipantName, gbc_lblParticipantName);

		txtParticipantname = new JTextField();
		GridBagConstraints gbc_txtParticipantname = new GridBagConstraints();
		gbc_txtParticipantname.insets = new Insets(0, 0, 5, 0);
		gbc_txtParticipantname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtParticipantname.gridx = 1;
		gbc_txtParticipantname.gridy = 1;
		contentPane.add(txtParticipantname, gbc_txtParticipantname);
		txtParticipantname.setColumns(10);

		JLabel lblReferanceNumber = new JLabel("Referance Number");
		GridBagConstraints gbc_lblReferanceNumber = new GridBagConstraints();
		gbc_lblReferanceNumber.anchor = GridBagConstraints.EAST;
		gbc_lblReferanceNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblReferanceNumber.gridx = 0;
		gbc_lblReferanceNumber.gridy = 2;
		contentPane.add(lblReferanceNumber, gbc_lblReferanceNumber);

		txtReferancenumber = new JTextField();
		GridBagConstraints gbc_txtReferancenumber = new GridBagConstraints();
		gbc_txtReferancenumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtReferancenumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtReferancenumber.gridx = 1;
		gbc_txtReferancenumber.gridy = 2;
		contentPane.add(txtReferancenumber, gbc_txtReferancenumber);
		txtReferancenumber.setColumns(10);

		lblPreferedItem = new JLabel("Prefered Item");
		GridBagConstraints gbc_lblPreferedItem = new GridBagConstraints();
		gbc_lblPreferedItem.anchor = GridBagConstraints.EAST;
		gbc_lblPreferedItem.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreferedItem.gridx = 0;
		gbc_lblPreferedItem.gridy = 3;
		contentPane.add(lblPreferedItem, gbc_lblPreferedItem);

		comboBoxItems = new JComboBox();

		GridBagConstraints gbc_comboBoxItems = new GridBagConstraints();
		gbc_comboBoxItems.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxItems.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxItems.gridx = 1;
		gbc_comboBoxItems.gridy = 3;
		contentPane.add(comboBoxItems, gbc_comboBoxItems);

		JLabel lblGroupName = new JLabel("Group Name");
		GridBagConstraints gbc_lblGroupName = new GridBagConstraints();
		gbc_lblGroupName.anchor = GridBagConstraints.EAST;
		gbc_lblGroupName.insets = new Insets(0, 0, 5, 5);
		gbc_lblGroupName.gridx = 0;
		gbc_lblGroupName.gridy = 4;
		contentPane.add(lblGroupName, gbc_lblGroupName);

		txtGroupname = new JTextField();
		GridBagConstraints gbc_txtGroupname = new GridBagConstraints();
		gbc_txtGroupname.insets = new Insets(0, 0, 5, 0);
		gbc_txtGroupname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGroupname.gridx = 1;
		gbc_txtGroupname.gridy = 4;
		contentPane.add(txtGroupname, gbc_txtGroupname);
		txtGroupname.setColumns(10);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 5;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblInfo = new JLabel("info");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 0;
		panel_1.add(lblInfo, gbc_lblInfo);

		btnCancel = new JButton("Cancel");

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 1;
		panel_1.add(btnCancel, gbc_btnCancel);

		btnUpdate = new JButton("Update");

		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdate.gridx = 2;
		gbc_btnUpdate.gridy = 1;
		panel_1.add(btnUpdate, gbc_btnUpdate);

		btnAdd = new JButton("Add");

		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 3;
		gbc_btnAdd.gridy = 1;
		panel_1.add(btnAdd, gbc_btnAdd);

		btnNext = new JButton("Next >");

		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 1;
		panel_1.add(btnNext, gbc_btnNext);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setModel(tbleModel);
		// scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		btnNext.setEnabled(Boolean.FALSE);

		addItemsintoComboBox(AppController.getAppController().getEventController().getEvent().getItems());

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// go to dashbord view

				if (table.getRowCount() > 0) {
					btnNext.setEnabled(Boolean.TRUE);
					AppController.getAppController().getParticipantContoller().getParticipantView()
							.setVisible(Boolean.FALSE);
					AppController.getAppController().getDashBoardController().getAppDashboardView()
							.setVisible(Boolean.TRUE);
					AppController.getAppController().setAppStatus(AppStatus.EVENT_CREATED);
				}

			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtParticipantname.getText().isEmpty() && !txtReferancenumber.getText().isEmpty()
						&& !txtGroupname.getText().isEmpty()) {

					// add participant

					Item item = ((ComboBoxItemWrapper) comboBoxItems.getSelectedItem()).getItem();
					Participant participant = new Participant(UUID.randomUUID().toString(),
							txtParticipantname.getText(), txtReferancenumber.getText(), txtGroupname.getText(), 0,
							new ArrayList<Vote>());
					AppController.getAppController().getParticipantContoller().addParticipant(item.getItemId(),
							participant);

					// update the view
					addItemsintoComboBox(AppController.getAppController().getEventController().getEvent().getItems());

					lblInfo.setText("Added successfully.");

					btnNext.setEnabled(Boolean.TRUE);
					clear();

				} else {
					lblInfo.setText("Please fill the form.");
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtParticipantname.getText().isEmpty() && !txtReferancenumber.getText().isEmpty()
						&& !txtGroupname.getText().isEmpty()) {

					// update participant

					Item item = ((ComboBoxItemWrapper) comboBoxItems.getSelectedItem()).getItem();
					Participant participant = new Participant((String) table.getValueAt(table.getSelectedRow(), 0),
							txtParticipantname.getText(), txtReferancenumber.getText(), txtGroupname.getText());

					AppController.getAppController().getParticipantContoller().updateParticipant(item.getItemId(),
							participant);

					// update the view
					addItemsintoComboBox(AppController.getAppController().getEventController().getEvent().getItems());

					lblInfo.setText("Updated successfully.");

					clear();

				} else {
					lblInfo.setText("Please fill the form.");
				}

			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (AppController.getAppController().getAppStatus().equals(AppStatus.EVENT_CREATING)) {

					int dialogResult = JOptionPane.showConfirmDialog(null,
							"Are you sure you wants to cancel adding participants?", "Warning",
							JOptionPane.YES_NO_OPTION);
					if (dialogResult == JOptionPane.YES_OPTION) {
						AppController.getAppController().setAppStatus(AppStatus.DEFAULT);
						AppController.getAppController().getParticipantContoller().getParticipantView()
								.setVisible(Boolean.FALSE);
						AppController.getAppController().setAppToDefaultMode();

					}
				} else {
					AppController.getAppController().getParticipantContoller().getParticipantView()
							.setVisible(Boolean.FALSE);

				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount() == 1) {

					txtParticipantname.setText((String) table.getValueAt(table.getSelectedRow(), 1));
					txtReferancenumber.setText((String) table.getValueAt(table.getSelectedRow(), 2));
					txtGroupname.setText((String) table.getValueAt(table.getSelectedRow(), 3));
				}
			}
		});

		comboBoxItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxItems.getItemCount() > 0) {

					updateParticipantTable(((ComboBoxItemWrapper) comboBoxItems.getSelectedItem()).getItem());
				}
			}
		});
	}

	public void updateParticipantTable(final Item item) {

		tbleModel.setRowCount(0);

		if (item.getParticipants().size() > 0) {

			for (Participant participant : item.getParticipants()) {

				Object[] objs = { participant.getParticipantId(), participant.getParticipantName(),
						participant.getRefNo(), participant.getGroupName(), participant.getVoteCount() };
				tbleModel.addRow(objs);

			}
		}
	}

	private void clear() {
		txtParticipantname.setText(null);
		txtReferancenumber.setText(null);
		txtGroupname.setText(null);

		comboBoxItems.setSelectedIndex(0);
	}

	private void setSelectedItem(String itemName) {
		Item item;

		for (int i = 0; i < comboBoxItems.getItemCount(); i++) {
			item = (Item) comboBoxItems.getItemAt(i);
			if (item.getName() == itemName) {
				comboBoxItems.setSelectedIndex(i);
				break;
			}
		}
	}

	private void addItemsintoComboBox(final List<Item> items) {

		comboBoxItems.removeAllItems();

		for (Item item : items) {
			comboBoxItems.addItem(new ComboBoxItemWrapper(item, item.getName()));
		}
		comboBoxItems.setSelectedIndex(0);

		updateParticipantTable(((ComboBoxItemWrapper) comboBoxItems.getSelectedItem()).getItem());

	}

	private class ComboBoxItemWrapper {
		private Item item;

		private String text;

		public ComboBoxItemWrapper(Item item, String text) {
			super();
			this.item = item;
			this.text = text;
		}

		public Item getItem() {
			return item;
		}

		@Override
		public String toString() {
			return text;
		}
	}

}
