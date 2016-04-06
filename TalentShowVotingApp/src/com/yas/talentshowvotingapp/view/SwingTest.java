package com.yas.talentshowvotingapp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class SwingTest extends JFrame {

	public SwingTest() {
		initComponents();
		refreshItemScrollPane();
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SwingTest().setVisible(true);
			}
		});
	}

	private JPanel itemsDataPanel;
	private JScrollPane itemsScrollPane;
	private JPanel controllPanel = new JPanel();
	
	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(600, 450));

		itemsDataPanel = new JPanel();
		itemsScrollPane = new JScrollPane(itemsDataPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		itemsScrollPane.setMinimumSize(new Dimension(160, 350));
		itemsScrollPane.setPreferredSize(new Dimension(160, 350));

		
		
		
		

		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbcItemsScrollPane = new GridBagConstraints();

		gbcItemsScrollPane.ipadx = 0;
		gbcItemsScrollPane.ipady = 0;
		gbcItemsScrollPane.insets = new Insets(0, 0, 0, 0);
		gbcItemsScrollPane.weighty = 0;
		gbcItemsScrollPane.gridheight = 1;
		gbcItemsScrollPane.gridx = 0;
		gbcItemsScrollPane.gridy = 1;
		gbcItemsScrollPane.gridwidth = 1;
		gbcItemsScrollPane.weightx = 0;
		gbcItemsScrollPane.fill = GridBagConstraints.BOTH;
		getContentPane().add(itemsScrollPane, gbcItemsScrollPane);
		
		GridBagConstraints gbcControllPanel = new GridBagConstraints();
		
		gbcControllPanel.gridx = 0;
		gbcControllPanel.gridy = 0;
		gbcControllPanel.fill = GridBagConstraints.BOTH;
		gbcControllPanel.weightx = 1;
		gbcControllPanel.weighty = 1;
		getContentPane().add(controllPanel, gbcControllPanel);
		GridBagLayout gbl_controllPanel = new GridBagLayout();
		gbl_controllPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_controllPanel.rowHeights = new int[]{0, 0, 0};
		gbl_controllPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_controllPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		controllPanel.setLayout(gbl_controllPanel);
		
		JLabel lblDashboard = new JLabel("DashBoard");
		GridBagConstraints gbc_lblDashboard = new GridBagConstraints();
		gbc_lblDashboard.insets = new Insets(0, 0, 5, 5);
		gbc_lblDashboard.gridx = 0;
		gbc_lblDashboard.gridy = 0;
		controllPanel.add(lblDashboard, gbc_lblDashboard);
		
		JButton btnSyncVotes = new JButton("Sync Votes");
		GridBagConstraints gbc_btnSyncVotes = new GridBagConstraints();
		gbc_btnSyncVotes.insets = new Insets(0, 0, 0, 5);
		gbc_btnSyncVotes.gridx = 0;
		gbc_btnSyncVotes.gridy = 1;
		controllPanel.add(btnSyncVotes, gbc_btnSyncVotes);
		
		JButton btnAddParticipants = new JButton("Add Participants");
		GridBagConstraints gbc_btnAddParticipants = new GridBagConstraints();
		gbc_btnAddParticipants.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddParticipants.gridx = 1;
		gbc_btnAddParticipants.gridy = 1;
		controllPanel.add(btnAddParticipants, gbc_btnAddParticipants);
		
		JButton btnFinish = new JButton("Finish");
		GridBagConstraints gbc_btnFinish = new GridBagConstraints();
		gbc_btnFinish.gridx = 2;
		gbc_btnFinish.gridy = 1;
		controllPanel.add(btnFinish, gbc_btnFinish);
		
		

	}
	
	public void refreshItemScrollPane(){
		
		// ----------------- item data nned to run inside of the for loop -----------------------

				itemsDataPanel.setLayout(new GridBagLayout());
				itemsDataPanel.setBackground(Color.ORANGE);
				itemsDataPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

				Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
				
				Object columnNames[] = { "Column One", "Column Two", "Column Three" };
				JTable table = new JTable(rowData, columnNames);

				JScrollPane scrollPane = new JScrollPane(table);
				
				JLabel lblItemName = new JLabel("item name");
				

				GridBagConstraints gbcitemName = new GridBagConstraints();
				gbcitemName.insets = new Insets(0, 0, 4, 4);
				gbcitemName.anchor = GridBagConstraints.FIRST_LINE_START;
				gbcitemName.weightx = gbcitemName.weighty = 0;

				gbcitemName.gridx = 0;
				gbcitemName.gridy = GridBagConstraints.RELATIVE;
				gbcitemName.gridwidth = GridBagConstraints.REMAINDER;
				gbcitemName.gridheight = 1;
				gbcitemName.fill = GridBagConstraints.BOTH;
				itemsDataPanel.add(lblItemName, gbcitemName);
				
				GridBagConstraints gbcTableScrollPane = new GridBagConstraints();
				gbcTableScrollPane.insets = new Insets(0, 0, 4, 4);
				gbcTableScrollPane.anchor = GridBagConstraints.FIRST_LINE_START;
				gbcTableScrollPane.weightx = gbcTableScrollPane.weighty = 0;

				gbcTableScrollPane.gridx = 0;
				gbcTableScrollPane.gridy = GridBagConstraints.RELATIVE;
				gbcTableScrollPane.gridwidth = GridBagConstraints.REMAINDER;
				gbcTableScrollPane.gridheight = 1;
				gbcTableScrollPane.fill = GridBagConstraints.BOTH;
				itemsDataPanel.add(scrollPane, gbcTableScrollPane);
				
				
				
				
				
				
				JLabel lblItemName2 = new JLabel("item name 2");
				

				GridBagConstraints gbcitemName2 = new GridBagConstraints();
				gbcitemName2.insets = new Insets(0, 0, 4, 4);
				gbcitemName2.anchor = GridBagConstraints.FIRST_LINE_START;
				gbcitemName2.weightx = gbcitemName2.weighty = 0;

				gbcitemName2.gridx = 0;
				gbcitemName2.gridy = GridBagConstraints.RELATIVE;
				gbcitemName2.gridwidth = GridBagConstraints.REMAINDER;
				gbcitemName2.gridheight = 1;
				gbcitemName2.fill = GridBagConstraints.BOTH;
				itemsDataPanel.add(lblItemName2, gbcitemName2);
				
				
				JLabel lblItemName3 = new JLabel("item name 2");
				

				GridBagConstraints gbcitemName3 = new GridBagConstraints();
				gbcitemName3.insets = new Insets(0, 0, 4, 4);
				gbcitemName3.anchor = GridBagConstraints.FIRST_LINE_START;
				gbcitemName3.weightx = gbcitemName3.weighty = 0;

				gbcitemName3.gridx = 0;
				gbcitemName3.gridy = GridBagConstraints.RELATIVE;
				gbcitemName3.gridwidth = GridBagConstraints.REMAINDER;
				gbcitemName3.gridheight = 1;
				gbcitemName3.fill = GridBagConstraints.BOTH;
				itemsDataPanel.add(lblItemName3, gbcitemName3);
				
				
				
				Object rowData2[][] = { 
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row1-Column1", "Row1-Column2", "Row1-Column3" }, { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
						{ "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
				
				Object columnNames2[] = { "Column One", "Column Two", "Column Three" };
				JTable table2 = new JTable(rowData2, columnNames2);
				JScrollPane scrollPane2 = new JScrollPane(table2);
				GridBagConstraints gbcTableScrollPane2 = new GridBagConstraints();
				gbcTableScrollPane2.insets = new Insets(0, 0, 4, 4);
				gbcTableScrollPane2.anchor = GridBagConstraints.FIRST_LINE_START;
				gbcTableScrollPane2.weightx = gbcTableScrollPane2.weighty = 0;

				gbcTableScrollPane2.gridx = 0;
				gbcTableScrollPane2.gridy = GridBagConstraints.RELATIVE;
				gbcTableScrollPane2.gridwidth = GridBagConstraints.REMAINDER;
				gbcTableScrollPane2.gridheight = 1;
				gbcTableScrollPane2.fill = GridBagConstraints.BOTH;
				itemsDataPanel.add(scrollPane2, gbcTableScrollPane2);

				// -------------------------------------------------------//////////////
	}
}
