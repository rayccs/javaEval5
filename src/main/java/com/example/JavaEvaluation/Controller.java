import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class Controller {

    private final Service Service;

    public Controller(Service Service) {
        this.Service = Service;
    }       

    @PostMapping("/registro")
    public ResponseEntity<Object> registrarUsuario(@RequestBody Request usuarioRequest) {
        try {
            Response Response = Service.registrarUsuario(usuarioRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(Response);
        } catch (Exception e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }
}
