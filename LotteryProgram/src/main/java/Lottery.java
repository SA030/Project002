package main.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Lottery {

  // String rdm = "";
  int[] rdm = new int[10];
  int bonusrdm = 0;
  String[] rdms = new String[6];

  /** Random Num **/
  public static int random(int min, int max) {
    int num = (int) ((Math.random() * (max - min + 1)) + min);
    return num;
  }

  /** Random Num(0~9) **/
  public void randomLotteryNum() {
    int num = 0;

    for (int i = 0;;) {
      // rdm += random(0, 9);
      num = random(0, 9);

      if (i < 6) {
        if (this.rdm[num] == 0) {
          this.rdm[num] = 1;
          i++;
        }
      } else {
        if (this.rdm[num] == 0) {
          this.bonusrdm = num;
          return;
        }
      }
    }
  }

  /** Today Lottery Num **/
  public void lotteryNum() {
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////// SYSTEM MESAGE///////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    System.out.println("\n[INFO] 로또 당첨 번호 안내 드립니다.");
    System.out.println("\n★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
    System.out.println("★☆★☆★☆★☆★☆[" + printLotNum() + "+" + bonusrdm + "]★☆★☆★☆★☆★☆");
    System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");

    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Calendar time = Calendar.getInstance();

    String format_time1 = format1.format(time.getTime());
    System.out.println(format_time1);

    System.out.println("\n=================================================================\n");

    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
  }

  /** User Result **/
  public void result() {
    int ranking = 0;
    Membership m = Membership.getInstance();
    Purchase p = Purchase.getInstance();

    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////// SYSTEM MESAGE///////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    System.out.println("[INFO] " + m.name + "님의 당첨 결과 3초 후에 안내드립니다.");
    ranking = winLot(p.lotnum);

    Loading l = new Loading();
    l.loading();

    System.out.println("\n=================================================================\n");
    if (ranking > 0) {
      System.out.println("[INFO] " + m.name + "님의 로또번호는 " + p.printNum() + "입니다.");
      System.out.println("[INFO] 축하드립니다. " + ranking + "등에 당첨됐습니다.");
    } else {
      System.out.println("[INFO] " + m.name + "님의 로또번호는 " + p.printNum() + "입니다.");
      System.out.println("[INFO] 낙첨입니다. 다음 기회를 노려보세요.");
    }
    System.out.println("\n=================================================================\n");
    System.out.println("[INFO] 로또 추첨이 완료됐습니다. 감사합니다.");
    System.out.println("\n=================================================================");

    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
  }

  /** Print Lot Num data **/
  private String printLotNum() {
    String print = "";
    for (int i = 0; i < this.rdm.length; i++) {
      if (this.rdm[i] == 1) {
        print += i;
      }
    }
    return print;
  }


  /** Ranking **/
  private int winLot(int[] num) {
    int common = 0;

    for (int i = 0; i < rdm.length; i++) {
      if (num[i] == 1) {
        if (num[i] == this.rdm[i]) {
          common++;
        }
      }
    }

    // 1: same 6
    // 2: same 5+ plus 1
    // 3: same 5
    // 4: same 4
    // 5: same 3
    switch (common) {
      case 3:
        return 5;
      case 4:
        return 4;
      case 5:
        if (num[bonusrdm] == 1) {
          return 2;
        } else {
          return 3;
        }
      case 6:
        return 1;
      default:
        return 0;
    }
  }

}
