package ru.alex.models;

import java.util.List;

/**
 * Created by PC1 on 19.06.2017.
 */
public class User {
    private String login;
    private String email;
    private int id;
    private Role role;
    private List<Message> messages;

    public User() {
    }

    public User(final int id, final String login, final String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

