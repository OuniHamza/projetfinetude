package pfe.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.dao.entity.Offre;
import pfe.dao.repository.OffreRepository;
import pfe.service.OffreService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OffreResource {
    public static final Logger logger = LoggerFactory.getLogger(OffreResource.class);

    @Autowired
    OffreService offreService;
    @Autowired
    OffreRepository offreRepository;

    // -------------------Create  offre-------------------------------------------

    @RequestMapping(value = "/offre", method = RequestMethod.POST)
    public Offre creerOffre(@RequestBody Offre offre) {
        logger.info(" [Controller] Creating User : {}", offre);
        if (offreService.isOffreExist(offre)) {
            logger.error("Unable to create. An offre with Login {} already exist", offre.getId());
            return null;
        }
        return offreService.creerOffre(offre);

    }

    //------------------- delete offre------------------------------------------
  //  @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/offre/{id}", method = RequestMethod.DELETE)
    public String deleteOffre(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id {}", id);
        Offre offre = offreService.findOffreById(id);
        if (offre == null) {
            logger.error("Unable to delete. Offre with id {} not found.", id);
            return "offre n'xiste pas";
        }
        offreService.supprimerOffre(id);
        return "offre deleted";
    }

    //------------------- consulter tous les offres ----------------------------

   // @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/offres", method = RequestMethod.GET)
    public List<Offre> consulterOffres() {
        logger.info("Fetching all offers");
        List<Offre> offres = offreService.findALLoffres();
        if (offres == null) {
            logger.error("there is no offer");
            return null;
        }
        return offres;
    }

    //----------------- trouver un offre par son id -------------------------

    @RequestMapping(value = "/offre/{id}", method = RequestMethod.GET)
    public Offre getOffre(@PathVariable("id") long id) {
        logger.info("Fetching offre with id {}", id);
        Offre offre = offreService.findOffreById(id);
        if (offre == null) {
            logger.error("Offre with id {} not found.", id);
            return null;
        }
        return offre;
    }

    //----------------- update offre ---------------------------------------
   // @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/offre/{id}", method = RequestMethod.PUT)
    public Offre updateOffre(@RequestBody Offre offre, @PathVariable("id") long id) {
        logger.info(" [Controller]  Updating Offre with id {}", id);

        Offre currentOffre = offreService.findOffreById(id);
        if (currentOffre  == null) {
            logger.error("Unable to update. offre with id {} not found.", id);
            return null;
        }
     return (offreRepository.save(offre ));


    }
}