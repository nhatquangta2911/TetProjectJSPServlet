package com.ryan.test;

public class TestMD5 {

    public static void main(String[] args) {

        MD5 lib = new MD5();

        String password = "123";
        String encodedPassword = lib.MD5(password);

        System.out.println("After encoding: " + encodedPassword);

    }
}