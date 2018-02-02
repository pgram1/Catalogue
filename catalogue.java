import java.util.Scanner;
public class catalogue {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /*
        ordering program
        for restaurants
        */
        //catalogue constants
        String[] catS = new String[] {
            "1.Cookie",
            "2.Coke",
            "3.Pie",
            "4.Croisant with chicken",
            "5.Candy bar"
        };
        double[] cat = new double[] {
            1,
            1.7,
            2,
            2.5,
            3
        };
        //prompt for money
        double wallet = promptForMoney();
        //showing available catalogue items that the user can afford
        System.out.println("What you can do:");
        whatCanDo(catS, cat, wallet);
        //purchace
        do {
            int noOfPurch = promptPurch();
            wallet = makePurch(wallet, noOfPurch, cat);
            System.out.println("Your current balance is " + wallet + " $");
            //asking if the user wants to purchase more items.
            if (wannaBuy() == 1) {
                System.out.println("What you can do:");
                whatCanDo(catS, cat, wallet);
            } else {
                break;
            }
        } while (wallet > 0); //the user must have funds
        System.out.println("Thank you for preferring us");
    }

    public static double promptForMoney() {
        double money;
        do {
            System.out.print("How much money do you have?\n-----\n> ");
            money = scan.nextDouble();
        } while (money <= 0);
        return money;
    }

    public static void whatCanDo(String[] name, double[] money, double wallet) {
        if (money[0] <= wallet) {
            System.out.println("You can purchase these items:");
            for (int i = 0; i < name.length; i++) {
                if (money[i] <= wallet) {
                    System.out.println(name[i] + ": " + money[i] + " $");
                }
            }
        } else {
            System.out.println("Nothing, insufficient funds.\nThank you for preferring us\nThe program will terminate.");
            System.exit(0);
        }
    }

    public static int promptPurch() {
        int x;
        System.out.print("What do you want to purchace? (Type its number)\n-----\n> ");
        return x = scan.nextInt();
    }

    public static double makePurch(double startMoney, int placeInCat, double[] Cat) {
        return (startMoney -= Cat[placeInCat - 1]);
    }

    public static int wannaBuy() {
        System.out.print("Want to purchase something else?\nType 1 for yes\nor 0 for no.\n-----\n> ");
        return scan.nextInt();
    }
}