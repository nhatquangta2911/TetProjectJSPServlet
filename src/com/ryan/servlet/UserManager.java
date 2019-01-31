package com.ryan.servlet;

import com.ryan.model.User;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users;
    private FileManager fileManager;

    public UserManager() {
        fileManager = new FileManager();
        users = fileManager.read();
        // Add file handling code here
        // ...
    }

    public User getUser(String needToGetEmailAddress) {
        for (User user : users) {
            if (user.getEmailAddress().equals(needToGetEmailAddress)) {
                return user;
            }
        }
        return null;
    }

    public boolean isExist(User newUser) {
        for (User user : users) {
            if (user.getEmailAddress().equals(newUser.getEmailAddress())) {
                return true;
            }
        }
        return false;
    }

    public boolean addUser(User user) {
        if (isExist(user)) {
            return false;
        } else {
            users.add(user);
            fileManager.write(users);
            return true;
        }
    }

    public boolean editUser(String needToEditEmailAddress, String needToEditFullName, String needToEditDateOfBirth, boolean needToEditGender) {

        if (!isExist(getUser(needToEditEmailAddress))) {
            return false;
        } else {
            getUser(needToEditEmailAddress).setFullName(needToEditFullName);
            getUser(needToEditEmailAddress).setDateOfBirth(needToEditDateOfBirth);
            getUser(needToEditEmailAddress).setGender(needToEditGender);
            fileManager.write(users);
            return true;
        }
    }

    boolean removeUser(String needToRemoveEmailAddress) {
        if (!isExist(getUser(needToRemoveEmailAddress))) {
            return false;
        } else {
            users.remove(getUser(needToRemoveEmailAddress));
            fileManager.write(users);
            return false;
        }
    }

    public boolean changePassword(String needToChangePasswordEmailAddress, String newPassword) {
        if (!isExist(getUser(needToChangePasswordEmailAddress))) {
            return false;
        } else {
            getUser(needToChangePasswordEmailAddress).setPassword(newPassword);
            fileManager.write(users);
            return true;
        }
    }
}
