import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        add(new JLabel("Number 1:"));
        add(t1);
        add(new JLabel("Number 2:"));
        add(t2);
        add(new JLabel("Result:"));
        add(result);

        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(t1.getText());
            double n2 = Double.parseDouble(t2.getText());
            double res = 0;

            if (e.getSource() == add) res = n1 + n2;
            if (e.getSource() == sub) res = n1 - n2;
            if (e.getSource() == mul) res = n1 * n2;
            if (e.getSource() == div) res = n1 / n2;

            result.setText("" + res);
        } catch (Exception ex) {
            result.setText("Error");
        }
    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
}
