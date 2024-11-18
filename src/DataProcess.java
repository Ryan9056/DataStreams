import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcess {


    public static ArrayList<Integer> lineread(String word) {


        ArrayList<Integer> linenumbers = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a text file");
        int result = fileChooser.showOpenDialog(null);
        String file = null;

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            file = selectedFile.getAbsolutePath();
        }


        if (file == null) {
            return null;
        }

        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            List<String> wordLines = lines
                    .filter(line -> line.contains(word.toLowerCase()))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> numberLines = Files.lines(Paths.get(file))) {
            List<String> numberedLines = numberLines.collect(Collectors.toList());

            for (int i = 0; i < numberedLines.size(); i++) {
                String number = numberedLines.get(i);
                if (number.contains(word.toLowerCase())) {
                    linenumbers.add(i+1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return linenumbers;

    }



}
