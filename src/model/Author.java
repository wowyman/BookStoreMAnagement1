package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Author {
    private StringProperty authorNumber;
    private StringProperty name;
    private StringProperty email;
    private StringProperty phoneNumber;
    private StringProperty queQuan;

    //Constructor
    public Author() {
        authorNumber = new SimpleStringProperty();
        name = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phoneNumber = new SimpleStringProperty();
        queQuan = new SimpleStringProperty();
    }
    //AuthorNumber

    public void setAuthorNumber(String authorNumber) {
        this.authorNumber.set(authorNumber);
    }

    public String getAuthorNumber() {
        return authorNumber.get();
    }

    public StringProperty authorNumberProperty() {
        return authorNumber;
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

    //PhoneNumber
    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String Name) {
        this.phoneNumber.set(Name);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    //QueQuan
    public void setQueQuan(String queQuan) {
        this.queQuan.set(queQuan);
    }

    public String getQueQuan() {
        return queQuan.get();
    }

    public StringProperty queQuanProperty() {
        return queQuan;
    }
}
