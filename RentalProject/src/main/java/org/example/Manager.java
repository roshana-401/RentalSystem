package org.example;

public class Manager
{
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String Address;
    private final int ManagerID;
    //////////////////////////////////////////////////constructor
    public Manager(String name, String phoneNumber, String email, String Address, int ManagerID) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email=email;
        this.Address=Address;
        this.ManagerID = ManagerID;
    }
    /////////////////////////////////////////////////getters


    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public int getManagerID() {
        return ManagerID;
    }

    @Override
    public String toString()
    {
        return "Id: "+this.ManagerID+"/"+"Name: "+this.name+"/"+"Email: "+this.email+"/"+"Phone: "+this.phoneNumber+"\n"+
                "\t"+"/"+"Address: "+this.Address;
    }
}
