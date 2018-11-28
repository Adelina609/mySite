package ru.kpfu.itis1.objects;

import java.util.Objects;

public class UserSimple {
    private String email;
    private String nickname;
    private String password;

    public UserSimple(String email, String password, String username) {
        this.email = email;
        this.password = password;
        nickname = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSimple user = (UserSimple) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }


    @Override
    public String toString() {
        return "User " +
                "email= '" + email;
    }
}