package pl.breku.backend.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.breku.backend.database.entity.Role;
import pl.breku.backend.database.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by basakpie on 2017. 5. 11..
 */
public class SecurityUserDetails extends User implements UserDetails {


	private static final long serialVersionUID = -9191461920134961474L;

	public SecurityUserDetails(String username, String password, long id, List<Role> roles) {
		super(id, username, password ,roles);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : super.getRoles()) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getType().name());
			authorities.add(authority);
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
