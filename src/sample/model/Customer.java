package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static sample.model.LoaiThe.*;

public class Customer {
    private StringProperty name;
    private StringProperty cmnd;
    private StringProperty phoneNumber;
    private StringProperty address;
    private IntegerProperty age;
    private StringProperty MSPM;
    private Card thedoc;
    private  Card themuon;


    //Constructor
    public Customer() {
        this.name = new SimpleStringProperty();
        this.cmnd = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.age = new SimpleIntegerProperty();
        this.MSPM = new SimpleStringProperty();
        thedoc = new Card();
        thedoc.setLoaithe(theDoc);
        themuon = new Card();
        themuon.setLoaithe(theMuon);
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

    public void setPhoneNumber(String Name) {
        this.phoneNumber.set(Name);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    //Cmnd
    public String getCmnd() {
        return cmnd.get();
    }

    public void setCmnd(String cmnd) {
        this.cmnd.set(cmnd);
    }

    public StringProperty cmndProperty() {
        return cmnd;
    }

    //Address
    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    //Age
    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }
    //MSPM

    public void setMSPM(String MSPM) {
        this.MSPM.set(MSPM);
    }

    public String getMSPM() {
        return MSPM.get();
    }

    public StringProperty MSPMProperty() {
        return MSPM;
    }
    //thedoc

    public void setThedoc(Card thedoc) {
        this.thedoc = thedoc;
    }

    public Card getThedoc() {
        return thedoc;
    }
    //themuon

    public Card getThemuon() {
        return themuon;
    }

    public void setThemuon(Card themuon) {
        this.themuon = themuon;
    }
}
