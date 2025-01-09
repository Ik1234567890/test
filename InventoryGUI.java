import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getDetails() {
        return "Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
class Inventory {
    private Product[] products;
    private int count;

    public Inventory() {
        products = new Product[3];
        count = 0;
    }
    public String addProduct(String name, double price, int quantity) {
        if (count >= 3) {
            return "Inventory full. Cannot add more products.";
        }
        products[count++] = new Product(name, price, quantity);
        return "Product added successfully!";
    }

    public String updateProduct(String name, double price, int quantity) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                products[i].setPrice(price);
                products[i].setQuantity(quantity);
                return "Product updated successfully!";
            }
        }
        return "Product not found!";
    }
    public String displayAllProducts() {
        if (count == 0) {
            return "No products in inventory.";
        }
        StringBuilder details = new StringBuilder();
        for (int i = 0; i < count; i++) {
            details.append(products[i].getDetails()).append("\n");
        }
        return details.toString();
    }
}
public class InventoryGUI {
    private Inventory inventory;

    public InventoryGUI() {
        inventory = new Inventory();
        setupGUI();
    }
    private void setupGUI() {
        JFrame frame = new JFrame("Inventory Management");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Input fields in messy positions
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(70, 30, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 30, 150, 25);
        frame.add(nameField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(70, 80, 100, 25);
        frame.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(200, 80, 150, 25);
        frame.add(priceField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(70, 130, 100, 25);
        frame.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(200, 130, 150, 25);
        frame.add(quantityField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(50, 200, 120, 35);
        frame.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(200, 200, 140, 35);
        frame.add(updateButton);

        JButton displayButton = new JButton("Show Inventory");
        displayButton.setBounds(100, 250, 180, 35);
        frame.add(displayButton);

        JTextArea messageArea = new JTextArea();
        messageArea.setBounds(20, 320, 420, 120);
        messageArea.setEditable(false);
        frame.add(messageArea);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                try {
                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    messageArea.setText(inventory.addProduct(name, price, quantity));
                } catch (NumberFormatException ex) {
                    messageArea.setText("Invalid price or quantity. Please enter valid numbers.");
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                try {
                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    messageArea.setText(inventory.updateProduct(name, price, quantity));
                } catch (NumberFormatException ex) {
                    messageArea.setText("Invalid price or quantity. Please enter valid numbers.");
                }
            }
        });
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageArea.setText(inventory.displayAllProducts());
            }
        });
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new InventoryGUI();
    }
}
