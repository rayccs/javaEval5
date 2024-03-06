import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ControllerTest {

    @Mock
    private Service serviceMock;

    @InjectMocks
    private Controller controller;

    private Request request;

    @BeforeEach
    public void setUp() {
        request = new Request(); 
    }

    @Test
    public void testRegistrarUsuario_Success() {
        when(serviceMock.registrarUsuario(request)).thenReturn(new Response());

        ResponseEntity<Object> responseEntity = controller.registrarUsuario(request);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        verify(serviceMock, times(1)).registrarUsuario(request);
    }

    @Test
    public void testRegistrarUsuario_Exception() {
        when(serviceMock.registrarUsuario(request)).thenThrow(new Exception("Mensaje de error"));
                ResponseEntity<Object> responseEntity = controller.registrarUsuario(request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("{\"mensaje\": \"Mensaje de error\"}", responseEntity.getBody());
        verify(serviceMock, times(1)).registrarUsuario(request);
    }
}
