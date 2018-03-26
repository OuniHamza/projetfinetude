package pfe.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pfe.dao.entity.Offre;
import pfe.dao.entity.Recruteur;
import pfe.service.OffreService;
import pfe.service.RecruteurService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class RecruteurResource {
    public static final Logger logger = LoggerFactory.getLogger(CandidatResource.class);

    @Autowired
    RecruteurService recruteurService;
    @Autowired
    OffreService offreService;

    @Value("${dir.images}")
    private String fileDirectory;
    @RequestMapping(value ="/recruteur", method = RequestMethod.POST)
    public String saveRecruteur(@RequestBody Recruteur recruteur) throws IOException {
        logger.info(" [Controller] Creating recruteur : {}", recruteur);
//        if (candidatService.isCandidatExist(candidat)) {
//            logger.error("Unable to create. A User with Login {} already exist", candidat.getLogin());
//            return null;
//        }
//         if (!(photo.isEmpty())&& !(cv.isEmpty())) {
//               candidat.setPhoto(photo.getOriginalFilename());
//               candidat.setCv(cv.getOriginalFilename());
//               }
//        candidatService.saveCandidat(candidat);
//            if (!(photo.isEmpty())&& !(cv.isEmpty()) ){
//                candidat.setPhoto(photo.getOriginalFilename());
//                photo.transferTo(new File(System.getProperty(fileDirectory+photo.getOriginalFilename())));
//                candidat.setCv(cv.getOriginalFilename());
//                cv.transferTo(new File(System.getProperty(fileDirectory+cv.getOriginalFilename())));
//        }
        recruteurService.saveRecruteur(recruteur);
        return "compte crée";
    }

    @RequestMapping(value = "/recruteur/{id}", method = RequestMethod.GET)
    public String getRecruteur(@PathVariable("id") Long id) {
        logger.info("Fetching recruteur with id {}", id);
        Recruteur recruteur = recruteurService.findRecruteurById(id);
        if (recruteur == null) {
            logger.error("recruteur with id {} not found.", id);
            return "no recruteur";
        }
        return "recruteur";
    }
    @RequestMapping(value = "/recruteur", method = RequestMethod.PUT)
    public String updateCandidat(@RequestParam("id") long id, @RequestBody Recruteur recruteur) {
        logger.info(" [Controller]  Updating recruteur with id {}", id);

        Recruteur currentRecruteur = recruteurService.findRecruteurById(id);
        if (currentRecruteur == null) {
            logger.error("Unable to update. Recruteur with id {} not found.", id);
            return "compte n'existe pas";
        }
        recruteurService.updateRecruteur(recruteur);

        return "compte modifié avec success";

    }
    @RequestMapping(value = "/recruteur/{id}",method = RequestMethod.DELETE)
    public String deleteCandidat(@PathVariable("id") Long id){
        logger.info(" [Controller]  deleting recruteur with id {}", id);
        Recruteur recruteur=recruteurService.findRecruteurById(id);
        if(recruteur==null){
            logger.error("Unable to delete. recruteur with id {} not found.", id);
            return "recruteur n'existe pas";
        }
        recruteurService.deleteRecruteur(id);
        return "compte deleted";
    }
   // @RequestMapping(value = "/offre", method = RequestMethod.POST)
    public String creerOffre(@RequestBody Offre offre) {
        logger.info(" [Controller] Creating User : {}", offre);
        if (offreService.isOffreExist(offre)) {
            logger.error("Unable to create. An offre with Login {} already exist", offre.getId());
            return "offre  deja existe";
        }
        offreService.creerOffre(offre);
        return "offre cree";
    }



}
