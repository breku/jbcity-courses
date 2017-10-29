package pl.breku.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.breku.backend.database.entity.Role;
import pl.breku.backend.database.entity.User;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username Not Found Exception : " + username);
		}
		return new SecurityUserDetails(user.getUsername(), user.getPassword(), user.getId(), user.getRoles());
	}

	@PostConstruct
	public void init() {
		final String password = passwordEncoder.encode("q1w2e3r4");
		final User u1 = User.builder().username("breku").password(password).roles(Arrays.asList(Role.builder().type(RoleType.ROLE_ADMIN).build(), Role.builder().type(RoleType.ROLE_USER).build())).build();
		final User u2 = User.builder().username("jacek").password(password).roles(Arrays.asList(Role.builder().type(RoleType.ROLE_USER).build())).build();

		userRepository.save(u1);
		userRepository.save(u2);
	}

}
