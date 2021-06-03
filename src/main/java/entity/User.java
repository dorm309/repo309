package entity;

public class User {
    /*
    Definitions：用户id 用户名 密码
     */
    private int uid;
    private String username;
    private String password;

    /*
    Constructors
     */
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*
    Getters and Setters
     */
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
