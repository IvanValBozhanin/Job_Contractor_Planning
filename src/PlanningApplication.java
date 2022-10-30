import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlanningApplication {

    /**
     * Main method that executes the program
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        readData();
        String prompt = "1 - Show all jobs in the catalog.\n2 - Add a new job.\n" +
                "3 - Remove a job from list.\n" +
                "4 - Change date of existing job.\n" +
                "5-6 - To be implemented.\n7 - Quit application.\n";
        System.out.println(prompt);

        int command = in.nextInt();
        while(command != 7){
            if(command == 1){
                System.out.println("================");
                Job.listOfJobs.stream()
                        .map(Job::toString)
                        .forEach(System.out::println);
                System.out.println("================\n");
            }
            else if(command == 2){
                System.out.println("Please enter the following information correctly:");
                Address address;
                Job job;
                {
                    System.out.print("Name of street: ");
                    String addressName = in.next();
                    System.out.print("Number of street: ");
                    int addressNumber = in.nextInt();
                    System.out.print("Zipcode of street: ");
                    String addressZip = in.next();
                    System.out.print("City: ");
                    String addressCity = in.next();
                    address = new Address(addressName, addressNumber, addressZip, addressCity);
                }
                {
                    System.out.print("Job description: ");
                    in.nextLine();
                    String des = in.nextLine();
                    Date date = scanDate(in);
                    job = new Job(address, des, new ArrayList<>(), date);
                }
                Job.listOfJobs.add(job);
                System.out.println("Job Successfully Added!\n");
            }
            else if(command == 3){
                System.out.println("Enter job number to be removed: ");
                int remove = in.nextInt();
                Job.listOfJobs.removeIf(x -> x.getJobNumber()==remove);
            }
            else if(command == 4){
                System.out.println("Enter job number to have its date changed: ");
                int change = in.nextInt();
                Date date = scanDate(in);
                for(int i = 0;i<Job.listOfJobs.size();++i){
                    if(Job.listOfJobs.get(i).getJobNumber() == change){
                        Job.listOfJobs.get(i).getPlannedDate().setDay(date.getDay());
                        Job.listOfJobs.get(i).getPlannedDate().setMonth(date.getMonth());
                        Job.listOfJobs.get(i).getPlannedDate().setYear(date.getYear());
                        break;
                    }
                }
            } else if (command == 5) {
                Date date = scanDate(in);
                Job.listOfJobs.stream()
                        .filter(x -> x.getPlannedDate().equals(date))
                        .forEach(System.out::println);
            } else if(command == 6){
                Date date = scanDate(in);
                Job.listOfJobs.stream()
                        .filter(x -> x.getPlannedDate().equals(date))
                        .map(Job::getRequiredEquipment)
                        .distinct()
                        .forEach(System.out::println);
            }
            System.out.println(prompt);
            command = in.nextInt();
        }
        saveData();
    }

    public static Date scanDate(Scanner in) {
        System.out.print("Day: ");
        int day = in.nextInt();
        System.out.print("Month: ");
        int month = in.nextInt();
        System.out.print("Year: ");
        int year = in.nextInt();
        return new Date(day, month, year);
    }

    public static void saveData() {
        try(PrintWriter writer = new PrintWriter("joblist.txt")){
            for (Job job: Job.listOfJobs) {
                writer.write(job.getLocation().getStreet() + "; ");
                writer.write(job.getLocation().getNumber() + "; ");
                writer.write(job.getLocation().getZipCode() + "; ");
                writer.write(job.getLocation().getCity() + "\n");
                writer.write(job.getDescription() + "\n");
                for (Equipment eq :
                        job.getRequiredEquipment()) {
                    if(eq instanceof Torch) writer.write("Torch, ");
                    if(eq instanceof JackHammer) writer.write("JackHammer, ");
                    if(eq instanceof ScaffoldingTower) writer.write("Scaffolding, ");
                    if(eq instanceof ConcreteMixer) writer.write("ConcreteMixer, ");
                    writer.write(eq.getRequirements() + "; ");
                }
                writer.write("\n" + job.getPlannedDate().getDay()+"-");
                writer.write(job.getPlannedDate().getMonth()+"-");
                writer.write(job.getPlannedDate().getYear() + "\n");
            }
        } catch (IOException ignored){}
    }

    /**
     * Method to read from file. Fills the List with Jobs that are read from file.
     */
    public static void readData(){
        try(BufferedReader reader = new BufferedReader(new FileReader("joblist.txt"))){
            String line;
            while((line = reader.readLine()) != null) {
                Address address = new Address(line);
                String description = reader.readLine();
                Scanner instruments = new Scanner(reader.readLine());
                instruments.useDelimiter("; |;");
                ArrayList<Equipment> equipmentArrayList = new ArrayList<>();
                while (instruments.hasNext()) {
                    Scanner instrument = new Scanner(instruments.next());
                    instrument.useDelimiter(", ");
                    String nameInstrument = instrument.next();
                    switch (nameInstrument) {
                        case "JackHammer" -> equipmentArrayList.add(new JackHammer(instrument.next()));
                        case "Scaffolding" -> equipmentArrayList.add(new ScaffoldingTower(instrument.next()));
                        case "ConcreteMixer" -> equipmentArrayList.add(new ConcreteMixer((instrument.next())));
                        case "Torch" -> equipmentArrayList.add(new Torch(instrument.next()));
                    }
                }
                Date date = new Date(reader.readLine());
                Job.listOfJobs.add(new Job(address, description, equipmentArrayList, date));
            }
        } catch (IOException ignored){}
    }
}
