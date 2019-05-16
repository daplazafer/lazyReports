
package lib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dpf
 */
public enum FileUtil {;
    
    public static List<File> findFiles(String path, String ext) {
        List<File> fileList = new ArrayList<>();
        File f = new File(path);
        File[] allFiles = f.listFiles();
        for (File file : allFiles) {
            if (file.isFile() && file.toString().contains(ext)) {
                fileList.add(file);
            }
        }
        return fileList;
    }
    
    public static List<File> findDirectories(String path){
        List<File> dirList = new ArrayList<>();
        File f = new File(path);
        File[] allFiles = f.listFiles();
        for (File file : allFiles) {
            if (file.isDirectory()) {
                dirList.add(file);
            }
        }
        return dirList;
    }
    
    public static List<String> readFile(File file){
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.ISO_8859_1);
        } catch (IOException ex) {}
        return lines;
    }
    
    public static void writeFile(File file, List<String> lines){
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(String line: lines){
                out.write(line);
                out.newLine();
            }
            
        } catch (IOException ex) {
        }finally{
            try{
                if(out != null)
                    out.close();
            } catch (IOException ex) {
            }
        }
    }
}
