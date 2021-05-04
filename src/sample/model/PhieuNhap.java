package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhieuNhap {
    private StringProperty MSPN;
    private StringProperty ngayNhap;
    private IntegerProperty tongGiaTri;
    private NCC ncc;
    private Employee e;

    //Constructor
    public PhieuNhap() {
        MSPN = new SimpleStringProperty();
        ngayNhap = new SimpleStringProperty();
        tongGiaTri = new SimpleIntegerProperty();
        ncc = new NCC();
        e = new Employee();
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
    //NCC

    public NCC getNcc() {
        return ncc;
    }

    public void setNcc(String maNCC) {
        this.ncc.setMaNCC(maNCC);
    }
    //Employee


    public Employee getE() {
        return e;
    }

    public void setE(String maNV) {
        this.e.setMSNV(maNV);
    }
}
