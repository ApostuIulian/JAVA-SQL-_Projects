package org.example.Model;

public class Clients {
    private final int id;
    private String name;
    private String address;
    private String email;

    /**
     * @param id nu poate fi schimbat, se incrementeaza automat in sql deci nu conteaza ce parametru se va trimite la constructor
     *           pentru id
     * @param name
     * @param address
     * @param email
     */
    public Clients(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Clients()
    {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
