package pl.breku.backend.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by basakpie on 2017. 5. 11..
 */
@Data
@AllArgsConstructor
public class Role implements Serializable {


	private static final long serialVersionUID = -7569956409775155749L;

	private Long id;

	private RoleType type;

}
