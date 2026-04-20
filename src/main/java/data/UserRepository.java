package data;
import model.User;
import service.UserService;

import java.util.HashMap;

public class UserRepository {
    private UserService service;
    private HashMap<Integer, User> userDB;

    public UserRepository() {
        userDB = new HashMap<>();
        service = new UserService();
    }

    public void addUserToDB(User t_user) {
        userDB.put(t_user.id, t_user);
    }
    public boolean removeUserFromDB(User t_user) {
        if (userDB.containsKey(t_user.id)) {
            userDB.remove(t_user.id);
            return true;
        }
        return false;
    }
    public UserService getServiceObject() {
        return this.service;
    }
    public void displayAllUsersInDB() {
        this.userDB.forEach((key, value) -> {
            System.out.println("Key: " + key + "\nValue: " + value.name);
        });
    }
    public boolean displayUser(int key) {
        if (userDB.containsKey(key)) {
            User tUser = userDB.get(key);
            tUser.userInfo();
            return true;
        } else {
            System.out.println("User not found in database.");
            return false;
        }
    }
    public User getUser(int key) {
        if (userDB.containsKey(key)) {
            return userDB.get(key);
        } else {
            return null;
        }
    }
    public int databaseSize() {
        System.out.println("Database size: " + this.userDB.size());
        return this.userDB.size();
    }
    public void populateUserDB() {
        User[] list = this.getServiceObject().generateUserList();
        for (int i = 0; i < list.length; i++) {
            User tUser = list[i];
            this.addUserToDB(tUser);
        }
    }
}
