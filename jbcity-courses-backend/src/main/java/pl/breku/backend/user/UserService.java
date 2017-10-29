package pl.breku.backend.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.breku.backend.database.entity.User;
import pl.breku.backend.security.UserRepository;

import javax.transaction.Transactional;

/**
 * Created by breku on 29.10.17.
 */
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getCurrentUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String username = ((UserDetails) authentication.getPrincipal()).getUsername();
		return userRepository.findByUsername(username);
	}
}
