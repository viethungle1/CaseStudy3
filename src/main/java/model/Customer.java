package model;

public class Customer {
    private int id;
    private String name;
    private String address;
    private int id_packet;

    public Customer() {
    }

    public Customer(int id, String name, String address, int id_packet) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.id_packet = id_packet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId_packet() {
        return id_packet;
    }
}
