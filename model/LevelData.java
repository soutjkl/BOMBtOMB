package model;

import java.io.*;

public class LevelData {
    public static String LEVEL_ONE = "1";
    public static final String[][] LEVEL = {{"Bachelor"}, {"Bachelor","TomboArmed"}};
    public static final int[][][] LEVEL_VALUE = {{{0,99}},{{0,49},{50,99}}};

    public LevelData() {
        try {
            File file = new File("Level.txt");
            if (!file.exists()) {
                BufferedWriter bwr = new BufferedWriter(new FileWriter(file));
                bwr.write("1");
                bwr.close();
                LEVEL_ONE = "1";
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                LEVEL_ONE = reader.readLine();
            }
        } catch (IOException ex) {
        }
    }

    public static void write(String level) {
        File file = new File("Level.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(level);
            writer.close();
            LEVEL_ONE = level;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
