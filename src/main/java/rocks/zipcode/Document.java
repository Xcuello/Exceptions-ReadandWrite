package rocks.zipcode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final File file;

    public Document(String fileName) throws IOException {

        this(new File(fileName));
    }

    public Document(File file) throws IOException {

        this.file = file;
        this.fileWriter = new FileWriter(file);
    }

    @Override
    public void write(String contentToBeWritten) {

        try {
            fileWriter.write(contentToBeWritten);

            fileWriter.flush();

        } catch (IOException e) {

            e.printStackTrace();

            throw new IllegalArgumentException();

        }catch (IllegalArgumentException iae) {

            iae.printStackTrace();
        }
    }

    @Override
    public void write(Integer lineNumber, String valueToBeWritten) {

        try {
            Path path = Paths.get("/Users/xzaviacuello/Labs/exceptions-readandwrite/target/file.txt");

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            lines.set(lineNumber, valueToBeWritten);

            Files.write(path, lines.subList(0, lines.size() - 1), StandardCharsets.UTF_8);

            Files.write(path, lines.get(lines.size() - 1).getBytes("UTF-8"), StandardOpenOption.APPEND);

        }catch (IllegalArgumentException e) {

            e.printStackTrace();

        }catch (IOException io){

            io.printStackTrace();
        }
    }

    @Override
    public String read(Integer lineNumber) throws IOException {

        return Files.readAllLines(file.toPath()).get(lineNumber);
    }

    @Override
    public String read() throws IOException {

        return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

        
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {

        try{
            Path path = Paths.get("/Users/xzaviacuello/Labs/exceptions-readandwrite/target/file.txt");

            String content = new String(Files.readAllBytes(path),StandardCharsets.UTF_8);

            content = content.replaceAll(stringToReplace, replacementString);

            Files.write(path, content.getBytes(StandardCharsets.UTF_8));

        }catch(IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void overWrite(String content) {

        try {
            Path path = Paths.get("/Users/xzaviacuello/Labs/exceptions-readandwrite/target/file.txt");

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            lines.clear();

            lines.add(content);

            Files.write(path, lines.subList(0, lines.size() - 1), StandardCharsets.UTF_8);

            Files.write(path, lines.get(lines.size() - 1).getBytes("UTF-8"), StandardOpenOption.APPEND);

        }catch (IOException io){

            io.printStackTrace();
        }
    }

    public List<String> toList() {

        return null;
    }

    @Override
    public File getFile() {

        Path path = Paths.get("/Users/xzaviacuello/Labs/exceptions-readandwrite/target/file.txt");

        return null;
    }

    @Override
    public String toString() {

        try{

            return file.toString() + "{" + read() + "}";

        }catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }
}
