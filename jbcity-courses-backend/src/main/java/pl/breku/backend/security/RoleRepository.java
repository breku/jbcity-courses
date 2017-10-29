package pl.breku.backend.security;

import org.springframework.data.repository.CrudRepository;
import pl.breku.backend.database.entity.Role;

/**
 * Created by breku on 29.10.17.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
