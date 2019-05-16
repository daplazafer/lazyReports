package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lib.FileUtil;

/**
 *
 * @author dpf
 */
class Level {

    private final String name;
    private final File file;

    Level(File file) {
        this.file = file;
        this.name = file.getName().substring(0, file.getName().lastIndexOf("."));
    }

    String getName() {
        return name;
    }

    String randomize() {
        String randomLine = "";
        List<String> lines = FileUtil.readFile(file);
        while(lines.remove("")) { }  
            if(lines.size() > 0)
                randomLine = lines.get(new Random().nextInt(lines.size()));
        return randomLine;
    }

}
