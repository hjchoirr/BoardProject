package org.choongang.my;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginForm {
    private String email;
    private String password;
}
