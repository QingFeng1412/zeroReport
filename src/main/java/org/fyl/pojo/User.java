package org.fyl.pojo;

public class User {
    private String grade;
    private String userId;
    private String userPassword;

    public User() {
    }

    public User(String grade, String userId, String userPassword) {
        this.grade = grade;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "grade='" + grade + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
