package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhieuMuon {
    private final StringProperty maSoPhieuMuon;
    private final StringProperty ngayBatDau;
    private final StringProperty ngayKetthuc;
    private final IntegerProperty tongTien;
    //Constructor
    public PhieuMuon() {
        maSoPhieuMuon = new SimpleStringProperty();
        ngayBatDau = new SimpleStringProperty();
        ngayKetthuc = new SimpleStringProperty();
        tongTien = new SimpleIntegerProperty();
    }
    //MSPM

    public void setMaSoPhieuMuon(String maSoPhieuMuon) {
        this.maSoPhieuMuon.set(maSoPhieuMuon);
    }

    public String getMaSoPhieuMuon() {
        return maSoPhieuMuon.get();
    }

    public StringProperty maSoPhieuMuonProperty() {
        return maSoPhieuMuon;
    }

    //NgayBatDau

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau.set(ngayBatDau);
    }

    public String getNgayBatDau() {
        return ngayBatDau.get();
    }
    public StringProperty ngayBatDauProperty(){
        return ngayBatDau;
    }
    //NgayKetThuc

    public void setNgayKetthuc(String ngayKetthuc) {
        this.ngayKetthuc.set(ngayKetthuc);
    }

    public String getNgayKetthuc() {
        return ngayKetthuc.get();
    }

    public StringProperty ngayKetthucProperty() {
        return ngayKetthuc;
    }
    //TongTien

    public void setTongTien(int tongTien) {
        this.tongTien.set(tongTien);
    }

    public int getTongTien() {
        return tongTien.get();
    }

    public IntegerProperty tongTienProperty() {
        return tongTien;
    }
}
