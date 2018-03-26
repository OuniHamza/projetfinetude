package pfe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.dao.entity.Recruteur;
import pfe.dao.entity.User;
import pfe.dao.repository.CandidatRepository;
import pfe.dao.repository.RecruteurRepository;

import java.util.List;

@Service
public class RecruteurServiceImpl implements RecruteurService {


    @Autowired
    RecruteurRepository recruteurRepository;
    @Autowired
    CandidatRepository candidatRepository;
    @Override
    public Recruteur saveRecruteur(Recruteur recruteur) {
        return recruteurRepository.save(recruteur);

    }

    public boolean isRecruteurExist(User user) {
        return findRecruteurByUsername(user.getUsername()) != null;
    }


    public Recruteur findRecruteurByUsername(String username) {
        return recruteurRepository.findByUsername(username);
    }

    public Recruteur findRecruteurById(Long id) {
        return recruteurRepository.findOne(id);
    }

    public String updateRecruteur(Recruteur recruteur) {
        saveRecruteur(recruteur);
        return "user modified";
    }

    @Override
    public void deleteRecruteur(Long id) {
        recruteurRepository.delete(id);
    }

    @Override
    public List<Recruteur> listRecruteur(){
        return recruteurRepository.findAll();
    }


}
