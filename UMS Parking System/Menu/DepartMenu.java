package Menu;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepartMenu {
  File nomorParkirFile = new File("Data/nomorParkir.txt");
  File jenisKendaraanFile = new File("Data/jenisKendaraan.txt");
  File waktuDatangFile = new File("Data/waktuDatang.txt");
  File waktuKeluarFile = new File("Data/waktuKeluar.txt");
  File totalBayarFile = new File("Data/totalBayar.txt");

  FileWriter waktuKeluarW;
  FileReader nomorParkirR;
  FileReader jenisKendaraanR;
  FileReader waktuDatangR;
  FileReader totalBayarR;

  BufferedReader nomorParkirBR;

  String nomorParkir;
  String[] lines;

  Scanner nomorParkirScanner;

  JPanel departPanel = new JPanel();
  JLabel parkirNomorDepartLabel = new JLabel("Nomor Parkir");
  JLabel waktuPergiLabel = new JLabel("Waktu Pergi");
  JLabel totalBayarLabel = new JLabel("Total");
  JLabel departWarningLabel = new JLabel();
  JLabel departWarningLabel2 = new JLabel();
  JButton proses2Button = new JButton("Proses");
  JButton bayarButton = new JButton("Bayar");
  JTextField parkirNomorDepartField = new JTextField();
  JTextField waktuPergiField = new JTextField();
  JTextField totalBayarField = new JTextField();

  public DepartMenu() {
    try {
      nomorParkirR = new FileReader(nomorParkirFile);
      jenisKendaraanR = new FileReader(jenisKendaraanFile);
      waktuDatangR = new FileReader(waktuDatangFile);
      waktuKeluarW = new FileWriter(waktuKeluarFile, true);
      totalBayarR = new FileReader(totalBayarFile);

      nomorParkirBR = new BufferedReader(nomorParkirR);

      nomorParkirScanner = new Scanner(nomorParkirR);
    } catch (Exception e) {
      System.out.println(e);
    }

    parkirNomorDepartLabel.setBounds(130, 100, 200, 30);
    parkirNomorDepartLabel.setFont(new Font(null, Font.BOLD, 20));
    parkirNomorDepartLabel.setForeground(Color.WHITE);

    parkirNomorDepartField.setBounds(130, 150, 200, 30);
    parkirNomorDepartField.setFont(new Font(null, Font.PLAIN, 20));
    parkirNomorDepartField.setOpaque(false);
    parkirNomorDepartField.setForeground(Color.WHITE);
    parkirNomorDepartField.setCaretColor(Color.WHITE);
    parkirNomorDepartField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

    departWarningLabel.setBounds(130, 200, 300, 30);
    departWarningLabel.setFont(new Font(null, Font.ITALIC, 15));
    departWarningLabel.setForeground(Color.RED);
    departWarningLabel.setVisible(false);

    proses2Button.setBounds(130, 250, 200, 30);
    proses2Button.setFont(new Font(null, Font.PLAIN, 15));
    proses2Button.setForeground(Color.BLACK);
    proses2Button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    proses2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    proses2Button.setFocusable(false);
    proses2Button.addActionListener((ActionListener) new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (parkirNomorDepartField.getText().equals("")) {
          departWarningLabel.setText("Nomor Parkir tidak boleh kosong");
          departWarningLabel.setVisible(true);
        } else {
          try {
            while ((nomorParkir = nomorParkirBR.readLine()) != null) {
              if (parkirNomorDepartField.getText().equals(nomorParkir)) {
                departWarningLabel.setVisible(false);
                waktuPergiField.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
                totalBayarField.setText("Rp. 10.000");
                parkirNomorDepartField.setEditable(false);
                break;
              } else {
                departWarningLabel.setText("Nomor Parkir tidak ditemukan");
                departWarningLabel.setVisible(true);
              }
            }
          } catch (IOException e1) {
            e1.printStackTrace();
          }

          // if (parkirNomorDepartField.getText().equals("")) {
          // departWarningLabel.setText("Nomor Parkir tidak ditemukan");
          // departWarningLabel.setVisible(true);
          // } else {
          // departWarningLabel.setVisible(false);
          // waktuPergiField.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
          // totalBayarField.setText("Rp. 10.000");
          // parkirNomorDepartField.setEditable(false);
          // }
        }
      }
    });

    waktuPergiLabel.setBounds(130, 350, 200, 30);
    waktuPergiLabel.setFont(new Font(null, Font.BOLD, 20));
    waktuPergiLabel.setForeground(Color.WHITE);

    waktuPergiField.setBounds(130, 400, 200, 30);
    waktuPergiField.setFont(new Font(null, Font.PLAIN, 20));
    waktuPergiField.setOpaque(false);
    waktuPergiField.setForeground(Color.WHITE);
    waktuPergiField.setCaretColor(Color.WHITE);
    waktuPergiField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    waktuPergiField.setEditable(false);

    totalBayarLabel.setBounds(400, 350, 200, 30);
    totalBayarLabel.setFont(new Font(null, Font.BOLD, 20));
    totalBayarLabel.setForeground(Color.WHITE);

    totalBayarField.setBounds(400, 400, 200, 30);
    totalBayarField.setFont(new Font(null, Font.PLAIN, 20));
    totalBayarField.setOpaque(false);
    totalBayarField.setForeground(Color.WHITE);
    totalBayarField.setCaretColor(Color.WHITE);
    totalBayarField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    totalBayarField.setEditable(false);

    departWarningLabel2.setBounds(250, 450, 300, 30);
    departWarningLabel2.setFont(new Font(null, Font.ITALIC, 15));
    departWarningLabel2.setForeground(Color.RED);
    departWarningLabel2.setVisible(false);

    bayarButton.setBounds(250, 500, 200, 30);
    bayarButton.setFont(new Font(null, Font.PLAIN, 15));
    bayarButton.setForeground(Color.BLACK);
    bayarButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    bayarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    bayarButton.setFocusable(false);
    bayarButton.addActionListener((ActionListener) new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (parkirNomorDepartField.getText().equals("")) {
          departWarningLabel2.setText("Silahkan isi nomor parkir");
          departWarningLabel2.setVisible(true);
        } else if (waktuPergiField.getText().equals("")) {
          departWarningLabel2.setVisible(true);
          departWarningLabel2.setText("Silahkan tekan tombol proses");
        } else {
          departWarningLabel2.setVisible(false);
          parkirNomorDepartField.setText("");
          waktuPergiField.setText("");
          totalBayarField.setText("");
          parkirNomorDepartField.setEditable(true);
        }
      }
    });

    departPanel.setBounds(60, 70, 725, 625);
    departPanel.setOpaque(false);
    departPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    departPanel.setVisible(false);
    departPanel.setLayout(null);
    departPanel.add(parkirNomorDepartLabel);
    departPanel.add(parkirNomorDepartField);
    departPanel.add(departWarningLabel);
    departPanel.add(proses2Button);
    departPanel.add(waktuPergiLabel);
    departPanel.add(waktuPergiField);
    departPanel.add(totalBayarLabel);
    departPanel.add(totalBayarField);
    departPanel.add(departWarningLabel2);
    departPanel.add(bayarButton);
  }
}
