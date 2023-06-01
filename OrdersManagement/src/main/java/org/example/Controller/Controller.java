package org.example.Controller;

import org.example.Model.Clients;
import org.example.Model.Orders;
import org.example.Model.Products;
import org.example.View.ClientsProductsGUI;
import org.example.View.OrdersGUI;
import org.example.View.SelectData;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import static java.lang.Integer.parseInt;


/**
 * Clasa principala care face legatura dintre interfata si baza de date
 */
public class Controller implements ActionListener {
    Connection connection;
    SelectData selectData;
    ClientsProductsGUI clientsProductsGUI;
    ClientsBLL clientsBll;
    ProductsBLL productsBll;
    OrdersGUI ordersGui;
    OrdersBLL ordersBll;
    static boolean clients = false;

    public Controller(SelectData selectData, Connection connection) {
        this.connection = connection;
        this.selectData = selectData;
        this.selectData.clientsButton.addActionListener(this);
        this.selectData.productsButton.addActionListener(this);
        this.selectData.ordersButton.addActionListener(this);
        clientsBll = new ClientsBLL(connection);
        productsBll = new ProductsBLL(connection);
        ordersBll = new OrdersBLL(connection);
    }

    /**
     * @param e the event to be processed
     *          toate actiunile pe care butoanele trebuie sa le execute
     *          tabelele se vor actualiza in timp real, datele fiind preluate din baza de date
     *          dupa fiecare schimbare
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel model = null;
        try {
            if (e.getSource() == selectData.clientsButton) {
                selectData.dispose();
                clientsProductsGUI = new ClientsProductsGUI(new Clients());
                clientsProductsGUI.addButton.addActionListener(this);
                clientsProductsGUI.editButton.addActionListener(this);
                clientsProductsGUI.deleteButton.addActionListener(this);
                clientsProductsGUI.backButton.addActionListener(this);
                String[] columns = {"ID", "Name", "Address", "Email"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };

                clientsBll.viewClients(model);
                clientsProductsGUI.table.setModel(model);
                clients = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            if (e.getSource() == selectData.productsButton) {
                selectData.dispose();
                clientsProductsGUI = new ClientsProductsGUI(new Products());
                clientsProductsGUI.addButton.addActionListener(this);
                clientsProductsGUI.editButton.addActionListener(this);
                clientsProductsGUI.deleteButton.addActionListener(this);
                clientsProductsGUI.backButton.addActionListener(this);
                String[] columns = {"ID", "Name", "Quantity"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };

                productsBll.viewProducts(model);
                clientsProductsGUI.table.setModel(model);
                clients = false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            if (e.getSource() == selectData.ordersButton) {
                selectData.dispose();
                ordersGui = new OrdersGUI();
                String[] columns = {"ID", "Name", "Address", "Email"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };
                clientsBll.viewClients(model);
                ordersGui.clientsTable.setModel(model);

                columns = new String[]{"ID", "Name", "Quantity"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };
                productsBll.viewProducts(model);
                ordersGui.productsTable.setModel(model);

                columns = new String[]{"ID", "idClient", "idProduct", "Quantity"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };
                ordersBll.viewOrders(model);
                ordersGui.ordersTabel.setModel(model);

                ordersGui.placeOrderButton.addActionListener(this);
                ordersGui.deleteButton.addActionListener(this);
                ordersGui.backButton.addActionListener(this);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            if (e.getSource() == clientsProductsGUI.addButton) {
                if (clients) {
                    String[] columns = {"ID", "Name", "Address", "Email"};
                    model = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column != 0;
                        }
                    };
                    Clients newClient = new Clients(-1, clientsProductsGUI.nameField.getText(), clientsProductsGUI.addressQuantityField.getText(), clientsProductsGUI.emailField.getText());
                    clientsBll.addClient(newClient);
                    clientsBll.viewClients(model);
                    clientsProductsGUI.table.setModel(model);
                    clientsProductsGUI.nameField.setText("");
                    clientsProductsGUI.addressQuantityField.setText("");
                    clientsProductsGUI.emailField.setText("");
                } else if (!clients) {
                    String[] columns = {"ID", "Name", "Quantity"};
                    model = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column != 0;
                        }
                    };
                    Products newProduct = new Products(-1, clientsProductsGUI.nameField.getText(), parseInt(clientsProductsGUI.addressQuantityField.getText()));
                    productsBll.addProduct(newProduct);
                    productsBll.viewProducts(model);
                    clientsProductsGUI.table.setModel(model);
                    clientsProductsGUI.nameField.setText("");
                    clientsProductsGUI.addressQuantityField.setText("");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            if (e.getSource() == clientsProductsGUI.editButton) {
                if (clients) {
                    String[] columns = {"ID", "Name", "Address", "Email"};
                    model = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column != 0;
                        }
                    };
                    clientsBll.editClient(clientsProductsGUI.table);
                    clientsProductsGUI.table.setModel(model);
                    clientsBll.viewClients(model);
                } else if (!clients) {
                    String[] columns = {"ID", "Name", "Quantity"};
                    model = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column != 0;
                        }
                    };
                    productsBll.editProduct(clientsProductsGUI.table);
                    productsBll.viewProducts(model);
                    clientsProductsGUI.table.setModel(model);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            if (e.getSource() == clientsProductsGUI.deleteButton) {
                if (clients) {
                    String[] columns = {"ID", "Name", "Address", "Email"};
                    model = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column != 0;
                        }
                    };
                    clientsBll.deleteClient(clientsProductsGUI.table);
                    clientsBll.viewClients(model);
                    clientsProductsGUI.table.setModel(model);
                } else if (!clients) {
                    String[] columns = {"ID", "Name", "Quantity"};
                    model = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column != 0;
                        }
                    };
                    productsBll.deleteProduct(clientsProductsGUI.table);
                    productsBll.viewProducts(model);
                    clientsProductsGUI.table.setModel(model);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            if (e.getSource() == clientsProductsGUI.backButton) {
                clientsProductsGUI.dispose();
                selectData.setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            if (e.getSource() == ordersGui.backButton) {
                ordersGui.dispose();
                selectData.setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            if (e.getSource() == ordersGui.placeOrderButton) {
                String[] columns = {"ID", "idClient", "idProduct", "Quantity"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };

                Orders newOrder = new Orders(-1, parseInt(ordersGui.idClientField.getText()), parseInt(ordersGui.idProductField.getText()), parseInt(ordersGui.quantityField.getText()));
                ordersBll.addOrder(newOrder);
                ordersBll.viewOrders(model);
                ordersGui.ordersTabel.setModel(model);

                columns = new String[]{"ID", "Name", "Quantity"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };

                productsBll.viewProducts(model);
                ordersGui.productsTable.setModel(model);

                ordersGui.idClientField.setText("");
                ordersGui.idProductField.setText("");
                ordersGui.quantityField.setText("");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            if (e.getSource() == ordersGui.deleteButton) {
                String[] columns = {"ID", "idClient", "idProduct", "Quantity"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };
                ordersBll.deleteOrder(ordersGui.ordersTabel);
                ordersBll.viewOrders(model);
                ordersGui.ordersTabel.setModel(model);

                columns = new String[]{"ID", "Name", "Quantity"};
                model = new DefaultTableModel(columns, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };

                productsBll.viewProducts(model);
                ordersGui.productsTable.setModel(model);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
