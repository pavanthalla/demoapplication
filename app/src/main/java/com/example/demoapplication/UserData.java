package com.example.demoapplication;




public class UserData {
    private String fname;
    private String lname;
    private String age;
    private String country;
    private String gender;
    private String state;
    private String hometown;
    private String phnnum;
    private String telnum;
    public UserData(){}
    public UserData(String fname,String lname,String  age,String country,String gender,String state,String hometown,String phnnum,String telnum){
        this.fname=fname;
        this.lname=lname;
        this.age=age;
        this.country=country;
        this.gender=gender;
        this.state=state;
        this.hometown=hometown;
        this.phnnum=phnnum;
        this.telnum=telnum;

    }



    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhnnum() {
        return phnnum;
    }

    public void setPhnnum(String phnnum) {
        this.phnnum = phnnum;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telphn) {
        this.telnum = telnum;
    }
}
