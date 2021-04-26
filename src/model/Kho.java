package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Kho {
    private StringProperty maKho;
    private StringProperty tenKho;
    private StringProperty theLoai;
    //Constructor
    public Kho() {
        maKho = new SimpleStringProperty();
        tenKho = new SimpleStringProperty();
        theLoai = new SimpleStringProperty();
    }
    //MaKho

    public void setMaKho(String maKho) {
        this.maKho.set(maKho);
    }

    public String getMaKho() {
        return maKho.get();
    }

    public StringProperty maKhoProperty() {
        return maKho;
    }

    //TenKho

    public void setTenKho(String tenKho) {
        this.tenKho.set(tenKho);
    }

    public String getTenKho() {
        return tenKho.get();
    }

    public StringProperty tenKhoProperty() {
        return tenKho;
    }

    //TheLoai

    public void setTheLoai(String theLoai) {
        this.theLoai.set(theLoai);
    }

    public String getTheLoai() {
        return theLoai.get();
    }

    public StringProperty theLoaiProperty() {
        return theLoai;
    }
}
