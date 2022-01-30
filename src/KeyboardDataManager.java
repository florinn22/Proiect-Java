import java.util.*;
import java.util.Scanner;


public class KeyboardDataManager implements IDataLoader {
    @Override
    public Student[] createStudentsData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu un nume:");
        String nume = sc.nextLine();
        System.out.println("Introdu prenume:");
        String prenume = sc.nextLine();
        return new Student[0];
    }
    @Override
    public Profesor[] createProfesorData() {
        return new Profesor[0];
    }

    @Override
    public Curs[] createCoursesData() {
        return new Curs[0];
    }
}
