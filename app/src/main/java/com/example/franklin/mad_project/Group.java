package com.example.franklin.mad_project;

import java.util.List;

/**
 * Created by franklin on 27/04/17.
 */

public class Group {
    public String name;
    public String category;
    public List<Integer> users;

    public Group(String name, String category, List<Integer> users) {
        this.name = name;
        this.category = category;
        this.users = users;
    }
}