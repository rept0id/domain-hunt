package gr.simplecode.domainhunt;

/*** * * ***/

import java.io.*;
import java.nio.file.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.logging.Level;
import java.util.logging.Logger;

/*** * * ***/

public class mainClass {
    public static void main(String[] args) {
        try {
            InputStream is = Files.newInputStream(Paths.get("dictionary.txt"));
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                String domain = line.replaceAll("\\s", "")
                                    .replaceAll(",", "")
                                    .replaceAll("\\(", "")
                                    .replaceAll("\\)", "")
                                    .toLowerCase()
                                    + ".com";
                Boolean domainAvailable = false;

                try {
                    if (InetAddress.getByName(domain) == null) {
                        domainAvailable = true;
                    }
                } catch (UnknownHostException e) {
                    domainAvailable = true;
                }

                if (domainAvailable) {
                    System.out.println(domain + " : available");
                }
            }

            is.close();
            isr.close();
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(mainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
