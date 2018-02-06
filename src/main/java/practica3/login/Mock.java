package practica3.login;

public class Mock implements AuthLogin {

    @Override
    public boolean validate(String username, String password) {
        if (username.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
