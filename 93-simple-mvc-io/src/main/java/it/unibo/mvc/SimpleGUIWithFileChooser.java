package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    private static final int PROPORTION = 5;
    
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        final JTextField textField = new JTextField(controller.getFile().toString());
        textField.setEditable(false);
        final JButton browse = new JButton("Browse");
        top.add(textField, BorderLayout.CENTER);
        top.add(browse, BorderLayout.LINE_END);
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(top, BorderLayout.NORTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int returnVal = jFileChooser.showSaveDialog(canvas);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(jFileChooser.getSelectedFile());
                    textField.setText(controller.getFile().toString());
                } else if (returnVal != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(browse, e, null, returnVal);
                }
            }
            
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println(textArea.getText());
                try {
                    controller.saveString(textArea.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
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
        new SimpleGUIWithFileChooser().display();
    }
}
