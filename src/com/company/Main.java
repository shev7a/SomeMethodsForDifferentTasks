package com.company;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println(validatePIN("3451"));
        //System.out.println(generateINN());
        //System.out.println(generatePhoneNumber());
        //System.out.println(getCurrentDate());
        //System.out.println(getCurrentDate2());
        //System.out.println(getTimestamp());
        Scanner sc = new Scanner(System.in);
        String coordinates = sc.nextLine();
        parseCoordinates(coordinates);
    }

    public static boolean validatePIN(String s) {
        int len = s.length();
        if (len != 4 && len != 6) return false;
        s = s.replaceAll("[^0-9]","");
        System.out.println(s);
        if (s.length() != len) return false;
        else return true;
    }

    public static String generateINN() {
        String res = "";
        int num;
        for (int i = 0; i < 11; i++) {
            num = (int) (Math.random()*10);
            res = res.concat(String.valueOf(num));
        }
        return res;
    }

    public static String generatePhoneNumber() {
        String res = "89";
        int num;
        for (int i = 0; i < 9; i++) {
            num = (int) (Math.random()*10);
            res = res.concat(String.valueOf(num));
        }
        return res;
    }

    public static void delNull(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].endsWith(".0")) {
                arr[i] = arr[i].substring(0, arr[i].length() - 2);
            }
        }
    }

    public static String getCurrentDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
        return dateTime.format(formatter);
    }

    public static String  getCurrentDate2() {
        ZonedDateTime localTime = ZonedDateTime.now(ZoneId.systemDefault());
        String date = localTime.toString();
        date = date.substring(0, date.indexOf('['));
        return date;
    }

    public static String getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }

    public static double SKF (double k, double alfa, double y, double kreat, double old) {
        double result;
        result = 141 * Math.pow(Math.min(kreat/88.4/k, 1), alfa) * Math.pow(Math.max(kreat/88.4/k, 1), (-1.209))
                * Math.pow(0.993, old) * y;
        return result;
    }

    public static void parseCoordinates(String coordinates) {
        coordinates = coordinates.replaceAll("\\.", ",");
        coordinates = coordinates.replaceAll("],\\[", "]\n[");
        System.out.println(coordinates);
    }
}
