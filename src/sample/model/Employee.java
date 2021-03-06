package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
    private final StringProperty MSNV;
    private final StringProperty name;
    private final StringProperty gioiTinh;
    private final StringProperty ngaySinh;
    private final StringProperty address;
    private final StringProperty phoneNumber;
    private final StringProperty queQuan;
    private final IntegerProperty salary;
    private final ChucVu chucVu;
    private final Kho kho;
    //Constructor
    public Employee() {
        MSNV = new SimpleStringProperty();
        name = new SimpleStringProperty();
        gioiTinh = new SimpleStringProperty();
        ngaySinh = new SimpleStringProperty();
        address = new SimpleStringProperty();
        phoneNumber = new SimpleStringProperty();
        queQuan = new SimpleStringProperty();
        salary = new SimpleIntegerProperty();
        chucVu = new ChucVu();
        kho = new Kho();

    }
    //MSNV

    public void setMSNV(String MSNV) {
        this.MSNV.set(MSNV);
    }

    public String getMSNV() {
        return MSNV.get();
    }

    public StringProperty MSNVProperty() {
        return MSNV;
    }

    //Name
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name;
    }

    //GioiTinh
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh.set(gioiTinh);
    }

    public String getGioiTinh() {
        return gioiTinh.get();
    }

    public StringProperty gioiTinhProperty() {
        return gioiTinh;
    }

    //NgaySinh
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh.set(ngaySinh);
    }

    public String getNgaySinh() {
        return ngaySinh.get();
    }

    public StringProperty ngaySinhProperty() {
        return ngaySinh;
    }

    //Address
    public String getAddress() {
        return address.get();
    }
    public void setAddress(String address){
        this.address.set(address);
    }
    public StringProperty addressProperty() {
        return address;
    }
    //PhoneNumber
    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String Name) {
        this.phoneNumber.set(Name);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    //QueQuan
    public void setQueQuan(String queQuan) {
        this.queQuan.set(queQuan);
    }

    public String getQueQuan() {
        return queQuan.get();
    }

    public StringProperty queQuanProperty() {
        return queQuan;
    }

    //Salary
    public void setSalary(Integer salary) {
        this.salary.set(salary);
    }

    public int getSalary() {
        return salary.get();
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    //chucvu

    public void setChucVu(String chucVu) {
        this.chucVu.setTenCV(chucVu);
    }

    public ChucVu getChucVu() {
        return chucVu;
    }
    //kho

    public Kho getKho() {
        return kho;
    }

    public void setKho(String kho) {
        this.kho.setTenKho(kho);
    }
}
