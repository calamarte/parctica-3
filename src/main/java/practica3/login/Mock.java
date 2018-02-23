package practica3.login;

import org.springframework.stereotype.Component;


public class Mock implements AuthLogin {

    @Override
    public boolean validate(String username, String password) {
        return username.equals(password);
    }
}
