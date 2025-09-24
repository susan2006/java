import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {
    JTextArea textArea;
    JMenuItem open, save, exit;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(exit);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                    textArea.read(reader, null);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error opening file");
                }
            }
        } else if (e.getSource() == save) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile()))) {
                    textArea.write(writer);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file");
                }
            }
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TextEditor().setVisible(true);
    }
}
