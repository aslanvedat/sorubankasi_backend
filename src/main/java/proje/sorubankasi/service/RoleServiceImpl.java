package proje.sorubankasi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proje.sorubankasi.entity.Role;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.RoleRepostory;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepostory repostory;

    @Override
    public Collection<Role> saveRoles(Collection<Role> roles) {

        if(roles == null || roles.isEmpty()){
            throw new ApiRequestException("Roles cannot be null or empty!");
        }
        return repostory.saveAll(roles);
    }

    @Override
    public boolean existByRoleName(String roleName) {
        return repostory.existsByName(roleName);
    }

    @Override
    public Role saveRole(Role role) {

        if(role == null || role.getName().isEmpty()){
            throw new ApiRequestException("Roles cannot be null and name cannot be empty!");
        }
        if(existByRoleName(role.getName())){
            throw new ApiRequestException("Role already exist!");
        }
        var result = repostory.save(role);
        repostory.flush();
        return result;
    }
}
