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
import com.yas.talentshowvotingapp.other.AppStatus;
import javax.swing.JRadioButton;

public class ItemView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtItemname;
	private JTextField txtIteminfo;
	private JTable table;
	JButton btnNext;
	JButton btnDelete;
	JButton btnAdd;
	JButton btnUpdate;
	private String selectedItemId;
	private final DefaultTableModel tbleModel = new DefaultTableModel(
			new String[] { "Item Id", "Name", "Info", "Is Group" }, 0);
	private JButton btnCancel;
	private JLabel lblType;
	private JPanel panel_1;
	private JRadioButton rdbtnIsgroup;

	/**
	 * Create the frame.
	 */
	public ItemView() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 527, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblCreateItems = new JLabel("Create Items");
		GridBagConstraints gbc_lblCreateItems = new GridBagConstraints();
		gbc_lblCreateItems.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateItems.gridx = 0;
		gbc_lblCreateItems.gridy = 0;
		contentPane.add(lblCreateItems, gbc_lblCreateItems);

		JLabel lblItemName = new JLabel("Item Name");
		GridBagConstraints gbc_lblItemName = new GridBagConstraints();
		gbc_lblItemName.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName.anchor = GridBagConstraints.EAST;
		gbc_lblItemName.gridx = 0;
		gbc_lblItemName.gridy = 1;
		contentPane.add(lblItemName, gbc_lblItemName);

		txtItemname = new JTextField();
		GridBagConstraints gbc_txtItemname = new GridBagConstraints();
		gbc_txtItemname.insets = new Insets(0, 0, 5, 0);
		gbc_txtItemname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItemname.gridx = 1;
		gbc_txtItemname.gridy = 1;
		contentPane.add(txtItemname, gbc_txtItemname);
		txtItemname.setColumns(10);

		JLabel lblItemInfo = new JLabel("Item Info");
		GridBagConstraints gbc_lblItemInfo = new GridBagConstraints();
		gbc_lblItemInfo.anchor = GridBagConstraints.EAST;
		gbc_lblItemInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemInfo.gridx = 0;
		gbc_lblItemInfo.gridy = 2;
		contentPane.add(lblItemInfo, gbc_lblItemInfo);

		txtIteminfo = new JTextField();
		GridBagConstraints gbc_txtIteminfo = new GridBagConstraints();
		gbc_txtIteminfo.insets = new Insets(0, 0, 5, 0);
		gbc_txtIteminfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIteminfo.gridx = 1;
		gbc_txtIteminfo.gridy = 2;
		contentPane.add(txtIteminfo, gbc_txtIteminfo);
		txtIteminfo.setColumns(10);

		lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 3;
		contentPane.add(lblType, gbc_lblType);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		rdbtnIsgroup = new JRadioButton("IsGroup");
		GridBagConstraints gbc_rdbtnIsgroup = new GridBagConstraints();
		gbc_rdbtnIsgroup.gridx = 0;
		gbc_rdbtnIsgroup.gridy = 0;
		panel_1.add(rdbtnIsgroup, gbc_rdbtnIsgroup);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblInfo = new JLabel("info");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 0;
		panel.add(lblInfo, gbc_lblInfo);

		btnCancel = new JButton("Cancel");

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 1;
		panel.add(btnCancel, gbc_btnCancel);

		btnDelete = new JButton("Delete");

		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 1;
		panel.add(btnDelete, gbc_btnDelete);

		btnUpdate = new JButton("Update");

		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdate.gridx = 2;
		gbc_btnUpdate.gridy = 1;
		panel.add(btnUpdate, gbc_btnUpdate);

		btnAdd = new JButton("Add");

		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 3;
		gbc_btnAdd.gridy = 1;
		panel.add(btnAdd, gbc_btnAdd);

		btnNext = new JButton("Next >");

		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 1;
		panel.add(btnNext, gbc_btnNext);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();

		// make model to set

		table.setModel(tbleModel);

		scrollPane.setViewportView(table);
		btnNext.setEnabled(Boolean.FALSE);

		/************ events goes here *******************/

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtItemname.getText().isEmpty() && !txtIteminfo.getText().isEmpty()) {

					// add item to db
					AppController.getAppController().getItemController()
							.addItem(new Item(UUID.randomUUID().toString(), txtIteminfo.getText(),
									txtItemname.getText(), rdbtnIsgroup.isSelected(), new ArrayList<Participant>()));
					// add added item into table

					updateItemTable(AppController.getAppController().getItemController().getItems());

					lblInfo.setText("Added successfully.");
					btnNext.setEnabled(Boolean.TRUE);

					clear();

				} else {
					lblInfo.setText("Please fill the form.");
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getRowCount() > 0) {
					// get ParticipantView
					AppController.getAppController().getItemController().getItemView().setVisible(Boolean.FALSE);
					AppController.getAppController().getParticipantContoller().getParticipantView()
							.setVisible(Boolean.TRUE);
				} else {
					lblInfo.setText("Please Add Items! ");
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount() == 1) {

					selectedItemId = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);

					txtItemname.setText((String) table.getValueAt(table.getSelectedRow(), 1));
					txtIteminfo.setText((String) table.getValueAt(table.getSelectedRow(), 2));

					rdbtnIsgroup.setSelected((boolean) table.getValueAt(table.getSelectedRow(), 3));
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtItemname.getText().isEmpty() && !txtIteminfo.getText().isEmpty()) {

					// update item to db
					AppController.getAppController().getItemController().updateItem(new Item(selectedItemId,
							txtIteminfo.getText(), txtItemname.getText(), rdbtnIsgroup.isSelected()));
					// update table

					updateItemTable(AppController.getAppController().getItemController().getItems());

					lblInfo.setText("Updated successfully.");
					btnNext.setEnabled(Boolean.TRUE);
					clear();
				} else {
					lblInfo.setText("Please fill the form.");
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRowCount() == 1) {

					Boolean check = AppController.getAppController().getItemController()
							.deleteItem((String) table.getValueAt(table.getSelectedRow(), 0));

					if (check) {
						lblInfo.setText("Deleted.");
						updateItemTable(AppController.getAppController().getItemController().getItems());
						clear();

					} else {
						lblInfo.setText("Can not delete. Participants available.");
					}
				} else {
					lblInfo.setText("Please select one row to delete.");
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (AppController.getAppController().getAppStatus().equals(AppStatus.EVENT_CREATING)) {

					int dialogResult = JOptionPane.showConfirmDialog(null,
							"Are you sure you wants to cancel this items creating ?", "Warning",
							JOptionPane.YES_NO_OPTION);
					if (dialogResult == JOptionPane.YES_OPTION) {
						AppController.getAppController().setAppStatus(AppStatus.DEFAULT);
						AppController.getAppController().getItemController().getItemView().setVisible(Boolean.FALSE);
						AppController.getAppController().setAppToDefaultMode();

					}
				} else {
					AppController.getAppController().getItemController().getItemView().setVisible(Boolean.FALSE);

				}

			}
		});

	}

	public void updateItemTable(final List<Item> items) {

		tbleModel.setRowCount(0);

		if (!items.isEmpty()) {

			for (Item item : items) {

				Object[] objs = { item.getItemId(), item.getName(), item.getItemInfo(), item.isGroup() };
				tbleModel.addRow(objs);

			}
			// table.removeColumn(table.getColumnModel().getColumn(0));
		}
	}

	private void clear() {
		txtItemname.setText(null);
		txtIteminfo.setText(null);
	}

}
