package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QuayTN {
    private StringProperty maQTN;
    private StringProperty tenQTN;

    //Constructor
    public QuayTN() {
        maQTN = new SimpleStringProperty();
        tenQTN = new SimpleStringProperty();
    }

    //MaQTN
    public void setMaQTN(String maQTN) {
        this.maQTN.set(maQTN);
    }

    public String getMaQTN() {
        return maQTN.get();
    }

    public StringProperty maQTNProperty() {
        return maQTN;
    }

    //TenQTN
    public void setTenQTN(String tenQTN) {
        this.tenQTN.set(tenQTN);
    }

    public String getTenQTN() {
        return tenQTN.get();
    }

    public StringProperty tenQTNProperty() {
        return tenQTN;
    }
}
