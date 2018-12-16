import java.io.*;
import java.util.Arrays;


public class test {
    public static void affichageMapConsole(String name){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        //String map = "maps\\mapTest.txt";
        //System.out.println(map);
        File file = new File(name);
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
    public static void main(String[] args) {
        affichageMapConsole("maps\\mapTest.txt");
    }
}
