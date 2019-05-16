
package data;

import lib.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dpf
 */
public class SkillsLoader {
    
    private final File attributesPath;
    private final String extension;
    private List<Skill> skills;
    
    public SkillsLoader(String attributesPath, String extension){
        this.attributesPath = new File(attributesPath);
        this.extension = extension;
        reload();    
    }
    
    public final void reload(){
        this.skills = new ArrayList<>();
        for(File f:FileUtil.findDirectories(attributesPath.getAbsolutePath())){
            skills.add(new Skill(f,extension));
        }
    }
    
    public List<String> getSkills(){
        List<String> sk = new ArrayList<>();
        for(Skill s: skills){
            sk.add(s.getName());
        }
        return sk;
    }
    
    public List<String> getLevels(String skill){
        List<String> lvls = new ArrayList<>();        
        for(Skill s:skills){
            if(s.getName().equals(skill)){
                for(Level l:s.getLevels()){
                    lvls.add(l.getName());
                }
            } 
        }
        return lvls;
    }
    
    public String randomize(String skill, String level){
        String random = "";
        for(Skill s: skills){
            if(s.getName().equals(skill)){
                for(Level l : s.getLevels()){
                    if(l.getName().equals(level)){
                        return l.randomize();
                    }         
                }
            }
        }
        return random;
    }

}
