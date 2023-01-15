import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your name, password, balance to create an account");

        //create user
        String name = sc.nextLine();
        String password = sc.nextLine();
        double balance = sc.nextDouble();
        SBIUser user = new SBIUser(name,balance ,password);

        //add amount
        System.out.println("Amount you want to add");
        String message = user.addMoney(sc.nextInt());
        System.out.println(message);

        //withdraw money
        System.out.println("Enter amount you want to withdraw");
        int money = sc.nextInt();
        System.out.println("Enter Password");
        String pass = sc.nextLine();
        System.out.println(user.withdrawMoney(money,pass));

        //rate of interest
        System.out.println(user.calculateInterest(10));
    }
}
