package ru.kpfu.itis1.services;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class UserService {

    public static String md5Apache(String st) {
        return DigestUtils.md5Hex(st);
    }

    public static boolean checkEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}