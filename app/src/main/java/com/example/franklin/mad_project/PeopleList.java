package com.example.franklin.mad_project;

/**
 * Created by franklin on 17/04/17.
 */

public class PeopleList {
    private String item;
    private String member;
    private String amount;
    private String date;
    private String group;

    public PeopleList(String ite, String mem, String amo, String dat, String gro){
        item = ite;
        member = mem;
        amount = amo;
        date = dat;
        group = gro;
    }
    public String getItem(){

        return item;
    }
    public String getMember(){

        return member;
    }
    public String getAmount(){

        return amount;
    }
    public String getDate(){
        return date;
    }
    public String getGroup(){
        return group;
    }
}