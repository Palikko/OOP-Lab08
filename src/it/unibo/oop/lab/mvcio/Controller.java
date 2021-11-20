package it.unibo.oop.lab.mvcio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * 
 */
public class Controller {

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */


    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";

    private final static File output = new File(PATH);

    /**
     * @return
     *          File
     */
    public static File getFile() {
        return output;
    }
    /**
     * @return
     *          Path file
     */
    public static String getPath() {
        return output.getPath();
    }
    /**
     * @param input
     *              the user input that will be save in output.txt
     */
    public static void input(final String input) {

       try (BufferedWriter w = new BufferedWriter(new FileWriter(getPath()))) {
        w.write(input);
       } catch (IOException e) {
        e.printStackTrace();
       }

    }

}
