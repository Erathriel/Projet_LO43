import java.io.*;
import java.util.Arrays;


public class test {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        //System.out.println("Hello, World");
        /*try{
            int c;
            char car;
            String map = "C:\\Users\\Geoffrey\\Desktop\\Cours\\Projet_LO43\\maps\\mapTest.txt";
            File ips = new File(map);
            FileReader ipsr = new FileReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            StringBuffer ligne = new StringBuffer();
            while ((c = br.read()) != -1) {
                car = (char) br.read();
                c = c + 1;
                System.out.println("Le caractère est : " + c);
                ligne.append(car);
                if (car == '\n') {
                    System.out.println(ligne);
                    ligne.delete(0, ligne.length());
                }
            }
            if (ligne.length() != 0)
                System.out.println(ligne);


            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }*/
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        String map = "maps\\mapTest.txt";
        System.out.println(map);
        File file = new File(map);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            //byte[] buffer = new byte[8];
            int buffer;
            String ligne="";
            while((buffer = fis.read()) != -1){
                //System.out.println((char) buffer);
                ligne= ligne + (char) buffer;
            }
            System.out.println(ligne);
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
