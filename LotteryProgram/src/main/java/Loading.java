package main.java;

public class Loading {
  public void loading() {
    try {
      for (int i = 3; i > 0; i--) {
        System.out.print(i + "... ");
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }
  }
}
