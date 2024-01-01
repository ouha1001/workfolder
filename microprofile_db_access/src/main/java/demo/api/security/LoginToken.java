package demo.api.security;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginToken implements Serializable
{
   public String token;
   
   public LoginToken(String token)
   {
      this.token = token;
   }
   
   public LoginToken()
   {
      
   }
}
