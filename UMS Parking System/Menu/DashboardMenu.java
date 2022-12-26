package Menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DashboardMenu {
  String data[][] = { { "1", "Motor", "12:00", "13:00", "" },
      { "2", "Mobil", "12:00", "13:00", "" } };
  String kolom[] = { "No", "Jenis", "Waktu Datang", "Waktu Pergi", "Total Bayar" };
  JPanel dashboardPanel = new JPanel();
  JTable dashboardTable = new JTable(data, kolom);
  JScrollPane dashboardScrollPane = new JScrollPane(dashboardTable);

  public DashboardMenu() {
    dashboardTable.setBounds(0, 0, 625, 525);
    dashboardTable.setOpaque(true);
    dashboardTable.setBackground(new Color(0, 0, 64));
    dashboardTable.setForeground(Color.WHITE);
    dashboardTable.setRowHeight(30);
    dashboardTable.setFont(new Font(null, Font.PLAIN, 15));
    dashboardTable.getTableHeader().setFont(new Font(null, Font.BOLD, 15));

    dashboardScrollPane.setBounds(50, 100, 625, 475);
    dashboardScrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    dashboardScrollPane.setOpaque(false);
    dashboardScrollPane.getViewport().setOpaque(false);
    dashboardScrollPane.getViewport().add(dashboardTable);

    dashboardPanel.setBounds(60, 70, 725, 625);
    dashboardPanel.setOpaque(false);
    dashboardPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    dashboardPanel.setVisible(true);
    dashboardPanel.setLayout(null);
    dashboardPanel.add(dashboardScrollPane);
  }
}
