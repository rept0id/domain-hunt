/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package gr.simplecode.domainhunt;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rrr
 */
public class mainClass {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        readSource();

    }

    private InputStream readSourceFileAsStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private static void readSource() {

        try {
            mainClass instance = new mainClass();

            InputStream is = instance.readSourceFileAsStream("dictionaries/txt/paintings.txt");

            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr);) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.replaceAll("\\s", "");
                    line = line.toLowerCase();
                    domainCheck(line+".com", true);
                }
                is.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(mainClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void domainCheck(String domainToCheck, Boolean report) {
        InetAddress domainInetAddress = null;

        try {
            domainInetAddress = InetAddress.getByName(domainToCheck);
        } catch (UnknownHostException e) {
            //do nothing
        }

        if (report) {
            domainReport(domainInetAddress, domainToCheck);
        }

    }

    private static void domainReport(InetAddress domainInetAddress, String domainToCheck) {
        if (domainInetAddress != null) {
            //System.out.println(domainToCheck + " : domain state : registered");
        } else {
            System.out.println(domainToCheck + " : domain state : unregistered");
        }
    }

}
