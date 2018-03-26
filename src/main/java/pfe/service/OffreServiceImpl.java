package pfe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.dao.entity.Offre;
import pfe.dao.repository.OffreRepository;

import java.util.List;


@Service
public class OffreServiceImpl implements OffreService {
    @Autowired
    OffreRepository offreRepository;
    @Override
    public Offre creerOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public void supprimerOffre(Long id) {
        offreRepository.delete(id);
        }

    @Override
    public Offre modifierOffre(Offre offre) {
        return creerOffre(offre);
    }

    @Override
    public Offre findOffreById(Long id) {
        return offreRepository.findOne(id);
    }

    @Override
    public Offre findOffreByTitre(String titre) {
        return offreRepository.findByTitle(titre);
    }

    @Override
    public boolean isOffreExist(Offre offre) {
         return findOffreById(offre.getId()) != null;
    }

    @Override
    public List<Offre> findALLoffres() {
        return offreRepository.findAll();
    }
}
