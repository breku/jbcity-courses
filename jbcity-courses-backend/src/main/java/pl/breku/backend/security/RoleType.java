package pl.breku.backend.security;


public enum RoleType {

    ROLE_ADMIN,
    ROLE_USER;

    public static RoleType findByType(String type) {
        for(RoleType role: values()) {
            if(role.name().equals(type)) {
                return role;
            }
        }
        return null;
    }
}
