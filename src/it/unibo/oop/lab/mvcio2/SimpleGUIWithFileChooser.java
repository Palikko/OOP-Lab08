package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */

    private final JFrame frame = new JFrame("Good title!");

        public SimpleGUIWithFileChooser() {

        final Controller b = new Controller();
 

        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea textBox = new JTextArea();
        canvas.add(textBox, BorderLayout.CENTER);

        final JButton write = new JButton("Save");
        canvas.add(write, BorderLayout.SOUTH);

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                b.input(textBox.getText());
            }
        });

        final JPanel second = new JPanel();
        second.setLayout(new BorderLayout());
        canvas.add(second, BorderLayout.NORTH);

        final JTextField field = new JTextField();
        field.setEditable(false);
        field.setText(b.getPath());
        second.add(field, BorderLayout.CENTER);

        final JButton button = new JButton("browse...");
        second.add(button, BorderLayout.LINE_END);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser jFileChooser = new JFileChooser();
                if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    b.setPath(jFileChooser.getSelectedFile());
                    field.setText(b.getPath());

                } else if (jFileChooser.isAcceptAllFileFilterUsed()) {
                    JOptionPane.showMessageDialog(null, "an error has ocurred");
                }

            }
        });

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / 2, sh / 2);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(final String[] args) {

        new SimpleGUIWithFileChooser();

    }

}


