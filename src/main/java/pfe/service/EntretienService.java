package pfe.service;


import pfe.dao.entity.Entretien;

import java.util.List;

public interface EntretienService {

    Entretien creerEntretien(Entretien entretien);
    void supprimerEntretien(Long id);
    Entretien modifierEntretien(Entretien entretien);
    Entretien findEntretienById(Long id);
    boolean isEntretienExist(Entretien entretien);
    List<Entretien> findAllEntretiens();
}

