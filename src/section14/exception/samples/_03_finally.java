package section14.exception.samples;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class _03_finally {
    public static void main(String [] args){

        File file = new File("C:\\dev\\bc\\cursos\\curso java pdf\\12 section12\\in.txt.txt");
        Scanner sc = null;


        try{
            System.out.println();
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch (IOException e){
            System.out.println("Error opening file: "+ e.getMessage());

        }
        finally {
            if(sc !=null){
                System.out.println();
                System.out.println("Closing file!");

            }
        }
    }
}
