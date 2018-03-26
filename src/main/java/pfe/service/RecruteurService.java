package pfe.service;


import pfe.dao.entity.Recruteur;
import pfe.dao.entity.User;

import java.util.List;

public interface RecruteurService {

    Recruteur saveRecruteur(Recruteur recruteur);
    boolean isRecruteurExist(User user);
    Recruteur findRecruteurByUsername(String username);
    Recruteur findRecruteurById(Long id);
    String updateRecruteur(Recruteur recruteur);
    void deleteRecruteur(Long id);
    List<Recruteur> listRecruteur();

}
