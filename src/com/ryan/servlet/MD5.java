package com.ryan.servlet;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class MD5 {

    static String encodingMD5(String str){

        MessageDigest messageDigest;
        String result = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            BigInteger bi = new BigInteger(1, messageDigest.digest());
            result = bi.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    static boolean matching(String original, String compared) {

        return encodingMD5(compared).equals(original);

    }

}
