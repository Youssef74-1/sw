package EComm.SW.service;

import EComm.SW.entity.Role;
import EComm.SW.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}

