import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
