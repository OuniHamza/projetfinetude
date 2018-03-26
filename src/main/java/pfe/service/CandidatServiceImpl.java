package pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pfe.dao.entity.Candidat;
import pfe.dao.entity.Role;
import pfe.dao.repository.CandidatRepository;
import pfe.dao.repository.RoleRepository;

import java.util.List;

@Service
public class CandidatServiceImpl implements CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Role role=roleRepository.findByRoleName(roleName);
        Candidat candidat=candidatRepository.findByUsername(username);
        candidat.setRole(role);

    }

    @Override
    public Candidat saveCandidat(Candidat candidat) {
        String hashPW=bCryptPasswordEncoder.encode(candidat.getPassword());
        candidat.setPassword(hashPW);
        return candidatRepository.save(candidat);

    }

    @Override
    public boolean isCandidatExist(Candidat candidat) {
        return false;
    }

    @Override
    public Candidat findCandidatByUsername(String username) {
        return candidatRepository.findByUsername(username);
    }


    @Override
    public Candidat findCandiadtById(Long id) {
        return candidatRepository.findOne(id);
    }

    @Override
    public Candidat updateCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);

    }

    @Override
    public void deleteCandidatById(Long id) {
        candidatRepository.delete(id);

    }

    @Override
    public List<Candidat> listCandidat() {
        return null;
    }
}
