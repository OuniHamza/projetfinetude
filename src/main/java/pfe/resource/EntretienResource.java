package pfe.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.dao.entity.Entretien;
import pfe.service.EntretienService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntretienResource {

    @Autowired
    EntretienService entretienService;
//    @Autowired
//    EntretienRepository entretienRepository;


    public static final Logger logger = LoggerFactory.getLogger(OffreResource.class);



    // -------------------Create  ENTRETIEN-------------------------------------------

    @RequestMapping(value = "/entretein", method = RequestMethod.POST)
    public Entretien creerEntretein(@RequestBody Entretien entretein) {
        logger.info(" [Controller] Creating Eentretein : {}", entretein);
        entretienService.creerEntretien(entretein);
        return entretein;
    }

    //------------------- delete ENTRETIEN------------------------------------------

    @RequestMapping(value = "/entretien/{id}", method = RequestMethod.DELETE)
    public String supprimerEntretien(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting entretien with id {}", id);
       Entretien entretien = entretienService.findEntretienById(id);
        if (entretien == null) {
            logger.error("Unable to delete. entretien with id {} not found.", id);
            return "no entretien wth this id";
        }
        entretienService.supprimerEntretien(id);
        return "entretien effacé";
    }

    //------------------- consulter tous les entretiens----------------------------


    @RequestMapping(value = "/entretiens", method = RequestMethod.GET)
    public List<Entretien> listEntretiens() {
        logger.info("Fetching all entretiens");
        List<Entretien> entretiens = entretienService.findAllEntretiens();
        if (entretiens == null) {
            logger.error("there is no entretiens");
            return null;
        }
        return entretiens;
    }

    //----------------- trouver un entretien par son id -------------------------

    @RequestMapping(value = "/entretien/{id}", method = RequestMethod.GET)
    public Entretien getEntretien(@PathVariable("id") long id) {
        logger.info("Fetching entretien with id {}", id);
        Entretien entretien = entretienService.findEntretienById(id);
        if (entretien == null) {
            logger.error("entretien with id {} not found.", id);
            return null;
        }
        return entretien;
    }

    //----------------- update entretien ---------------------------------------

    @RequestMapping(value = "/entretien/{id}", method = RequestMethod.PUT)
    public Entretien updateEntretien(@PathVariable("id") long id, @RequestBody Entretien entretien) {
        logger.info(" [Controller]  Updating entretien with id {}", id);

        Entretien currentEntretien= entretienService.findEntretienById(id);
        if (currentEntretien  == null) {
            logger.error("Unable to update. entretien with id {} not found.", id);
            return null;
        }
           entretienService.modifierEntretien(currentEntretien );
        return entretien;

    }

}
