package com.mind.loginregisterapps;

class User {
    String email;
    String Name;



    String VehicleNumber;


//passowrd

    public User(){

    }


    public User(String email, String name, String vehicleNumber) {
        this.email = email;
        Name = name;
        VehicleNumber = vehicleNumber;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }
}

