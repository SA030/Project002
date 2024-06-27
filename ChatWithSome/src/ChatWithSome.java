import java.util.Scanner;

public class ChatWithSome {

  static Scanner sc = new Scanner(System.in);

  public static void menu() {
    int ans = -1;

    System.out.print(printPage());
    while (!isValidateScanner(ans)) {
      try {
        ans = getAnswer();
        selectMenu(ans);
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] Please enter the number as a number");
      }
    }

    sc.close();
  }

  public static void selectMenu(int ans) {
    switch (ans) {
      case 1:
        return;
      case 2:
        return;
      case 3:
        return;
      case 4:
        return;
      case 0:
        System.out.printf("Exit\n");
        return;
      default:
        System.out.printf("[ERROR] Please enter a valid key\n");
    }
  }


  public static String printPage() {
    String str = "";

    str += String.format("+--------------------------------------------------------------+\n");
    str += String.format("|                         [%-10s]                         |\n", "TITLE");
    str += String.format("+--------------------------------------------------------------+\n");

    str += String.format("%5s %-20s %-20s\n", "No", "Name", "Member");
    str += String.format("\n");
    str += String.format("\n");
    str += String.format("\n");
    str += String.format(" [1]Create     [2]Info     [3]Enter     [4]Delete     [0]Exit\n");
    str += String.format("+--------------------------------------------------------------+\n");


    return str;
  }

  public static boolean isValidateScanner(int ans) {
    return (ans >= 0) && (ans < 5) ? true : false;
  }

  public static int getAnswer() {
    System.out.printf("Enter> ");
    String ans = scanner();
    int num = Integer.parseInt(ans);
    if (num == 0) {
      System.out.printf("Exit\n");
    }
    return num;
  }

  public static String scanner() {
    return sc.nextLine();
  }
}

