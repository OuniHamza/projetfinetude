package pfe.service;

import pfe.dao.entity.Candidat;
import pfe.dao.entity.Role;

import java.util.List;

public interface CandidatService {

        Role saveRole(Role role);
        void addRoleToUser(String username, String roleName);
        Candidat saveCandidat(Candidat candidat);
        boolean isCandidatExist(Candidat candidat);
        Candidat findCandidatByUsername(String username);
        Candidat findCandiadtById(Long id);
        Candidat updateCandidat(Candidat candidat);
        void deleteCandidatById(Long id);
        List<Candidat> listCandidat();


}
