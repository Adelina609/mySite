package ru.kpfu.itis1.services;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;

public class UserService {

    private static ArrayList<String> emailPasswDB = new ArrayList<>();
    private static ArrayList<String> dataDB = new ArrayList<>();

    public static boolean checkEmailPassw(String email, String password){
        initDb();
        System.out.println("in check");
        return emailPasswDB.contains(md5Apache(email+password));
    }

    public static boolean checkData(String email){
        initDb();
        return dataDB.contains(md5Apache(email));

    }

    public static String md5Apache(String st) {
        return DigestUtils.md5Hex(st);
    }

    public static boolean isAdmin(String email, String password){
        return emailPasswDB.get(0).equals(md5Apache(email+password));
    }




    private static void initDb(){
        emailPasswDB.add(md5Apache("admin"+"pass"));
        emailPasswDB.add(md5Apache("user"+"123456"));
        dataDB.add(md5Apache("admin"));
        dataDB.add(md5Apache("user"));
    }

//    public static boolean checkEmail(String email) {
//
//
////        Matcher emMatch = emailExp.matcher(email);
////        return emMatch.matches();
//    }
//
//    public static boolean checkPassword(String pass){
////        Matcher passMatch = passExp.matcher(pass);
////        return passMatch.matches();
//    }

}