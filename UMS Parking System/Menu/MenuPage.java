package Menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Login.IDPass;
import Login.LoginPage;

public class MenuPage {
  ArriveMenu arriveMenu = new ArriveMenu();
  DepartMenu departMenu = new DepartMenu();
  DashboardMenu dashboardMenu = new DashboardMenu();
  // Image
  Image UMS = new ImageIcon("Resources/Logo.png").getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);

  // Create Object
  JFrame frame = new JFrame("UMS Parking System");
  JPanel barPanel = new JPanel();
  JPanel contentPanel = new JPanel();

  JLabel titleLabel = new JLabel("Menu");
  JLabel arriveLabel = new JLabel("Arrive");
  JLabel departLabel = new JLabel("Depart");
  JLabel dashboardLabel = new JLabel("Dashboard");

  JButton arriveButton = new JButton("Arrive");
  JButton departButton = new JButton("Depart");
  JButton dashboardButton = new JButton("Dashboard");
  JButton logoutButton = new JButton("Logout");

  public MenuPage() {
    // Menubar
    titleLabel.setBounds(10, 10, 280, 250);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleLabel.setFont(new Font(null, Font.PLAIN, 25));
    titleLabel.setForeground(new Color(255, 255, 255));
    titleLabel.setIcon(new ImageIcon(UMS));
    titleLabel.setIconTextGap(10);
    titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
    titleLabel.setHorizontalTextPosition(JLabel.CENTER);

    arriveButton.setBounds(10, 280, 280, 50);
    arriveButton.setFont(new Font(null, Font.PLAIN, 20));
    arriveButton.setBackground(new Color(0, 0, 64));
    arriveButton.setForeground(new Color(255, 255, 255));
    arriveButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
    arriveButton.setFocusPainted(false);
    arriveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    arriveButton.addActionListener(e -> {
      arriveButton.setBackground(new Color(0, 0, 100));
      arriveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      arriveLabel.setVisible(true);
      arriveMenu.arrivePanel.setVisible(true);
      departButton.setBackground(new Color(0, 0, 64));
      departButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      departLabel.setVisible(false);
      departMenu.departPanel.setVisible(false);
      dashboardButton.setBackground(new Color(0, 0, 64));
      dashboardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      dashboardLabel.setVisible(false);
      dashboardMenu.dashboardPanel.setVisible(false);
    });

    departButton.setBounds(10, 340, 280, 50);
    departButton.setFont(new Font(null, Font.PLAIN, 20));
    departButton.setBackground(new Color(0, 0, 64));
    departButton.setForeground(new Color(255, 255, 255));
    departButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
    departButton.setFocusPainted(false);
    departButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    departButton.addActionListener(e -> {
      arriveButton.setBackground(new Color(0, 0, 64));
      arriveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      arriveLabel.setVisible(false);
      arriveMenu.arrivePanel.setVisible(false);
      departButton.setBackground(new Color(0, 0, 100));
      departButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      departLabel.setVisible(true);
      departMenu.departPanel.setVisible(true);
      dashboardButton.setBackground(new Color(0, 0, 64));
      dashboardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      dashboardLabel.setVisible(false);
      dashboardMenu.dashboardPanel.setVisible(false);
    });

    dashboardButton.setBounds(10, 400, 280, 50);
    dashboardButton.setFont(new Font(null, Font.PLAIN, 20));
    dashboardButton.setBackground(new Color(0, 0, 100));
    dashboardButton.setForeground(new Color(255, 255, 255));
    dashboardButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
    dashboardButton.setFocusPainted(false);
    dashboardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    dashboardButton.addActionListener(e -> {
      arriveButton.setBackground(new Color(0, 0, 64));
      arriveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      arriveLabel.setVisible(false);
      arriveMenu.arrivePanel.setVisible(false);
      departButton.setBackground(new Color(0, 0, 64));
      departButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      departLabel.setVisible(false);
      departMenu.departPanel.setVisible(false);
      dashboardButton.setBackground(new Color(0, 0, 100));
      dashboardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      dashboardLabel.setVisible(true);
      dashboardMenu.dashboardPanel.setVisible(true);
    });

    logoutButton.setBounds(10, 460, 280, 50);
    logoutButton.setFont(new Font(null, Font.PLAIN, 20));
    logoutButton.setBackground(new Color(0, 0, 64));
    logoutButton.setForeground(new Color(255, 255, 255));
    logoutButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
    logoutButton.setFocusPainted(false);
    logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    logoutButton.addActionListener(e -> {
      frame.dispose();
      IDPass idPass = new IDPass();
      new LoginPage(idPass.getLoginInfo());
    });

    barPanel.setBounds(10, 10, 300, 740);
    barPanel.setBackground(new Color(0, 0, 64));
    barPanel.setLayout(null);
    barPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
    barPanel.add(titleLabel);
    barPanel.add(arriveButton);
    barPanel.add(departButton);
    barPanel.add(dashboardButton);
    barPanel.add(logoutButton);

    // Content
    arriveLabel.setBounds(50, 50, 75, 40);
    arriveLabel.setFont(new Font(null, Font.PLAIN, 25));
    arriveLabel.setForeground(Color.WHITE);
    arriveLabel.setBackground(new Color(0, 0, 64));
    arriveLabel.setOpaque(true);
    arriveLabel.setVisible(false);

    departLabel.setBounds(50, 50, 80, 40);
    departLabel.setFont(new Font(null, Font.PLAIN, 25));
    departLabel.setForeground(Color.WHITE);
    departLabel.setBackground(new Color(0, 0, 64));
    departLabel.setOpaque(true);
    departLabel.setVisible(false);

    dashboardLabel.setBounds(50, 50, 125, 40);
    dashboardLabel.setFont(new Font(null, Font.PLAIN, 25));
    dashboardLabel.setForeground(Color.WHITE);
    dashboardLabel.setBackground(new Color(0, 0, 64));
    dashboardLabel.setOpaque(true);
    dashboardLabel.setVisible(true);

    contentPanel.setBounds(325, 10, 850, 740);
    contentPanel.setBackground(new Color(0, 0, 64));
    contentPanel.setLayout(null);
    contentPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
    contentPanel.add(arriveLabel);
    contentPanel.add(departLabel);
    contentPanel.add(dashboardLabel);
    contentPanel.add(arriveMenu.arrivePanel);
    contentPanel.add(departMenu.departPanel);
    contentPanel.add(dashboardMenu.dashboardPanel);

    // Frame
    frame.setIconImage(UMS);
    frame.setSize(1200, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setLayout(null);
    frame.getContentPane().setBackground(new Color(0, 0, 42));

    // Frame Components
    frame.add(barPanel);
    frame.add(contentPanel);
  }
}