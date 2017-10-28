package pl.breku.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by breku on 28.10.17.
 */
@Repository
public class UserRepository {

	private static List<User> users = new ArrayList<>();

	@Autowired
	private PasswordEncoder passwordEncoder;



	@PostConstruct
	public void init(){
		final String password = passwordEncoder.encode("q1w2e3r4");
		users.add(new User("breku", password, 1L, Arrays.asList(new Role(1L, RoleType.ROLE_ADMIN), new Role(1L, RoleType.ROLE_USER))));
		users.add(new User("jacek", password, 2L, Arrays.asList(new Role(1L, RoleType.ROLE_USER))));
	}

	public User findByUsername(String username) {
		return users.stream().filter(x -> x.getUsername().equals(username)).findFirst().orElse(null);
	}
}
