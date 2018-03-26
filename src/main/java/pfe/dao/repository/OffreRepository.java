package pfe.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.dao.entity.Offre;


public interface OffreRepository extends JpaRepository<Offre, Long> {

  Offre findByTitle(String title);
}
