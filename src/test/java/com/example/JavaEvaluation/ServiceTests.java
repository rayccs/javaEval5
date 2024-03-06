import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceTest {

    @Mock
    private Repository usuarioRepositoryMock;

    @Mock
    private TokenService tokenServiceMock;

    @InjectMocks
    private Service service;

    @Test
    public void testRegistrarUsuario_Success() {
        Request request = new Request();
        when(usuarioRepositoryMock.existsByEmail(request.getEmail())).thenReturn(false);
        when(tokenServiceMock.generateToken()).thenReturn("testToken");
        Response response = service.registrarUsuario(request);
        assertNotNull(response);
    }

    @Test
    public void testRegistrarUsuario_EmailExists() {
        Request request = new Request();
        when(usuarioRepositoryMock.existsByEmail(request.getEmail())).thenReturn(true);
        assertThrows(UsuarioException.class, () -> service.registrarUsuario(request));
    }
}
