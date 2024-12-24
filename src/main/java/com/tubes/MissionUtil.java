package com.tubes;
import java.text.NumberFormat;
import java.util.Scanner;


public class MissionUtil {
    public static int getIntInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getStringInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static String moneyFormat(double price){
        return NumberFormat.getInstance().format(price);
    }
}
