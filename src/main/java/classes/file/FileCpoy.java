package classes.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCpoy {
    public static void main(String[] args) {
        String origin = "/Users/jinsh1210/Coding/java/Java-eclipse/Temp/aaa.txt";
        String newName = "/Users/jinsh1210/Coding/java/Java-eclipse/Temp/my_exp.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(origin);
            fos = new FileOutputStream(newName);

            int i;
            byte[] readByte = new byte[100];

            while ((i = fis.read(readByte)) != -1) {
                fos.write(readByte, 0, i);
            }
            System.out.println("정상적으로 복사되었습니다.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
