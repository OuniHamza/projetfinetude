package pfe.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.dao.entity.Role;


public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);

}
