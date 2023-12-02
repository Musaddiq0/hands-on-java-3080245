package bank;

public class Customer {
  private int id;
  private String name;
  private String username;
  private String password;
  private int accountID;
  private boolean authenticator;

  public Customer(int id, String name, String username, String password, int accountID) {
    setId(accountID);
    setName(name);
    setUsername(username);
    setPassword(password);
    setAccountID(accountID);
    setAuthenticator(false);

  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountID() {
    return this.accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  public boolean isAuthenticator() {
    return this.authenticator;
  }

  public void setAuthenticator(boolean authenticator) {
    this.authenticator = authenticator;
  }

}
