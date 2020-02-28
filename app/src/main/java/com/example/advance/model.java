package com.example.advance;

import com.orm.SugarRecord;

public class model extends SugarRecord {
    private String name;
    private String age;

    public model() {
    }

    model(String name, String age) {
        this.name = name;
        this.age = age;
    }


    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
