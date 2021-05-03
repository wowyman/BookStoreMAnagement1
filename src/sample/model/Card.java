package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Card {
    private StringProperty cardNumber;
    private StringProperty ngayCapThe;
    private LoaiThe loaithe;

    //Constructor
    public Card(){
        cardNumber = new SimpleStringProperty();
        ngayCapThe = new SimpleStringProperty();

    }
    //CardNumber

    public String getCardNumber() {
        return cardNumber.get();
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber.set(cardNumber);
    }
    public StringProperty cardNumberProperty() {
        return cardNumber;
    }
    //NgayCapThe
    public String getNgayCapThe() {
        return ngayCapThe.get();
    }
    public void setNgayCapThe(String ngayCapThe) {
        this.ngayCapThe.set(ngayCapThe);
    }
    public StringProperty ngayCapTheProperty() {
        return ngayCapThe;
    }
    public LoaiThe getLoaithe() {
        return loaithe;
    }

    public void setLoaithe(LoaiThe loaithe) {
        this.loaithe = loaithe;
    }
}
