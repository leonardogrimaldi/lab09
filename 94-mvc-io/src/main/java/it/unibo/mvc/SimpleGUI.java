package it.unibo.mvc;

import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller simpleController = new SimpleController();

    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        canvas.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        final JButton print = new JButton("Print");
        buttons.add(print, BorderLayout.NORTH);
        final JButton showHistory = new JButton("Show history");
        buttons.add(showHistory, BorderLayout.SOUTH);
        canvas.add(buttons, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Handlers
         */
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpleController.setNextString(textField.getText());
                simpleController.printCurrentString();
            }
        });
        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(simpleController.getHistory().toString());;
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
        //frame.pack();
    }
    public static void main(final String... args) {
        new SimpleGUI().display();
    }

}
