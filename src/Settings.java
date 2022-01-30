import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Settings {
    public static String STUDENTS_PATH = "studenti.xml";
    public static String TEACHERS_PATH = "profesori.xml";
    public static String COURSES_PATH= "cursuri.xml";
    public static LOAD_TYPE loadType = LOAD_TYPE.HARDCODAT;
    public static DISPLAY_TYPE displayType = DISPLAY_TYPE.FISIER;

    public static HashMap<LOAD_TYPE, IDataLoader> dataloader = new HashMap<>() {{
        put(LOAD_TYPE.HARDCODAT, new HardcodatDataManager());
        put(LOAD_TYPE.FILE, new FileDataManager());
        put(LOAD_TYPE.KEYBOARD, new KeyboardDataManager());
    }};

    public static HashMap<DISPLAY_TYPE, IDisplayManager> displayloader = new HashMap<DISPLAY_TYPE, IDisplayManager>() {{
        put(DISPLAY_TYPE.CONSOLA,new ConsoleDisplay());
        put(DISPLAY_TYPE.FISIER,new FileDisplay());
        put(DISPLAY_TYPE.GUI,new GraphicUserInterfaceDisplay());
    }};

    public static void initApplication() {
        try(Scanner cin = new Scanner(new File("settings.txt")))
        {
            String line;
            String[] dataFromFile = new String[5];
            int i = 0;
            int index = 0;
            int lastIndex = 0;
            while(cin.hasNextLine())
            {
                line = cin.nextLine();
                index = line.indexOf("\"")+1;
                lastIndex = line.lastIndexOf("\"");
                dataFromFile[i++] = line.substring(index,lastIndex);
            }
            STUDENTS_PATH = dataFromFile[0];
            TEACHERS_PATH = dataFromFile[1];
            COURSES_PATH = dataFromFile[2];
            switch (dataFromFile[3])
            {
                case "HARDCODAT":
                    loadType = LOAD_TYPE.HARDCODAT;
                    break;
                case "FILE":
                    loadType = LOAD_TYPE.FILE;
                    break;
                case "KEYBOARD":
                    loadType = LOAD_TYPE.KEYBOARD;
                    break;
            }
            switch (dataFromFile[4])
            {
                case "CONSOLA":
                    displayType = DISPLAY_TYPE.CONSOLA;
                    break;
                case "FISIER":
                    displayType = DISPLAY_TYPE.FISIER;
                    break;
                case "GUI":
                    displayType = DISPLAY_TYPE.GUI;
                    break;
            }
            cin.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
