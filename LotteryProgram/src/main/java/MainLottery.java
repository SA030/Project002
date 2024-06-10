package main.java;

public class MainLottery {
  public static void main(String[] args) {

    // 1st: Membership
    // Membership m = Membership.getInstance();
    // m.membershipGuide();

    // 2nd: Purchase
    Purchase p = Purchase.getInstance();
    p.purchaseQuestion();

    // 2-1: Loading
    Loading l = new Loading();
    l.loading();

    // 3rd: Random Lottery
    Lottery lt = new Lottery();
    lt.randomLotteryNum();

    // 4th: Result
    lt.lotteryNum();
    lt.result();
  }
}
