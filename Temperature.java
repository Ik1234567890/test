import javax.swing.*;
import java.awt.*;

public class Temperature extends JFrame {

    private JTextField inputField; // Input field for temperature
    private JLabel resultLabel;   // Label to display the conversion result

    public Temperature() {
        // Set up the JFrame
        setTitle("Simple Temperature Converter");
        setSize(400, 500);
        setLayout(new GridLayout(6, 1));

        // Input field
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Temperature:"));
        inputField = new JTextField(10);
        inputPanel.add(inputField);
        add(inputPanel);

        // Buttons for conversion options
        JPanel buttonPanel1 = new JPanel();
        JButton cToFButton = new JButton("Celsius to Fahrenheit");
        JButton fToCButton = new JButton("Fahrenheit to Celsius");
        JButton cToKButton = new JButton("Celsius to Kelvin");
        buttonPanel1.add(cToFButton);
        buttonPanel1.add(fToCButton);
        buttonPanel1.add(cToKButton);
        add(buttonPanel1);

        JPanel buttonPanel2 = new JPanel();
        JButton fToKButton = new JButton("Fahrenheit to Kelvin");
        JButton kToCButton = new JButton("Kelvin to Celsius");
        JButton kToFButton = new JButton("Kelvin to Fahrenheit");
        buttonPanel2.add(fToKButton);
        buttonPanel2.add(kToCButton);
        buttonPanel2.add(kToFButton);
        add(buttonPanel2);

        // Result display
        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel("Result: ");
        resultPanel.add(resultLabel);
        add(resultPanel);

        // Add event listeners to buttons
        cToFButton.addActionListener(e -> convertCelsiusToFahrenheit());
        fToCButton.addActionListener(e -> convertFahrenheitToCelsius());
        cToKButton.addActionListener(e -> convertCelsiusToKelvin());
        fToKButton.addActionListener(e -> convertFahrenheitToKelvin());
        kToCButton.addActionListener(e -> convertKelvinToCelsius());
        kToFButton.addActionListener(e -> convertKelvinToFahrenheit());

        // Make JFrame visible
        setVisible(true);
    }

    // Conversion methods
    private void convertCelsiusToFahrenheit() {
        String input = inputField.getText().trim();
        if (isValidNumber(input)) {
            double celsius = Double.parseDouble(input);
            double fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText("Result: " + fahrenheit + " °F");
        } else {
            resultLabel.setText("Invalid Input! Please enter a valid number.");
        }
    }

    private void convertFahrenheitToCelsius() {
        String input = inputField.getText().trim();
        if (isValidNumber(input)) {
            double fahrenheit = Double.parseDouble(input);
            double celsius = (fahrenheit - 32) * 5 / 9;
            resultLabel.setText("Result: " + celsius + " °C");
        } else {
            resultLabel.setText("Invalid Input! Please enter a valid number.");
        }
    }

    private void convertCelsiusToKelvin() {
        String input = inputField.getText().trim();
        if (isValidNumber(input)) {
            double celsius = Double.parseDouble(input);
            double kelvin = celsius + 273.15;
            resultLabel.setText("Result: " + kelvin + " K");
        } else {
            resultLabel.setText("Invalid Input! Please enter a valid number.");
        }
    }

    private void convertFahrenheitToKelvin() {
        String input = inputField.getText().trim();
        if (isValidNumber(input)) {
            double fahrenheit = Double.parseDouble(input);
            double kelvin = (fahrenheit - 32) * 5 / 9 + 273.15;
            resultLabel.setText("Result: " + kelvin + " K");
        } else {
            resultLabel.setText("Invalid Input! Please enter a valid number.");
        }
    }

    private void convertKelvinToCelsius() {
        String input = inputField.getText().trim();
        if (isValidNumber(input)) {
            double kelvin = Double.parseDouble(input);
            double celsius = kelvin - 273.15;
            resultLabel.setText("Result: " + celsius + " °C");
        } else {
            resultLabel.setText("Invalid Input! Please enter a valid number.");
        }
    }

    private void convertKelvinToFahrenheit() {
        String input = inputField.getText().trim();
        if (isValidNumber(input)) {
            double kelvin = Double.parseDouble(input);
            double fahrenheit = (kelvin - 273.15) * 9 / 5 + 32;
            resultLabel.setText("Result: " + fahrenheit + " °F");
        } else {
            resultLabel.setText("Invalid Input! Please enter a valid number.");
        }
    }

    // Helper method to validate the input as a valid number
    private boolean isValidNumber(String input) {
        // Regular expression to check if the input is a valid number
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        new Temperature(); // Launch the application
    }
}
