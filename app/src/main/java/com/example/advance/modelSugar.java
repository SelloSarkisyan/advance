package com.example.advance;

import com.orm.SugarRecord;

public class modelSugar extends SugarRecord {

    String name;
    String age;

    public modelSugar() {
    }

    public modelSugar(String name, String age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
