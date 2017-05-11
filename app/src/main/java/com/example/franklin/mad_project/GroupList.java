package com.example.franklin.mad_project;

/**
 * Created by franklin on 17/04/17.
 */

public class GroupList {
    private String title;
    private String description;
    private String amount;
    private String icon;

    public GroupList(String tit, String des, String amo, String icon){
        title = tit;
        description = des;
        amount = amo;
        this.icon = icon;
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
    public String getIcon() { return this.icon; }
}