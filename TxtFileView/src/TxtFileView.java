import java.util.*;
import java.io.*;
import java.net.*;

public class TxtFileView {
    public static void main(String args[]) {
        String s;
        InputStream is;
        URL u;
        while(true) {
            System.out.println("\nВведите URL файла или 'выход' чтобы выйти\n");
            s = getKbdString();
            if (s.toLowerCase().equals("выход")) {
                System.out.println("Всего доброго!");
                break;
            }
            try {
                u = new URL(s);
            } catch (MalformedURLException ex) {
                System.out.println(ex.toString());
                continue;
            }
            try {
                is = (InputStream) u.openStream();
            } catch (Exception ex) {
                System.out.println(ex.toString());
                continue;
            }
            try {
                int ch;
                while (true) {
                    ch = is.read();
                    if(ch == -1) break;
                    System.out.println((char)ch);
                }
                is.close();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }
    static public String getKbdString() {
        byte bKbd[] = new byte[256];
        int iCnt = 0;
        String szStr ="";

        try {
            iCnt = System.in.read(bKbd);
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        szStr = new String(bKbd, 0, iCnt);
        szStr = szStr.trim();
        return szStr;
    }
}

