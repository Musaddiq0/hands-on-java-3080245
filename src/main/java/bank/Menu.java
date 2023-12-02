package bank;

import java.net.Authenticator;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exception.AmountException;

public class Menu {
  Scanner scanner; 
  public static void main(String[] args) {
    System.out.println("Welcome to the Global Bank!!!");

    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);
    Customer customer = menu.authenticateUser();
    if (customer!=null){
      Accounts accounts =DataSource.getAccount(customer.getAccountID());
      menu.showMenu(customer,accounts);
    }



    menu.scanner.close();
  }


private Customer authenticateUser(){
 System.out.println("Please enter your username");
 String username = scanner.next();

 System.out.println("Please enter your password");
 String password = scanner.next();
  Customer customer = null;
  try{
      customer = Aunthenticator.login(username, password);
  }catch(LoginException e ){
    System.out.println("there was an error" + e.getMessage());
  }
  return customer;
  
}
private void showMenu( Customer customer, Accounts accounts){
   int selection = 0 ; 
   while (selection!=4 && customer.isAuthenticator()) {
    System.out.println("=============================================");
    System.out.println("Please select one of the following options: ");
    System.out.println("1. Deposit");
    System.out.println("2. Withdraw");
    System.out.println("3. Check Balance");
    System.out.println("4. Exit");
    System.out.println("=============================================");

    selection = scanner.nextInt();
    double amount = 0;

    switch (selection) {
      case 1:
      System.out.println("please enter the amount to deposit ?");
      amount = scanner.nextDouble();
      try{
        accounts.deposit(amount);
        }catch(AmountException e){
          System.out.println(e.getMessage());
          System.out.println("Please try again");

        }
        break;

      case 2: 
      System.out.println("How much would you like to withdraw");
      amount = scanner.nextDouble();
      try {
        accounts.withdraw(amount);
      } catch (Exception e) {
        System.out.println( e.getMessage());
        System.out.println("invalid amount please try again");
      }
        break;
      case 3 : 
      System.out.println("Current balance " + accounts.getBalance());
        break;
      case 4 :
      Aunthenticator.logout(customer);
      System.out.println("Thanks for banking with Global International !");
        break;  

      default:
      System.out.println("This entry is invalid please try again thank you");
        break;
    }

    
   }

}

}

