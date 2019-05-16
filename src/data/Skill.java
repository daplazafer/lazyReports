
package data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lib.FileUtil;

/**
 *
 * @author dpf
 */
class Skill {
    
    private final List<Level> levels;
    private final String name;
    
    public Skill(File dir,String extension){
        this.name = dir.getName();
        levels = new ArrayList<>();
        for(File level:FileUtil.findFiles(dir.getAbsolutePath(), extension)){
            levels.add(new Level(level));
        }
    }
    
    public String getName(){
        return name;
    }
    
    public List<Level> getLevels(){
        return levels;
    }
    
}
