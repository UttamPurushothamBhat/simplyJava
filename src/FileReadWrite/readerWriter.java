package FileReadWrite;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.stream.Stream;

public class readerWriter {
    public static void main(String[] args) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Working");
            writer.write("\n Uttam Bhat");
            writer.write("\n Uttam Bhat");
            writer.write("\n Uttam Bhat");
            writer.write("\n Uttam Bhat");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            Stream<String> stream = reader.lines();
            stream.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        String toWrite = "\n Fucking end it all";

        byte[] toWriteBytes = toWrite.getBytes();

        try{
            OutputStream outputStream = new FileOutputStream("output.txt");
            outputStream.write(toWriteBytes);
            outputStream.write(toWriteBytes);
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            InputStream inputStream = new FileInputStream("output.txt");
            byte[] array  = inputStream.readAllBytes();
            String data = new String(array);
            System.out.println(data);
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        File file = new File("output.txt");


        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] array  = inputStream.readAllBytes();
            String data = new String(array);
            System.out.println(data);
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

