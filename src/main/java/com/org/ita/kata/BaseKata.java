package com.org.ita.kata;

public abstract class BaseKata {
    @Override
    public String toString() {
        String[] names = this.getClass().toString().split("\\.");
        return names[names.length - 2];
    }
}
