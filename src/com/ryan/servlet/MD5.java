package com.ryan.servlet;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public String MD5(String str){

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

    boolean matching(String original, String compared) {

        String result;
        MessageDigest messageDigest;

        try {

            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(compared.getBytes());
            result = new BigInteger(1, messageDigest.digest()).toString(16);
            return result.equals(original);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

}
