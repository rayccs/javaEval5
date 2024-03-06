import org.springframework.stereotype.Service;

@Service
public class Service {

    private final Repository usuarioRepository;
    private final TokenService tokenService;

    public Service(Repository usuarioRepository, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    public Response registrarUsuario(Request usuarioRequest) {
        if (usuarioRepository.existsByEmail(usuarioRequest.getEmail())) {
            throw new UsuarioException(HttpStatus.BAD_REQUEST, "El correo ya registrado");
        }
        String token = tokenService.generateToken();
        Response usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setCreated(usuario.getCreated());
        usuarioResponse.setModified(usuario.getModified());
        usuarioResponse.setLastLogin(usuario.getLastLogin());
        usuarioResponse.setToken(token);
        usuarioResponse.setIsActive(usuario.getIsActive());

        return usuarioResponse;
    }
}
