package com.bignerdranch.android.bmob_sample_fast;

import org.w3c.dom.ProcessingInstruction;

import cn.bmob.v3.BmobObject;

/**
 * Created by jacob on 2017/5/6.
 */

public class Person extends BmobObject {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
