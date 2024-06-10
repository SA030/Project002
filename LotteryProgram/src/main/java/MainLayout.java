package main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class MainLayout {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          MainLayout window = new MainLayout();
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
  public MainLayout() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setFont(frame.getContentPane().getFont()
        .deriveFont(frame.getContentPane().getFont().getStyle() | Font.BOLD));
    frame.getContentPane().setBackground(new Color(255, 255, 255));
    frame.setBounds(100, 100, 450, 300);
    frame.setTitle("Test Lottery");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 255, 255));
    frame.getContentPane().add(panel, BorderLayout.SOUTH);

    JButton btn1 = new JButton("예");
    btn1.setFont(btn1.getFont().deriveFont(btn1.getFont().getStyle() | Font.BOLD));
    btn1.setBackground(UIManager.getColor("CheckBox.light"));
    panel.add(btn1);

    JButton btn2 = new JButton("아니요");
    btn2.setFont(btn2.getFont().deriveFont(btn2.getFont().getStyle() | Font.BOLD));
    btn2.setBackground(UIManager.getColor("CheckBox.light"));
    panel.add(btn2);

    JPanel panel_4 = new JPanel();
    panel_4.setBackground(new Color(255, 255, 255));
    frame.getContentPane().add(panel_4, BorderLayout.CENTER);
    panel_4.setLayout(new BorderLayout(0, 0));

    JTextPane textPane = new JTextPane();
    textPane.setText("안녕하세요. 동행로또입니다.\r\n로또 구입을 위해선 회원가입이 필요합니다.\r\n회원가입을 진행하시겠습니까?");
    panel_4.add(textPane, BorderLayout.CENTER);

    membershipEvent(btn1, btn2);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.WHITE);
    frame.getContentPane().add(panel_1, BorderLayout.NORTH);

    JTextPane txtpnLottery_1 = new JTextPane();
    txtpnLottery_1.setFont(new Font("Nirmala UI", txtpnLottery_1.getFont().getStyle() | Font.BOLD,
        txtpnLottery_1.getFont().getSize() + 9));
    txtpnLottery_1.setText("LOTTERY");
    txtpnLottery_1.setForeground(UIManager.getColor("Button.focus"));
    panel_1.add(txtpnLottery_1);

  }

  /** Button Click Event : membership **/
  public void membershipEvent(JButton btn1, JButton btn2) {
    // YES
    btn1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        Membership m = Membership.getInstance();
        m.membershipGuide();
      }
    });

    // NO
    btn2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
      }
    });
  }

}
