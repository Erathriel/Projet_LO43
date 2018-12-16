import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class test {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        try{
            int c;
            char car = 0;
            String map = "C:\\Users\\Geoffrey\\Desktop\\Cours\\Projet_LO43\\maps\\mapTest.txt";
            File ips = new File(map);
            FileReader ipsr = new FileReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            StringBuffer ligne = new StringBuffer();
            while ((c = br.read()) != -1) {
                car = (char) br.read();
                c = c + 1;
                ligne.append(car);
                if (car == '\n') {
                    System.out.println("ligne: " + ligne);
                    ligne.delete(0, ligne.length());
                }
            }
            if (ligne.length() != 0)
                System.out.println("ligne: " + ligne);


            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
