package Login;

import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import Menu.MenuPage;

public class LoginPage implements ActionListener {

  HashMap<String, String> loginInfo = new HashMap<String, String>();
  // Image
  ImageIcon UMS = new ImageIcon("Resources/Logo.png");
  ImageIcon userImage = new ImageIcon("Resources/UserLogin.png");
  ImageIcon passImage = new ImageIcon("Resources/UserPass.png");
  ImageIcon loginImage = new ImageIcon("Resources/Login.jpg");

  // Create Object
  JLabel title = new JLabel();
  JLabel titleLabel = new JLabel();
  JLabel userLabel = new JLabel();
  JLabel passwordLabel = new JLabel();
  JLabel messageLabel = new JLabel();
  JLabel userImageLabel = new JLabel();
  JLabel passImageLabel = new JLabel();
  JLabel loginBackground = new JLabel();

  JButton loginButton = new JButton("Submit");

  JTextField usernameField = new JTextField();
  JPasswordField passwordField = new JPasswordField();

  JFrame frame = new JFrame("Login Page");

  JPanel panel1 = new JPanel();
  JPanel panel = new JPanel();

  // Constructor
  public LoginPage(HashMap<String, String> loginInfo) {
    this.loginInfo = loginInfo;

    // Key Listener
    usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          passwordField.requestFocus();
        }
      }
    });

    passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          loginButton.doClick();
        }
      }
    });

    // Label
    title.setText("UMS Parking System");
    title.setForeground(Color.white);
    title.setVerticalTextPosition(JLabel.BOTTOM);
    title.setHorizontalTextPosition(JLabel.CENTER);
    title.setFont(new Font(null, Font.PLAIN, 30));
    title.setIcon(UMS);
    title.setIconTextGap(10);
    title.setBounds(90, 30, 300, 250);

    titleLabel.setText("Login");
    titleLabel.setForeground(Color.white);
    titleLabel.setFont(new Font(null, Font.PLAIN, 30));
    titleLabel.setBounds(160, 30, 100, 50);

    userLabel.setText("Username");
    userLabel.setForeground(Color.white);
    userLabel.setFont(new Font(null, Font.PLAIN, 20));
    userLabel.setBounds(50, 100, 200, 30);

    passwordLabel.setText("Password");
    passwordLabel.setForeground(Color.white);
    passwordLabel.setFont(new Font(null, Font.PLAIN, 20));
    passwordLabel.setBounds(50, 200, 200, 20);

    messageLabel.setBounds(50, 270, 200, 20);
    messageLabel.setFont(new Font(null, Font.ITALIC, 20));

    // Image
    loginBackground.setIcon(loginImage);
    loginBackground.setBounds(0, 0, 1200, 800);

    userImageLabel.setIcon(userImage);
    userImageLabel.setBounds(5, 120, 28, 40);

    passImageLabel.setIcon(passImage);
    passImageLabel.setBounds(5, 220, 28, 40);

    // TextField
    usernameField.setFont(new Font(null, Font.PLAIN, 20));
    usernameField.setBounds(50, 130, 300, 30);
    passwordField.setFont(new Font(null, Font.PLAIN, 20));
    passwordField.setBounds(50, 225, 300, 30);

    // Button
    loginButton.setFont(new Font(null, Font.PLAIN, 20));
    loginButton.setForeground(Color.white);
    loginButton.setBounds(130, 320, 120, 35);
    loginButton.setFocusable(false);
    loginButton.addActionListener(this);
    loginButton.setBackground(new Color(0, 0, 60));
    loginButton.setBorder(BorderFactory.createEtchedBorder());
    loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    // Panel
    panel1.setBackground(new Color(0, 0, 102));
    panel1.setBounds(20, 300, 400, 400);
    panel1.setLayout(null);
    panel1.add(titleLabel);
    panel1.add(userLabel);
    panel1.add(passwordLabel);
    panel1.add(userImageLabel);
    panel1.add(passImageLabel);
    panel1.add(usernameField);
    panel1.add(passwordField);
    panel1.add(messageLabel);
    panel1.add(loginButton);

    panel.setBackground(new Color(0, 0, 60));
    panel.setBounds(20, 20, 440, 720);
    panel.setLayout(null);
    panel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
    panel.add(panel1);

    // Main Frame
    frame.setTitle("UMS Parking System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(1200, 800);
    frame.setIconImage(UMS.getImage());
    frame.getContentPane().setBackground(new Color(32, 32, 32));
    frame.setLayout(null);
    frame.setVisible(true);
    // Frame Components
    frame.add(title);
    frame.add(panel);
    frame.add(loginBackground);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == loginButton) {
      String username = usernameField.getText();
      String password = String.valueOf(passwordField.getPassword());

      if (loginInfo.containsKey(username)) {
        if (loginInfo.get(username).equals(password)) {
          messageLabel.setText("Login Succes");
          messageLabel.setForeground(Color.GREEN);
          MenuPage menu = new MenuPage();
          frame.dispose();
        } else if (password.equals("")) {
          messageLabel.setText("Please fill in all fields");
          messageLabel.setForeground(Color.RED);
        } else {
          messageLabel.setText("Wrong Password");
          messageLabel.setForeground(Color.RED);
        }
      } else if (username.equals("") || password.equals("")) {
        messageLabel.setText("Please fill in all fields");
        messageLabel.setForeground(Color.RED);
      } else {
        messageLabel.setText("Username not found");
        messageLabel.setForeground(Color.RED);
      }
    }
  }
}