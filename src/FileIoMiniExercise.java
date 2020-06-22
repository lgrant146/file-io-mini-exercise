import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIoMiniExercise extends Instructor {
    public FileIoMiniExercise(String name) {
        super(name);
    }

    public static void main(String[] args) {

        // TODO: define the path to the instructor-names.txt file
            Path FileInstructors = Paths.get("src", "instructor-names.txt");



        // TODO: uncomment the following variable declarations
        List<Instructor> instructors;
        List<String> names = new ArrayList<>();

        // TODO: read the contents of the instructor-names.txt file and store the list of strings into the 'names' variable
        try {
            names = Files.readAllLines(FileInstructors);
            System.out.println(names);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO: assign the 'instructors' variable a list of Instructor objects with names matching the list of strings/names from the text file (the Instructor class has a helpful method for this)
            instructors = nameStringsToInstructors(names);
        System.out.println(instructors);

        // TODO: greet all instructors by their names

            greetInstructors(instructors);


        // TODO: change "Fred" to "David" in the list of Instructor objects
        System.out.println("==========================");
            changeFredToDavid(instructors);
            greetInstructors(instructors);

        // TODO: update the list of strings/names ('names' variable) to the latest names from the Instructor objects (the Instructor class has a helpful method for this)
//            instructors = nameStringsToInstructors(instructors);

        // TODO: overwrite the instructors-names.txt file with the latest list of names

        // TODO: uncomment the following line
//        System.out.println("============== after name change...");

        // TODO: greet instructors again (no need to reread the text file again; just use the existing list of instructors in memory)


    }

    /**
     * This method takes in a list of Instructor objects and prints out "Hello, NAME!" for each Instructor object's name
     * @param instructors is a list of Instructor objects
     */
    public static void greetInstructors(List<Instructor> instructors) {
        for (Instructor instructor : instructors) {
            System.out.printf("Hello, %s!%n", instructor.getName());
        }
    }

    /**
     * This method takes in a list of Instructor objects and changes the name of the Instructor with a name of "Fred" to "David"
     * @param instructors is a list of Instructor objects
     */
    public static void changeFredToDavid(List<Instructor> instructors) {
        for (Instructor instructor : instructors) {
            if (instructor.getName().equals("Fred")) {
                instructor.setName("David");
            }
        }
    }

}
