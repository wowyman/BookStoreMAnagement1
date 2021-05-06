package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private final StringProperty bookId;
    private final StringProperty bookTitle;
    private final StringProperty author;
    private final IntegerProperty XBlan;
    private final StringProperty theLoai;
    private final StringProperty namXB;
    private final IntegerProperty tap;
    private final IntegerProperty price;
    private final IntegerProperty soLuong;
    private final Kho kho;
    private IntegerProperty thanhtien;

    //Constructor
    public Book() {
        bookId = new SimpleStringProperty();
        bookTitle = new SimpleStringProperty();
        author = new SimpleStringProperty();
        XBlan = new SimpleIntegerProperty();
        theLoai = new SimpleStringProperty();
        namXB = new SimpleStringProperty();
        tap = new SimpleIntegerProperty();
        price = new SimpleIntegerProperty();
        soLuong = new SimpleIntegerProperty();
        kho = new Kho();

    }

    //BookId

    public String getBookId() {
        return bookId.get();
    }

    public void setBookId(String bookId) {
        this.bookId.set(bookId);
    }

    public StringProperty bookIdProperty() {
        return bookId;
    }

    //BookTitle

    public String getBookTitle() {
        return bookTitle.get();
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle.set(bookTitle);
    }

    public StringProperty bookTitleProperty() {
        return bookTitle;
    }

    //Author

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public StringProperty authorProperty() {
        return author;
    }

    //XBLan

    public int getXBlan() {
        return XBlan.get();
    }

    public void setXBlan(int XBlan) {
        this.XBlan.set(XBlan);
    }

    public IntegerProperty XBlanProperty() {
        return XBlan;
    }

    //TheLoai

    public String getTheLoai() {
        return theLoai.get();
    }

    public void setTheLoai(String theLoai) {
        this.theLoai.set(theLoai);
    }

    public StringProperty theLoaiProperty() {
        return theLoai;
    }

    //NamXB

    public String getNamXB() {
        return namXB.get();
    }

    public void setNamXB(String namXB) {
        this.namXB.set(namXB);
    }

    public StringProperty namXBProperty() {
        return namXB;
    }

    //Tap

    public int getTap() {
        return tap.get();
    }

    public void setTap(int tap) {
        this.tap.set(tap);
    }

    public IntegerProperty tapProperty() {
        return tap;
    }

    //Price

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    //SoLuong

    public int getSoLuong() {
        return soLuong.get();
    }

    public void setSoLuong(int soLuong) {
        this.soLuong.set(soLuong);
    }

    public IntegerProperty soLuongProperty() {
        return soLuong;
    }

    //kho

    public Kho getKho() {
        return kho;
    }

    public void setKho(String tenkho) {
        this.kho.setTenKho(tenkho);
    }
    //thanhtien


    public void setThanhtien(int thanhtien) {
        this.thanhtien.set(thanhtien);
    }

    public int getThanhtien() {
        return thanhtien.get();
    }

    public IntegerProperty thanhtienProperty() {
        return thanhtien;
    }
}