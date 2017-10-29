package pl.breku.backend.security;

import org.springframework.data.repository.CrudRepository;
import pl.breku.backend.database.entity.User;

/**
 * Created by breku on 28.10.17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
