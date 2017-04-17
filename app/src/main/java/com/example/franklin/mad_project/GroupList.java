package com.example.franklin.mad_project;

/**
 * Created by franklin on 17/04/17.
 */

public class GroupList {
    private String title;
    private String description;
    private String amount;

    public GroupList(String tit, String des, String amo){
        title = tit;
        description = des;
        amount = amo;
    }
    public String getTitle(){

        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getAmount(){
        return amount;
    }
}