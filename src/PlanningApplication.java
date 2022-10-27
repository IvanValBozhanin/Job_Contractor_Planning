import java.io.File;
import java.io.IOException;
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
        for (Job job :
                Job.listOfJobs) {
            System.out.println(job);
        }
        /*String prompt = "1 - Show all jobs in the catalog.\n2 - Add a new job.\n" +
                "3-6 - To be implemented.\n7 - Quit application.\n";
        System.out.println(prompt);

        int command = in.nextInt();
        JobCatalog jobCatalog = new JobCatalog();
        while(command != 7){
            if(command == 1){
                System.out.println("================");
                System.out.println(jobCatalog.toString());
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
                    System.out.print("Day: ");
                    int day = in.nextInt();
                    System.out.print("Month: ");
                    int month = in.nextInt();
                    System.out.print("Year: ");
                    int year = in.nextInt();
                    job = new Job(address, des, new ArrayList<>(), new Date(day, month, year));
                }
                jobCatalog.addJob(job);
                System.out.println("Job Successfully Added!\n");
            }
            System.out.println(prompt);
            command = in.nextInt();
        }
        */

    }

    public static void readData(){
        try(Scanner in = new Scanner(new File("joblist.txt"))){
            while(in.hasNextLine()) {
                Address address = new Address(in.nextLine());
                String description = in.nextLine();
                Scanner instruments = new Scanner(in.nextLine());
                instruments.useDelimiter("; ");
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
                Date date = new Date(in.nextLine());
                Job.listOfJobs.add(new Job(address, description, equipmentArrayList, date));
            }
        } catch (IOException ignored){}
    }
}
