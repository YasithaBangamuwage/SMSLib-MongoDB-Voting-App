package com.yas.talentshowvotingapp.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.yas.talentshowvotingapp.other.PropertyHandler;

/**
 * @author YAS
 * @version 1.0
 * @category Used to connect with the mongoDB database.
 */
public class MongoDBManager {

	/**
	 * DB static instance.
	 */
	private static DB mongoMgr;

	/**
	 * Singleton method to get BD instance.
	 * 
	 * @return DB instance
	 */
	public static DB getInstance() {
		if (mongoMgr == null) {
			MongoClient mongo;
			try {
				// connect to mongodb server
				mongo = new MongoClient(PropertyHandler.getInstance().getStringValue("mongoClientLocalhost"),
						PropertyHandler.getInstance().getIntegerValue("mongoClientPort"));
				// connect with the database
				mongoMgr = mongo.getDB(PropertyHandler.getInstance().getStringValue("database"));
				// .out.println("Connect to database(talentShow) successfully");
			} catch (UnknownHostException e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}
		return mongoMgr;
	}
}