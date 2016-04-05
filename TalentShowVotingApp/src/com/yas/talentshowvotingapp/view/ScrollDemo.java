package com.yas.talentshowvotingapp.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ScrollDemo extends JFrame {

  JScrollPane scrollpane;

  public ScrollDemo() {
    super("JScrollPane Demonstration");
    setSize(300, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    init();
    setVisible(true);
  }

  public void init() {
    JRadioButton form[][] = new JRadioButton[12][5];
    String counts[] = { "", "0-1", "2-5", "6-10", "11-100", "101+" };
    String categories[] = { "Household", "Office", "Extended Family",
        "Company (US)", "Company (World)", "Team", "Will",
        "Birthday Card List", "High School", "Country", "Continent",
        "Planet" };
    JPanel p = new JPanel();
    p.setSize(600, 400);
    p.setLayout(new GridLayout(13, 6, 10, 0));
   
    p.add(new JLabel("fff"));
     
    scrollpane = new JScrollPane(p);
    getContentPane().add(scrollpane, BorderLayout.CENTER);
  }

  public static void main(String args[]) {
    new ScrollDemo();
  }
}