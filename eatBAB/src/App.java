
import Command.MemberShip;


public class App {

  public static void main(String[] args) {
    // 1st: Membership
    MemberShip login = MemberShip.getInstance();
    login.membershipGuide();
  }

}
