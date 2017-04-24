package com.example.franklin.mad_project;

import java.util.ArrayList;

/**
 * Created by franklin on 24/04/17.
 */

public class MemberList {
    private String member;
    private String amount;

    public MemberList(String mem, String amo){
        member = mem;
        amount = amo;
    }

    public String getMember() {
        return member;
    }

    public String getAmount() {
        return amount;
    }

    }
