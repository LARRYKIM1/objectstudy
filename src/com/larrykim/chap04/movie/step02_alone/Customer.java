package com.larrykim.chap04.movie.step02_alone;

public class Customer {
    private String name;
    private String id;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + name + '\'' +
                '}';
    }
}
