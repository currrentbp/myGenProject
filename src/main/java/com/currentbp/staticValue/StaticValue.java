package com.currentbp.staticValue;

/**
 * Created by issuser on 2016/12/23.
 */
public enum StaticValue {

    IS_TRUE(1,"真"),
    IS_FALSE(0,"假"),

    START_INDEX(0,"开始位置"),
    START_INDEX_NATURAL(1,"自然中开始位置"),

    ;


    public final int value;
    public final String name;

    StaticValue(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getName(int value) {
        for (StaticValue ownerValue : StaticValue.values()) {
            if (ownerValue.value == value) {
                return ownerValue.name;
            }
        }

        return null;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
