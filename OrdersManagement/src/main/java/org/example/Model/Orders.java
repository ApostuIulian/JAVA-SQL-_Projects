package org.example.Model;

public class Orders {
    private final int id;
    private int idClient;
    private int idProdus;
    private int quantity;

    /**
     * @param id
     * @param idClient
     * @param idProdus
     * @param quantity
     * asemanator clasei Clients
     */
    public Orders(int id, int idClient, int idProdus, int quantity) {
        this.id = id;
        this.idClient = idClient;
        this.idProdus = idProdus;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
