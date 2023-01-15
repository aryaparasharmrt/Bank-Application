import java.util.Objects;
import java.util.UUID;

public class SBIUser implements  BankIntereface{
    private String name;
    private  String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public SBIUser(String name, double balance, String password){
        this.name = name;
        this.balance = balance;
        this.password = password;

        //Bank will provide them
        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
        System.out.println("Your Account has Been Successfully created");
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance += amount;
        return amount +" has been successfully credited in your account. Your total Balance is "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {

       if(Objects.equals(enteredPassword,password)){
           if(amount > balance){
               return "Insufficient Balance";
           }else {
               balance -= amount;
               return amount +" has been Debited from your account. Available Balance "+ balance;
           }
       }
       return "Wrong Password!!";
    }

    @Override
    public double calculateInterest(int years) {
        return rateOfInterest * years * balance;
    }
}
