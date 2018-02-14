package practica3.exception;

import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Without Access")
public class CustomExceptionGenerator extends RuntimeException{
    private HttpStatus status;

    public CustomExceptionGenerator(HttpStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return status.toString();
    }

    public void setErrorMessage(HttpStatus status) {
        this.status = status;
    }
}
