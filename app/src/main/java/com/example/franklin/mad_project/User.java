package com.example.franklin.mad_project;

import java.util.List;

/**
 * Created by franklin on 27/04/17.
 */
public class User {
    public String email;
    public String name;
    public List<Group> groups;

    public User(String email, String name, List<Group> groups) {
        this.email = email;
        this.name = name;
        this.groups = groups;
    }
}
