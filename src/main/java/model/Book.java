package model;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private String author;
    private int price;
    private List<Category> categories;

    public Book() {
    }

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, String author, int price, List<Category> categories) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.categories = categories;
    }

    public Book(int id, String name, String author, int price, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
