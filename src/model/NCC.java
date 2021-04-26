package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NCC {
    private StringProperty maNCC;
    private StringProperty name;
    private StringProperty address;
    private StringProperty phoneNumber;
    private StringProperty email;
    private StringProperty fax;
    //Constructor
    public NCC() {
        maNCC = new SimpleStringProperty();
        name = new SimpleStringProperty();
        address = new SimpleStringProperty();
        phoneNumber = new SimpleStringProperty();
        email = new SimpleStringProperty();
        fax = new SimpleStringProperty();
    }
    //MaNCC

    public void setMaNCC(String maNCC) {
        this.maNCC.set(maNCC);
    }

    public String getMaNCC() {
        return maNCC.get();
    }

    public StringProperty maNCCProperty() {
        return maNCC;
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
    //PhoneNumber
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public void setPhoneNumber(String Name){
        this.phoneNumber.set(Name);
    }
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }
    //Email
    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    //Fax

    public void setFax(String fax) {
        this.fax.set(fax);
    }

    public String getFax() {
        return fax.get();
    }

    public StringProperty faxProperty() {
        return fax;
    }
}
