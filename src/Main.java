import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Activity ac=new Activity();
        int choice;
        String replay;
do {
    System.out.println("1: Read The Existing Data");
    System.out.println("2: Insert New Data");
    System.out.println("3: Update Data");
    System.out.println("4: Delete Data");
    System.out.println("5. Exit");
    System.out.println("Enter your choice:");
    choice = input.nextInt();
    switch (choice) {
        case 1:
            ac.readData();
            break;

        case 2:
            ac.insertData();
            break;

        case 3:
            ac.updateData();
            break;

        case 4:
            ac.deleteData();
            break;

        case 5:
            System.exit(0);
            break;
        default:
            System.out.println("Select VALID option.");
    }
    System.out.println("Do yo want to continue? Press y");
    replay = input.next();
}while (replay.equals("Y"));

    }
}