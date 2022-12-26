package Login;

import java.util.HashMap;

public class IDPass {
  private HashMap<String, String> loginInfo = new HashMap<String, String>();

  public IDPass() {
    loginInfo.put("Admin", "Admin");
  }

  public HashMap<String, String> getLoginInfo() {
    return this.loginInfo;
  }
}
