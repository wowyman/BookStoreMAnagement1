package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhieuGiaoCa {
    private StringProperty MSPGC;
    private StringProperty ngay;
    private StringProperty ca;
    //Constructor
    public PhieuGiaoCa() {
        MSPGC = new SimpleStringProperty();
        ngay = new SimpleStringProperty();
        ca = new SimpleStringProperty();
    }

    //MSPGC

    public void setMSPGC(String MSPGC) {
        this.MSPGC.set(MSPGC);
    }

    public String getMSPGC() {
        return MSPGC.get();
    }

    public StringProperty MSPGCProperty() {
        return MSPGC;
    }

    //Ngay
    public void setNgay(String ngay) {
        this.ngay.set(ngay);
    }

    public String getNgay() {
        return ngay.get();
    }

    public StringProperty ngayProperty() {
        return ngay;
    }
    //Ca

    public void setCa(String ca) {
        this.ca.set(ca);
    }

    public String getCa() {
        return ca.get();
    }

    public StringProperty caProperty() {
        return ca;
    }
}
