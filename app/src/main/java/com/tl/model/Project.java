package com.tl.model;

public class Project {

    private int ID;
    private String Number;
    private String Name;
    private String Address;
    private String ProjectArea;

    public Project() {
    }

    public Project(int ID, String number, String name, String address, String projectArea) {
        this.ID = ID;
        Number = number;
        Name = name;
        Address = address;
        ProjectArea = projectArea;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProjectArea() {
        return ProjectArea;
    }

    public void setProjectArea(String projectArea) {
        ProjectArea = projectArea;
    }
}
