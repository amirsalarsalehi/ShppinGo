package com.example.shoppingo.utils;

import java.util.regex.Pattern;

public class Utility {

    public static boolean validate(String regex, String val) {
        return Pattern.compile(regex).matcher(val).matches();
    }

}
