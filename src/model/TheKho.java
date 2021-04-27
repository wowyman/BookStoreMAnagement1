package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TheKho {
    private StringProperty maThe;
    private StringProperty ngayPhatSinh;
    //Constructor
    public TheKho()  {
        maThe = new SimpleStringProperty();
        ngayPhatSinh = new SimpleStringProperty();
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
        this.ngayPhatSinh.set(ngaPhatSinh);
    }

    public String getNgaPhatSinh() {
        return ngayPhatSinh.get();
    }

    public StringProperty ngaPhatSinhProperty() {
        return ngayPhatSinh;
    }
}
