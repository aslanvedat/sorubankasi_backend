package proje.sorubankasi.service;


import proje.sorubankasi.entity.Role;

import java.util.Collection;

public interface RoleService {
    Collection<Role> saveRoles(Collection<Role> roles);

    boolean existByRoleName(String roleName);

    Role saveRole(Role role);
}
