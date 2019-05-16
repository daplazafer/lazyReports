package app;

import lib.Tuple3;
import data.SkillsLoader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dpf
 */
public class ReportGenerator {

    private final SkillsLoader sl;
    private final String name1;
    private final String name2;

    public ReportGenerator(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
        this.sl = new SkillsLoader(App.cfg.get(App.SKILLS_PATH), App.cfg.get(App.LEVEL_EXT));
    }

    public List<String> generateReport(List<Tuple3<String, String, Boolean>> skillLevelList, String notes) {
        // BUILDING THE REPORT
        List<String> lines = new ArrayList<>();
        
        // Skills
        boolean append = false;
        for (Tuple3<String, String, Boolean> tslc : skillLevelList) {
            String tblock = format(sl.randomize(tslc.x, tslc.y));
            if (!tblock.equals("")) {
                if (append) {
                    lines.add(tblock);
                } else {
                    if (lines.isEmpty()) {
                        lines.add("");
                    }
                    lines.set(lines.size() - 1, lines.get(lines.size() - 1) + tblock);
                }
            }
            append = tslc.z;
        }

        // Notes
        if (!notes.equals("")) {
            notes = format(notes);
            if (append) {
                lines.add(notes);
            } else {
                if (lines.isEmpty()) {
                    lines.add("");
                }
                lines.set(lines.size() - 1, lines.get(lines.size() - 1) + notes);
            }
        }
        return lines;
    }

    private String format(String text) {
        String ftext = text;

        // Formating the end of the string to end with '. ' 
        if (!ftext.equals("") && !ftext.endsWith(". ")) {
            // If it ends with ' ', those spaces are removed
            while (ftext.endsWith(" ")) {
                ftext = ftext.substring(0, ftext.length() - 2);
            }
            // If the line does not end with '.' it is added
            if (!ftext.endsWith(".")) {
                ftext += ".";
            }
            // Adding a space at the end
            ftext += " ";
        }

        // REPLACEMENTS  
        ftext = ftext.replaceAll(App.cfg.get(App.NAME1_KEY), name1);
        ftext = ftext.replaceAll(App.cfg.get(App.NAME2_KEY), name2);

        return ftext;
    }

}
