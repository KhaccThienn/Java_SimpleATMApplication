import java.util.Random;
import java.util.Scanner;

public class ATMApplication {
    public static void main(String[] args) throws InterruptedException {
        final String USERNAME = "khaccthienn";
        final String PASSWORD = "12345678";
        final String PIN = "190623";
        boolean isLogged = false;

        long balance = 0;
        long amount = 0;

        int choice;
        String choose;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        do {
            System.out.println("\n\t============> WELCOME TO KT BANK <============");
            System.out.println("1. Login.");
            System.out.println("2. Withdraw Cash.");
            System.out.println("3. Pay In.");
            System.out.println("4. Check Balance.");
            System.out.println("5. Logout.");
            System.out.println("6. Quit.");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    if (isLogged) {
                        System.out.println("You're already logged in !");
                        break;
                    }
                    System.out.print("Enter Username: ");
                    String username = sc.nextLine();
                    if (!username.isBlank() && USERNAME.compareTo(username) == 0) {
                        System.out.print("Enter password: ");
                        String password = sc.nextLine();
                        if (!password.isBlank() && PASSWORD.compareTo(password) == 0) {
                            isLogged = true;
                            System.out.println("You're Logged In !");
                        } else {
                            System.out.println("Invalid Account !");
                        }
                    } else {
                        System.out.println("Invalid Account !");
                    }
                }
                case 2 -> {
                    if (isLogged) {
                        int option;
                        boolean isWithDrawable = true;
                        do {
                            System.out.println("Choose amount to withdraw cash !");
                            System.out.println("1-- 10.000 vnd");
                            System.out.println("2-- 20.000 vnd");
                            System.out.println("3-- 50.000 vnd");
                            System.out.println("4-- 100.000 vnd");
                            System.out.println("5-- 200.000 vnd");
                            System.out.println("6-- 500.000 vnd");
                            System.out.println("7-- 1.000.000 vnd");
                            System.out.println("8-- 2.000.000 vnd");
                            System.out.println("9-- 5.000.000 vnd");
                            System.out.println("0-- Enter amount");
                            System.out.print("You option: ");
                            option = Integer.parseInt(sc.nextLine());

                            switch (option) {
                                case 1 -> amount = 10000;
                                case 2 -> amount = 20000;
                                case 3 -> amount = 50000;
                                case 4 -> amount = 100000;
                                case 5 -> amount = 200000;
                                case 6 -> amount = 500000;
                                case 7 -> amount = 1000000;
                                case 8 -> amount = 2000000;
                                case 9 -> amount = 5000000;
                                case 0 -> {
                                    System.out.print("Enter the amount: ");
                                    amount = Long.parseLong(sc.nextLine());
                                    if (amount < 0 || amount % 10000 != 0) {
                                        System.out.println("Please provide valid amount !");
                                        amount = 0;
                                        isWithDrawable = false;
                                    }
                                }
                                default -> System.out.println("Invalid Option, choose again !");
                            }
                            if (isWithDrawable) {
                                if (balance >= amount) {
                                    System.out.print("Enter PIN Code: ");
                                    String pinCode = sc.nextLine();
                                    if (PIN.compareTo(pinCode) == 0) {
                                        System.out.println("Pending...");
                                        for (int i = 0 ; i <= 100 ; i++) {
                                            sb.setLength(0);
                                            sb.append("#".repeat(i));
                                            Thread.sleep(100);
                                            System.out.print("[" + String.format("%-100s", sb) + "] " +  i + "%");
                                            System.out.print("\r");
                                        }
                                        System.out.println("Success !");
                                        balance -= amount;
                                        System.out.println("\tWithdraw Cash: " + amount + " vnd");
                                        System.out.println("\tYour balance: " + balance + " vnd");
                                    } else {
                                        System.out.println("Incorrect PIN Code !");
                                    }
                                } else {
                                    System.out.println("Not Enough Balance !");
                                }
                            }
                        } while (option < 0 || option > 9);
                    } else {
                        System.out.println("You must be logged in to use this service !");
                    }
                }
                case 3 -> {
                    if (isLogged) {
                        System.out.print("Enter the amount: ");
                        amount = Long.parseLong(sc.nextLine());
                        if (amount > 0 || amount % 10000 == 0) {
                            System.out.print("Enter PIN Code: ");
                            String pinCode = sc.nextLine();
                            if (PIN.compareTo(pinCode) == 0) {
                                System.out.println("Pending...");
                                for (int i = 0 ; i <= 100 ; i++) {
                                    sb.setLength(0);
                                    sb.append("#".repeat(i));
                                    Thread.sleep(100);
                                    System.out.print("[" + String.format("%-100s", sb) + "] " +  i + "%");
                                    System.out.print("\r");
                                }
                                System.out.println("Success !");
                                balance += amount;
                                System.out.println("\tPay In Successfully");
                                System.out.println("\tYour balance: " + balance + " vnd");
                            } else {
                                System.out.println("Incorrect PIN Code");
                            }

                        } else {
                            System.out.println("Please provide valid amount !");
                        }
                    } else {
                        System.out.println("You must be logged in to use this service !");
                    }
                }
                case 4 -> {
                    if (isLogged) {
                        System.out.println("\tYour balance: " + balance + " vnd");
                    } else {
                        System.out.println("You must be logged in to use this service !");
                    }
                }
                case 5 -> {
                    if (isLogged) {
                        System.out.print("Do you wanna log out ? (y - Yes | n - No):");
                        choose = sc.nextLine();
                        if (choose.toLowerCase().compareTo("y") == 0 || choose.compareTo("Y") == 0) {
                            isLogged = false;
                            System.out.println("You're Logged Out !");
                        }
                    } else {
                        System.out.println("You're Already Logged Out !");
                    }
                }
                case 6 -> {
                    System.out.print("Do you wanna quit ? (y - Yes | n - No):");
                    choose = sc.nextLine();
                    if (choose.toLowerCase().compareTo("y") == 0 || choose.compareTo("Y") == 0) {
                        System.out.println("Thanks for using our service !");
                        System.out.println("Trying to quit...");
                        for (int i = 0 ; i <= 100 ; i++) {
                            sb.setLength(0);
                            sb.append("#".repeat(i));
                            Thread.sleep(random.nextInt(100));
                            System.out.print("[" + String.format("%-100s", sb) + "] " +  i + "%");
                            System.out.print("\r");
                        }
                        System.out.println("Exit Successfully !");
                        System.exit(0);
                    }
                }
                default -> System.out.println("Invalid Choice !");
            }
        } while (choice >= 1 && choice <= 6);
    }
}