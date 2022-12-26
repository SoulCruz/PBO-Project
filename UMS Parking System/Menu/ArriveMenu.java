package Menu;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArriveMenu {
  String[] jenisKendaraan = { "Pilih Jenis", "Motor", "Mobil" };

  File nomorParkirFile = new File("Data/nomorParkir.txt");
  File jenisKendaraanFile = new File("Data/jenisKendaraan.txt");
  File waktuDatangFile = new File("Data/waktuDatang.txt");

  FileWriter nomorParkirWriter;
  FileWriter jenisKendaraanWriter;
  FileWriter waktuDatangWriter;

  JPanel arrivePanel = new JPanel();
  JLabel jenisKendaraanLabel = new JLabel("Jenis Kendaraan");
  JLabel parkirNomorLabel = new JLabel("Nomor Parkir");
  JLabel waktuKedatanganLabel = new JLabel("Waktu Kedatangan");
  JLabel arrivalWarningLabel = new JLabel("Data tidak boleh kosong");
  JButton setTimeButton = new JButton("Set Time");
  JButton prosesButton = new JButton("Proses");
  JComboBox jenisKendaraanBox = new JComboBox(jenisKendaraan);
  JTextField parkirNomorField = new JTextField();
  JTextField waktuKedatanganField = new JTextField();

  public ArriveMenu() {
    try {
      nomorParkirWriter = new FileWriter(nomorParkirFile, true);
      jenisKendaraanWriter = new FileWriter(jenisKendaraanFile, true);
      waktuDatangWriter = new FileWriter(waktuDatangFile, true);
    } catch (IOException e) {
      e.printStackTrace();
    }

    jenisKendaraanLabel.setBounds(100, 100, 200, 30);
    jenisKendaraanLabel.setFont(new Font(null, Font.BOLD, 20));
    jenisKendaraanLabel.setForeground(Color.WHITE);

    parkirNomorLabel.setBounds(100, 200, 200, 30);
    parkirNomorLabel.setFont(new Font(null, Font.BOLD, 20));
    parkirNomorLabel.setForeground(Color.WHITE);

    waktuKedatanganLabel.setBounds(100, 300, 200, 30);
    waktuKedatanganLabel.setFont(new Font(null, Font.BOLD, 20));
    waktuKedatanganLabel.setForeground(Color.WHITE);

    jenisKendaraanBox.setBounds(100, 150, 200, 30);
    jenisKendaraanBox.setFont(new Font(null, Font.PLAIN, 20));
    jenisKendaraanBox.setOpaque(true);
    jenisKendaraanBox.setForeground(Color.BLACK);
    jenisKendaraanBox.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    jenisKendaraanBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    jenisKendaraanBox.setFocusable(false);

    parkirNomorField.setBounds(100, 250, 200, 30);
    parkirNomorField.setFont(new Font(null, Font.PLAIN, 20));
    parkirNomorField.setOpaque(false);
    parkirNomorField.setForeground(Color.WHITE);
    parkirNomorField.setCaretColor(Color.WHITE);
    parkirNomorField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

    waktuKedatanganField.setBounds(100, 350, 200, 30);
    waktuKedatanganField.setFont(new Font(null, Font.PLAIN, 20));
    waktuKedatanganField.setOpaque(false);
    waktuKedatanganField.setForeground(Color.WHITE);
    waktuKedatanganField.setCaretColor(Color.WHITE);
    waktuKedatanganField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    waktuKedatanganField.setEditable(false);

    setTimeButton.setBounds(350, 350, 80, 30);
    setTimeButton.setFont(new Font(null, Font.PLAIN, 15));
    setTimeButton.setForeground(Color.BLACK);
    setTimeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    setTimeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    setTimeButton.setFocusable(false);
    setTimeButton.addActionListener((ActionListener) new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        waktuKedatanganField.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
      }
    });

    arrivalWarningLabel.setBounds(100, 400, 200, 30);
    arrivalWarningLabel.setFont(new Font(null, Font.ITALIC, 15));
    arrivalWarningLabel.setForeground(Color.RED);
    arrivalWarningLabel.setVisible(false);

    prosesButton.setBounds(100, 500, 200, 30);
    prosesButton.setFont(new Font(null, Font.PLAIN, 15));
    prosesButton.setForeground(Color.BLACK);
    prosesButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    prosesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    prosesButton.setFocusable(false);
    prosesButton.addActionListener((ActionListener) new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (parkirNomorField.getText().equals("") || waktuKedatanganField.getText().equals("")
            || jenisKendaraanBox.getSelectedItem().equals("Pilih Jenis")) {
          arrivalWarningLabel.setVisible(true);
        } else {
          arrivalWarningLabel.setVisible(false);
          JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

          String jenisKendaraan = jenisKendaraanBox.getSelectedItem().toString();
          String parkirNomor = parkirNomorField.getText();
          String waktuKedatangan = waktuKedatanganField.getText();

          try {
            nomorParkirWriter.write(parkirNomor + "\n");
            nomorParkirWriter.close();

            jenisKendaraanWriter.write(jenisKendaraan + "\n");
            jenisKendaraanWriter.close();

            waktuDatangWriter.write(waktuKedatangan + "\n");
            waktuDatangWriter.close();
          } catch (IOException ex) {
            ex.printStackTrace();
          }

          jenisKendaraanBox.setSelectedItem("Pilih Jenis");
          parkirNomorField.setText("");
          waktuKedatanganField.setText("");
        }
      }
    });

    arrivePanel.setBounds(60, 70, 725, 625);
    arrivePanel.setOpaque(false);
    arrivePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    arrivePanel.setVisible(false);
    arrivePanel.setLayout(null);
    arrivePanel.add(jenisKendaraanLabel);
    arrivePanel.add(parkirNomorLabel);
    arrivePanel.add(waktuKedatanganLabel);
    arrivePanel.add(jenisKendaraanBox);
    arrivePanel.add(parkirNomorField);
    arrivePanel.add(waktuKedatanganField);
    arrivePanel.add(setTimeButton);
    arrivePanel.add(arrivalWarningLabel);
    arrivePanel.add(prosesButton);
  }
}
