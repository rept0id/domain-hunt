package gr.simplecode.domainhunt;

import java.io.*;
import java.nio.file.*;
import java.util.logging.*;

public class domainhunt {
    private static boolean isDomainAvailable(String domain) {
        boolean isAvailable = false;

        try {
            ProcessBuilder pb = new ProcessBuilder("whois", domain);
            Process proc = pb.start();

            BufferedReader rdr = new BufferedReader(
                new InputStreamReader(proc.getInputStream())
            );

            String line;

            line = rdr.readLine();

            if (line.contains("No match for domain")) {
                isAvailable = true;
            }

            proc.waitFor();
            rdr.close();

            return isAvailable;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

            isAvailable = false;

            return isAvailable;
        }
    }

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

                boolean isAvailable = isDomainAvailable(domain);

                if (isAvailable) {
                    System.out.println(domain + " : available");
                } else {
                    System.out.println(domain + " : unavailable");
                }
            }

            is.close();
            isr.close();
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(domainhunt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
