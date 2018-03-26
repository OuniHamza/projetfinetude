package pfe.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.dao.entity.Recruteur;


public interface RecruteurRepository extends JpaRepository<Recruteur,Long> {

    Recruteur findByUsername(String username);
}
