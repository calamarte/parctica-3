package practica3.login;

public interface AuthLogin {
    boolean validate(String username, String password);
    boolean checkSession();
}

