package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhieuNhap {
    private StringProperty MSPN;
    private StringProperty ngayNhap;
    private StringProperty tongGiaTri;

    //Constructor
    public PhieuNhap() {
        MSPN = new SimpleStringProperty();
        ngayNhap = new SimpleStringProperty();
        tongGiaTri = new SimpleStringProperty();
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
    public void setTongGiaTri(String tongGiaTri) {
        this.tongGiaTri.set(tongGiaTri);
    }

    public String getTongGiaTri() {
        return tongGiaTri.get();
    }

    public StringProperty tongGiaTriProperty() {
        return tongGiaTri;
    }
}
