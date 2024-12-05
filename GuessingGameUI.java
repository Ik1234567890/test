import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class GuessingGameUI {
    public static int attempts = 0;
    public static void main(String[] args) {
        Random rn = new Random();
        int num = rn.nextInt(100) + 1;

        JFrame frame = new JFrame("Guessing Game");
        frame.setSize(1000, 1000);
        frame.setLayout(new GridLayout(4, 1));

        JPanel textPanel = new JPanel(new FlowLayout());
        JTextField textField = new JTextField(10);
        textPanel.add(textField);

        JPanel buttons = new JPanel(new FlowLayout());
        JButton guessButton = new JButton("Guess");
        buttonStyle(guessButton);
        buttons.add(guessButton);

        JPanel results = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Welcome to the guessing game! Good luck!");
        label.setFont(new Font("Arial", Font.BOLD, 20)); label.setForeground(Color.RED);
        results.add(label);

        JPanel name = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Ivaylo Kolev");
        nameLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        name.add(nameLabel);


        frame.add(textPanel);
        frame.add(buttons);
        frame.add(results);
        frame.add(name);
        frame.setVisible(true);
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer = textField.getText();
                if(answer.matches("-?\\d+")){
                    attempts++;
                    int guess = Integer.parseInt(answer);
                    if (guess > num) {
                        label.setText("Your guess is too big. Try with a smaller number");
                    } else if (guess < num) {
                        label.setText("Your guess is too small. Try with a bigger number");
                    } else {
                        label.setText("Correct! You had " + attempts + " attempts." );
                    }
                }else{
                    if(answer.equals("quit")){
                        label.setText("Thanks for playing! The correct number was " + num + " and you had " + attempts + " attempts.");
                    }else{
                        label.setText("Invalid input. Try again.");
                    }
                }
            }
        });
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.RED);
    }
}
