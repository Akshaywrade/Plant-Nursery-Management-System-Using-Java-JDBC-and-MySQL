import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        PlantDAO dao = new PlantDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- PLANT NURSERY MANAGEMENT ---");
            System.out.println("1. Add Plant");
            System.out.println("2. View Plants");
            System.out.println("3. Update Plant");
            System.out.println("4. Delete Plant");
            System.out.println("5. Search Plant");
            System.out.println("6. Exit");

            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: dao.addPlant(); break;
                case 2: dao.viewPlants(); break;
                case 3: dao.updatePlant(); break;
                case 4: dao.deletePlant(); break;
                case 5: dao.searchPlant(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid Choice");
            }
        }
    }
}