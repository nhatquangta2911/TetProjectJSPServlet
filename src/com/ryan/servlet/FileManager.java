package com.ryan.servlet;

import com.ryan.model.User;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "/home/ryan-ta/Documents/data.txt";

    public void write(ArrayList<User> users) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public ArrayList<User> read() {

        ArrayList<User> users = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return users;
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
