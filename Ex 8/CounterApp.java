import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApp extends JFrame implements ActionListener {
    int count = 0;
    JLabel label;
    JButton increment, reset;

    public CounterApp() {
        setTitle("Counter App");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Count: 0");
        increment = new JButton("Increment");
        reset = new JButton("Reset");

        add(label);
        add(increment);
        add(reset);

        increment.addActionListener(this);
        reset.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == increment) {
            count++;
            label.setText("Count: " + count);
        } else if (e.getSource() == reset) {
            count = 0;
            label.setText("Count: " + count);
        }
    }

    public static void main(String[] args) {
        new CounterApp().setVisible(true);
    }
}
