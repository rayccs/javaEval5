import org.springframework.http.HttpStatus;

public class Exception extends RuntimeException {

    private HttpStatus status;

    public Exception(HttpStatus status, String mensaje) {
        super(mensaje);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
