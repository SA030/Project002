package main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class MembershipLayout {

  private JFrame frame;
  private JPanel mainPanel;
  private JPanel sidePanel;
  private JButton btn1;
  private JButton btn2;
  private JPanel name;
  private JTextPane textPane;
  private JTextField textField;
  private JPanel YYDDMM;
  private JTextPane textPane_1;
  private JComboBox comboBox;
  private JTextPane textPane_2;
  private JComboBox comboBox_1;
  private JTextPane textPane_3;
  private JComboBox comboBox_2;
  private JTextPane textPane_4;
  private JPanel add;
  private JTextPane textPane_5;
  private JTextField textField_1;
  private JPanel pw;
  private JTextPane textPane_6;
  private JPanel panel;
  private JTextPane txtpnLottery;
  private JPasswordField passwordField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          MembershipLayout window = new MembershipLayout();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public MembershipLayout() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(new Color(255, 255, 255));

    mainPanel = new JPanel();
    mainPanel.setBackground(UIManager.getColor("Button.highlight"));
    frame.getContentPane().add(mainPanel, BorderLayout.NORTH);
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    panel = new JPanel();
    panel.setBackground(new Color(255, 255, 255));
    mainPanel.add(panel);

    txtpnLottery = new JTextPane();
    txtpnLottery.setFont(new Font("Nirmala UI", txtpnLottery.getFont().getStyle() | Font.BOLD,
        txtpnLottery.getFont().getSize() + 9));
    txtpnLottery.setText("LOTTERY");
    txtpnLottery.setForeground(UIManager.getColor("Button.focus"));
    panel.add(txtpnLottery);

    name = new JPanel();
    mainPanel.add(name);
    name.setBackground(Color.WHITE);

    textPane = new JTextPane();
    textPane.setText("이름");
    textPane.setFont(textPane.getFont().deriveFont(textPane.getFont().getStyle() | Font.BOLD, 12f));
    textPane.setBackground((Color) null);

    textField = new JTextField();
    textField.setColumns(10);
    name.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
    name.add(textPane);
    name.add(textField);

    YYDDMM = new JPanel();
    YYDDMM.setBackground(Color.WHITE);
    mainPanel.add(YYDDMM);

    textPane_1 = new JTextPane();
    textPane_1.setText("생일");
    textPane_1
        .setFont(textPane_1.getFont().deriveFont(textPane_1.getFont().getStyle() | Font.BOLD));

    comboBox = new JComboBox();
    comboBox.setBackground(Color.WHITE);
    for (int YY = 2024; YY >= 1900; YY--) {
      comboBox.addItem(String.valueOf(YY));
    }

    textPane_2 = new JTextPane();
    textPane_2.setText("년");

    comboBox_1 = new JComboBox();
    comboBox_1.setBackground(Color.WHITE);
    for (int MM = 1; MM <= 12; MM++) {
      comboBox_1.addItem(String.valueOf(MM));
    }

    textPane_3 = new JTextPane();
    textPane_3.setText("월");

    comboBox_2 = new JComboBox();
    comboBox_2.setBackground(Color.WHITE);
    for (int DD = 1; DD <= 31; DD++) {
      comboBox_2.addItem(String.valueOf(DD));
    }

    textPane_4 = new JTextPane();
    textPane_4.setText("일");
    YYDDMM.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
    YYDDMM.add(textPane_1);
    YYDDMM.add(comboBox);
    YYDDMM.add(textPane_2);
    YYDDMM.add(comboBox_1);
    YYDDMM.add(textPane_3);
    YYDDMM.add(comboBox_2);
    YYDDMM.add(textPane_4);

    add = new JPanel();
    add.setBackground(Color.WHITE);
    mainPanel.add(add);
    add.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

    textPane_5 = new JTextPane();
    textPane_5.setText("주소");
    textPane_5
        .setFont(textPane_5.getFont().deriveFont(textPane_5.getFont().getStyle() | Font.BOLD));
    add.add(textPane_5);

    textField_1 = new JTextField();
    textField_1.setColumns(30);
    add.add(textField_1);

    pw = new JPanel();
    pw.setBackground(new Color(255, 255, 255));
    mainPanel.add(pw);
    pw.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

    textPane_6 = new JTextPane();
    textPane_6.setText("비번");
    textPane_6
        .setFont(textPane_6.getFont().deriveFont(textPane_6.getFont().getStyle() | Font.BOLD));
    pw.add(textPane_6);

    passwordField = new JPasswordField();
    passwordField.setColumns(10);
    pw.add(passwordField);

    sidePanel = new JPanel();
    sidePanel.setBackground(UIManager.getColor("Button.highlight"));
    frame.getContentPane().add(sidePanel, BorderLayout.SOUTH);

    btn1 = new JButton("예");
    sidePanel.add(btn1);
    btn1.setFont(btn1.getFont().deriveFont(btn1.getFont().getStyle() | Font.BOLD));
    btn1.setBackground(new Color(255, 255, 255));

    btn2 = new JButton("아니요");
    sidePanel.add(btn2);
    btn2.setFont(btn2.getFont().deriveFont(btn2.getFont().getStyle() | Font.BOLD));
    btn2.setBackground(new Color(255, 255, 255));
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
