package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChucVu {
    private StringProperty MSCV;
    private StringProperty tenCV;

    //Constructor
    public ChucVu() {
        MSCV = new SimpleStringProperty();
        tenCV = new SimpleStringProperty();
    }

    //MSCV
    public void setMSCV(String MSCV) {
        this.MSCV.set(MSCV);
    }

    public String getMSCV() {
        return MSCV.get();
    }

    public StringProperty MSCVProperty() {
        return MSCV;
    }

    //TenCV
    public void setTenCV(String tenCV) {
        this.tenCV.set(tenCV);
    }

    public String getTenCV() {
        return tenCV.get();
    }

    public StringProperty tenCVProperty() {
        return tenCV;
    }
}
