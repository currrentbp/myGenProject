package com.currentbp.test.spring.singleton;

import org.springframework.stereotype.Service;

@Service
public class MySingletonBean {
    private String myField;

    public String getMyField() {
        return myField;
    }

    public void setMyField(String myField) {
        this.myField = myField;
    }

    public void useMyField(String currentName) {
        System.out.println("myField:" + myField + " thread:" + Thread.currentThread().hashCode()+" currentName:"+currentName);
    }
}
