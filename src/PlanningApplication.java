import java.util.Comparator;
import java.util.Scanner;

public class PlanningApplication {

    /**
     * Main method that executes the program
     *
     * @param args - the array of arguments for the main method
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        JobCatalog catalog = new JobCatalog();
        catalog.readData();
        String prompt = "1 - Show all jobs in the catalog.\n2 - Add a new job.\n" +
                "3 - Remove a job from list.\n4 - Change date of existing job.\n" +
                "5 - Print jobs by date.\n6 - Print required materials by date.\n" +
                "7 - Quit application.\n";
        System.out.println(prompt);
        int command = in.nextInt();
        while (true) {
            switch (command) {
                case 1 -> {
                    System.out.println("================");
                    JobCatalog.listOfJobs.stream()
                            .sorted(Comparator.comparing(Job::getPlannedDate))
                            .map(Job::toString)
                            .forEach(System.out::println);
                    System.out.println("================\n");
                }
                case 2 -> catalog.option2(in);
                case 3 -> {
                    System.out.println("Enter job number to be removed: ");
                    int remove = in.nextInt();
                    JobCatalog.listOfJobs.removeIf(x -> x.getJobNumber() == remove);
                }
                case 4 -> catalog.option4(in);
                case 5 -> {
                    Date date = new Date(in);
                    JobCatalog.listOfJobs.stream()
                            .filter(x -> x.getPlannedDate().equals(date))
                            .forEach(System.out::println);
                }
                case 6 -> {
                    Date date = new Date(in);
                    JobCatalog.listOfJobs.stream()
                            .filter(x -> x.getPlannedDate().equals(date))
                            .map(Job::getRequiredEquipment)
                            .distinct()
                            .forEach(System.out::println);
                }
                case 7 ->{
                    catalog.saveData();
                    System.exit(0);
                }
            }
            System.out.println(prompt);
            command = in.nextInt();
        }
    }
}
