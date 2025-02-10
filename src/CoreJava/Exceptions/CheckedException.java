package CoreJava.Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {

    public static void main(String[] args){
//        try{
//            File file = new File("example.txt");
//            Scanner scanner = new Scanner(file);
//            while(scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }
//            scanner.close();
//        }catch(FileNotFoundException e){
//            System.out.println("File not found");
//        }

        String filename = "text.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
