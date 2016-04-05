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
	
	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(600, 600));

		itemsDataPanel = new JPanel();
		itemsScrollPane = new JScrollPane(itemsDataPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		itemsScrollPane.setMinimumSize(new Dimension(160, 200));
		itemsScrollPane.setPreferredSize(new Dimension(160, 200));

		
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

		// -------------------------------------------------------//////////////
		
		

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
		getContentPane().add(new JLabel("test"), gbcControllPanel);

	}
}
