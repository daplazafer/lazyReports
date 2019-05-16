
package app;

import data.SkillsLoader;
import gui.MainWindow;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dpf
 */
public class App {
    
    private static final String APP_NAME = "lazyreports";
    private static final String APP_VERSION = "1.0";
    
    public static final String SKILLS_PATH = "SKILLS_PATH";
    public static final String LEVEL_EXT = "LEVEL_EXTENSION";
    public static final String OUTPUT_PATH = "OUTPUT_PATH";
    public static final String OUTPUT_EXT = "OUTPUT_EXTENSION";
    public static final String NAME1_KEY = "NAME_KEY";
    public static final String NAME2_KEY = "NAME2_KEY";

    private static final String default_settings[][] = {
        {SKILLS_PATH,"skills"},
        {LEVEL_EXT,"txt"},
        {OUTPUT_PATH,"reports"},
        {OUTPUT_EXT,"txt"},
        {NAME1_KEY,"%NAME%"},
        {NAME2_KEY,"%NAME2%"},
    }; 
    
    public static Map<String,String> cfg;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        log("Initializing... \n");
        initConfig();
        initFolders();
        initWindow();        
    }
    
    private static void initConfig(){
        cfg = new HashMap<>();
        for(String[] set: default_settings){
            cfg.put(set[0],set[1]);
        }
    }
    
    private static void initFolders(){
        logLoading("attributes folder");
        File attributesFolder = new File(cfg.get(SKILLS_PATH));
        if(!attributesFolder.exists()){
            attributesFolder.mkdirs();
        }
        logDone();
        
        logLoading("output folder");
        File outputFolder = new File(cfg.get(OUTPUT_PATH));
        if(!outputFolder.exists()){
            outputFolder.mkdirs();
        }
        logDone();
    }
    
    private static void initWindow(){
        logLoading("skills");
        SkillsLoader al = new SkillsLoader(cfg.get(SKILLS_PATH),cfg.get(LEVEL_EXT));
        logDone();
        logLoading("main window");
        String title = "";
        title += APP_NAME;
        if(!APP_VERSION.equals("")){
            title += " v"+APP_VERSION;
        }
        MainWindow mw = new MainWindow(al,title);
        mw.setVisible(true);
        logDone();
    }
    
    public static void logLoading(String module){
        log("Loading "+module+"... ");
    }
    
    public static void logDone(){
        log("done.\n");
    }
    
    public static void log(String textLog){
        System.out.print(textLog);
    }
    
}
