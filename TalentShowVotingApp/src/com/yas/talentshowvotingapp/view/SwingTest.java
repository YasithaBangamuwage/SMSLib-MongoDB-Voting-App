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

	private JPanel panelCreating;
	private JScrollPane scrollPaneCreating;
	private JTextPane textPane1, textPane2;
	private JButton button1;

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(600, 600));

		panelCreating = new JPanel();
		scrollPaneCreating = new JScrollPane(panelCreating, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPaneCreating.setMinimumSize(new Dimension(160, 200));
		scrollPaneCreating.setPreferredSize(new Dimension(160, 200));

		textPane1 = new JTextPane();
		textPane1.setText("a\na");
		textPane2 = new JTextPane();
		textPane2.setText("b\nb");
		button1 = new JButton("+++");

		// ----------------- Left Panel Init -----------------------

		panelCreating.setLayout(new GridBagLayout());
		panelCreating.setBackground(Color.ORANGE);
		panelCreating.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 4, 4);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = c.weighty = 0;

		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		panelCreating.add(textPane1, c);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textPane1.setText(textPane1.getText() + "\na");
				textPane2.setText(textPane2.getText() + "\nb");
			}
		});
		panelCreating.add(button1, c);

		panelCreating.add(textPane2, c);

		// -------------------------------------------------------

		getContentPane().setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		c.ipadx = c.ipady = 0;
		c.insets = new Insets(0, 0, 0, 0);
		c.weighty = 0;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.weightx = 0;
		c.fill = GridBagConstraints.BOTH;
		getContentPane().add(scrollPaneCreating, c);
		
		
		

		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		getContentPane().add(new JLabel("test"), c);

	}
}
