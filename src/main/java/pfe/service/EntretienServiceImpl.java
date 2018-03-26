package pfe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.dao.entity.Entretien;
import pfe.dao.repository.EntretienRepository;

import java.util.List;


@Service
public class EntretienServiceImpl implements EntretienService {

    @Autowired
    EntretienRepository entretienRepository;
    @Override
    public Entretien creerEntretien(Entretien entretien) {
        return entretienRepository.save(entretien);
    }

    @Override
    public void supprimerEntretien(Long id) {

        entretienRepository.delete(id);
    }

    @Override
    public Entretien modifierEntretien(Entretien entretien) {

        return creerEntretien(entretien) ;
    }

    @Override
    public Entretien findEntretienById(Long id) {
        return entretienRepository.findOne(id);
    }



    @Override
    public boolean isEntretienExist(Entretien entretien) {
        return findEntretienById(entretien.getId()) != null;
    }

    @Override
    public List<Entretien> findAllEntretiens() {
        return entretienRepository.findAll();
    }
}
