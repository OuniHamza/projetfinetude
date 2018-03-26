package pfe.service;


import pfe.dao.entity.Offre;

import java.util.List;

public interface OffreService {

    Offre creerOffre(Offre offre);
    void supprimerOffre(Long id);
    Offre modifierOffre(Offre offre);
    Offre findOffreById(Long id);
    Offre findOffreByTitre(String titre);
    boolean isOffreExist(Offre offre);
    List<Offre> findALLoffres();
}
