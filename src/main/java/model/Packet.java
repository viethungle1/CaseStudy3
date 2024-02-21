package model;

import java.util.List;

public class Packet {
    private int id;
    private int id_kh;
    private int id_book;
    private int quantity;
    List <Book> books;

    public Packet() {
    }

    public Packet(int id_kh, int id_book, int quantity) {
        this.id_kh = id_kh;
        this.id_book = id_book;
        this.quantity = quantity;
    }

    public Packet(int id_kh, int id_book, int quantity, List<Book> books) {
        this.id_kh = id_kh;
        this.id_book = id_book;
        this.quantity = quantity;
        this.books = books;
    }

    public Packet(int id, int id_kh, int id_book, int quantity, List<Book> books) {
        this.id = id;
        this.id_kh = id_kh;
        this.id_book = id_book;
        this.quantity = quantity;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public int getId_kh() {
        return id_kh;
    }

    public int getId_book() {
        return id_book;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Book> getBooks() {
        return books;
    }
}
