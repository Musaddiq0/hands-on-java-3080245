package bank;

import javax.security.auth.login.LoginException;

public class Aunthenticator {
  public static Customer login(String username, String password) throws LoginException{
    Customer customer = DataSource.getCustomer(username);
    if (customer ==null){
      throw new LoginException("invlaid username");
    }

    if(password.equals(customer.getPassword())){
      customer.setAuthenticator(true);
      return customer;
    }

    else throw new LoginException("invalid password");
  }

  public static void logout(Customer customer){
    customer.setAuthenticator(false);
  }

}
