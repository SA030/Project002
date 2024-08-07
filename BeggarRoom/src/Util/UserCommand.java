package Util;

import java.util.LinkedList;
import vo.Account;
import vo.User;

public class UserCommand {
  LinkedList<User> userList = new LinkedList<User>();
  static LinkedList<Account> accountList;

  ///////////////////////////////////////////////////////////
  ///////////////////// private Instance ////////////////////
  ///////////////////////////////////////////////////////////
  private static UserCommand userCmd;

  // setup UserCommand Instance
  public static UserCommand getInstance() {

    if (userCmd == null) {
      userCmd = new UserCommand(accountList);
    }

    return userCmd;
  }// Method getInstance END

  // reset UserCommand Instance
  public static void freeInstance() {
    userCmd = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  /////////////////////// Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  public UserCommand(LinkedList<Account> setaccountList) {
    accountList = setaccountList;
  }



  ///////////////////////////////////////////////////////////
  ///////////////// public getter, setter ///////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////// ---------- ///////////////////////
  ////////////////////////// ------ /////////////////////////
  //////////////////////////// -- ///////////////////////////
  ///////////////////////////////////////////////////////////
  public LinkedList<User> getUserList() {
    return userList;
  }

  public void setUserList(LinkedList<User> userList) {
    this.userList = userList;
  }

  public static LinkedList<Account> getAccountList() {
    return accountList;
  }

  public static void setAccountList(LinkedList<Account> accountList) {
    UserCommand.accountList = accountList;
  }



}// Class UserCommand END
