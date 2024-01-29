package com.booleanuk.api;

public class Author {
    private static int nextID = 0;
    private int id;
    private String name;
    private String email;

    public Author(String name, String email) {
        nextID += 1;
        this.id = nextID;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
