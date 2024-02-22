package model;

import java.util.List;

public class Bill {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int quantity;
    private List<Book> books;
    private int totalprice;

    public Bill() {
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public Bill(int id, String name, String phone, String address, int quantity, List<Book> books, int totalprice) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.quantity = quantity;
        this.books = books;
        this.totalprice = totalprice;
    }

    public Bill(String name, String phone, String address, int quantity) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.quantity = quantity;
    }

    public Bill(String name, String phone, String address, int quantity, List<Book> books) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.quantity = quantity;
        this.books = books;
    }

    public Bill(int id, String name, String phone, String address, int quantity, List<Book> books) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.quantity = quantity;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Book> getBooks() {
        return books;
    }
}
