package project.Util;

import java.util.Scanner;

public class prompt extends SystemPrint{

    static Scanner sc = new Scanner(System.in);

    public static String Input(String str){
        System.out.print(str+">");
        return sc.nextLine();
    }

    public static int InputInt(String str){
        System.out.print(str+">");
        return sc.nextInt();
    }
}
