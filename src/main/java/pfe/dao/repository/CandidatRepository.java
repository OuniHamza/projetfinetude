package pfe.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.dao.entity.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat,Long> {
    Candidat findByUsername(String username);
}
