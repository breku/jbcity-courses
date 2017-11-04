package pl.breku.backend.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.breku.backend.database.entity.Role;
import pl.breku.backend.database.entity.User;

import java.util.Collections;

/**
 * Created by breku on 04.11.17.
 */
@Service
@Slf4j
public class RegisterService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public boolean registerUser(User newUser) {
		final User user = userRepository.findByUsername(newUser.getUsername());
		if (user == null) {
			log.info("Registering user={}", newUser.getUsername());
			final String password = passwordEncoder.encode(newUser.getPassword());
			newUser.setPassword(password);
			newUser.setRoles(Collections.singletonList(Role.builder().type(RoleType.ROLE_USER).build()));
			userRepository.save(newUser);
			return true;
		} else {
			log.info("User with that username={} already exists.", newUser.getUsername());
			return false;
		}

	}
}
