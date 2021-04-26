package model;

import javafx.beans.property.*;

public class Customer {
    private StringProperty name;
    private StringProperty cmnd;
    private StringProperty phoneNumber;
    private StringProperty address;
    private IntegerProperty age;


    //Constructor
    public Customer() {
        this.name = new SimpleStringProperty();
        this.cmnd = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.age = new SimpleIntegerProperty();
    }
    //Name
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name;
    }
    //Phone Number
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public void setPhoneNumber(String Name){
        this.phoneNumber.set(Name);
    }
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }
    //Cmnd
    public String getCmnd() {
        return cmnd.get();
    }
    public void setCmnd(String cmnd){
        this.cmnd.set(cmnd);
    }
    public StringProperty CmndProperty() {
        return cmnd;
    }
    //Address
    public String getAddress() {
        return address.get();
    }
    public void setAddress(String address){
        this.address.set(address);
    }
    public StringProperty addressProperty() {
        return address;
    }
    //Age
    public Integer getAge() {
        return age.get();
    }
    public void setAge(Integer age){
        this.age.set(age);
    }
    public IntegerProperty ageProperty() {
        return age;
    }
}
