package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhieuXuat {
    private final StringProperty MSPX;
    private final StringProperty ngayXuat;
    private final StringProperty tongGiaTri;

    //Constructor
    public PhieuXuat() {
        MSPX = new SimpleStringProperty();
        ngayXuat = new SimpleStringProperty();
        tongGiaTri = new SimpleStringProperty();
    }

    //MSPN

    public void setMSPX(String MSPN) {
        this.MSPX.set(MSPN);
    }

    public String getMSPX() {
        return MSPX.get();
    }

    public StringProperty MSPXProperty() {
        return MSPX;
    }

    //NgayNhap

    public void setNgayXuat(String ngayNhap) {
        this.ngayXuat.set(ngayNhap);
    }

    public String getNgayXuat() {
        return ngayXuat.get();
    }

    public StringProperty ngayXuatProperty() {
        return ngayXuat;
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
