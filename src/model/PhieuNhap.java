package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhieuNhap {
    private StringProperty MSPN;
    private StringProperty ngayNhap;
    private IntegerProperty tongGiaTri;

    //Constructor
    public PhieuNhap() {
        MSPN = new SimpleStringProperty();
        ngayNhap = new SimpleStringProperty();
        tongGiaTri = new SimpleIntegerProperty();
    }

    //MSPN

    public void setMSPN(String MSPN) {
        this.MSPN.set(MSPN);
    }

    public String getMSPN() {
        return MSPN.get();
    }

    public StringProperty MSPNProperty() {
        return MSPN;
    }

    //NgayNhap

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap.set(ngayNhap);
    }

    public String getNgayNhap() {
        return ngayNhap.get();
    }

    public StringProperty ngayNhapProperty() {
        return ngayNhap;
    }

    //TongGiaTri
    public void setTongGiaTri(int tongGiaTri) {
        this.tongGiaTri.set(tongGiaTri);
    }

    public int getTongGiaTri() {
        return tongGiaTri.get();
    }

    public IntegerProperty tongGiaTriProperty() {
        return tongGiaTri;
    }
}
