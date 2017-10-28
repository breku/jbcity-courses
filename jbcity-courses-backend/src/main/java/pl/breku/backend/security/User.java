package pl.breku.backend.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by breku on 28.10.17.
 */
@Data
@AllArgsConstructor
public class User {

	private String username;
	private String password;
	private long id;
	private List<Role> roles;
}
