package com.example.mva8;

public class User {
    private String name;
    private String email;
    private String phone;
    private String documentId;

    public User(){}

    public String getDocumentId(){
        return documentId;
    }

    public void setDocumentId(String documentId){
        this.documentId = documentId;
    }

    public User(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone(){ return phone; }
}
