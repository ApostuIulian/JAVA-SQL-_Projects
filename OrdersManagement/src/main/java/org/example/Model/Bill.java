package org.example.Model;

/**
 * @param id
 * @param idOrder
 * @param idClient
 * @param idProduct
 * @param quantity
 * clasa imutabile Bill
 */
public record Bill(int id, int idOrder, int idClient, int idProduct, int quantity) {

    @Override
    public int id() {
        return id;
    }

    @Override
    public int idOrder() {
        return idOrder;
    }

    @Override
    public int idClient() {
        return idClient;
    }

    @Override
    public int idProduct() {
        return idProduct;
    }

    @Override
    public int quantity() {
        return quantity;
    }
}
