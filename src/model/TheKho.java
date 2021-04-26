package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TheKho {
    private StringProperty maThe;
    private StringProperty ngaPhatSinh;
    //Constructor
    public TheKho()  {
        maThe = new SimpleStringProperty();
        ngaPhatSinh = new SimpleStringProperty();
    }
    //MaThe

    public void setMaThe(String maThe) {
        this.maThe.set(maThe);
    }

    public String getMaThe() {
        return maThe.get();
    }

    public StringProperty maTheProperty() {
        return maThe;
    }

    //NgayPhatSinh

    public void setNgaPhatSinh(String ngaPhatSinh) {
        this.ngaPhatSinh.set(ngaPhatSinh);
    }

    public String getNgaPhatSinh() {
        return ngaPhatSinh.get();
    }

    public StringProperty ngaPhatSinhProperty() {
        return ngaPhatSinh;
    }
}
