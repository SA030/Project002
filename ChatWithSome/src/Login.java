import java.util.Scanner;

public class Login {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int ans = -1;

    System.out.println(printPage());

    while (!isValidateScanner(ans)) {
      try {
        ans = getUserScanner(ans);
        menu(ans);
      } catch (NumberFormatException e) {
        System.out.println("Please enter the number as a number");
      }
    }
  }

  public static void menu(int ans) {
    switch (ans) {
      case 1:
        ChatWithSome.menu();
        return;
      case 2:
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

    str += String.format("+--------------------------------+\n");
    str += String.format("|          [%-10s]          |\n", "TITLE");
    str += String.format("+--------------------------------+\n");

    str += String.format(" [1]LogIN     [2]Join     [0]Exit\n");
    str += String.format("+--------------------------------+\n");

    return str;
  }

  public static boolean isValidateScanner(int ans) {
    return (ans >= 0) && (ans < 3) ? true : false;
  }

  public static int getUserScanner(int ans) {
    System.out.printf("Enter No> ");
    ans = Integer.parseInt(scanner());
    return ans;
  }

  public static String scanner() {
    return sc.nextLine();
  }
}
