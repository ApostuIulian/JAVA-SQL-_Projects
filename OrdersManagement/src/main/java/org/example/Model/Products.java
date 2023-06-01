package org.example.Model;

public class Products {
    private final int id;
    private String name;
    private int quantity;

    /**
     * @param id
     * @param name
     * @param quantity
     * asemanator clasei Clients
     */
    public Products(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Products() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
