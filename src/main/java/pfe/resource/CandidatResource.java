package pfe.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pfe.dao.entity.Candidat;
import pfe.service.CandidatService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CandidatResource {
    public static final Logger logger = LoggerFactory.getLogger(CandidatResource.class);

    @Autowired
    CandidatService candidatService;


    @Value("${dir.images}")
    private String fileDirectory;
    @RequestMapping(value ="/candidat", method = RequestMethod.POST)
    public Candidat saveCandidat(@RequestBody Candidat candidat) throws IOException {
  //  public Candidat saveCandidat(@RequestBody RegisterForm registerForm) throws IOException {
       // logger.info(" [Controller] Creating User : {}", candidat);
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
//        if(!registerForm.getPassword().equals(registerForm.getRepassword())){
//            throw  new RuntimeException("you must confirm your password");
//        }
//        Candidat candidat=candidatService.findCandidatByUsername(registerForm.getUsername());
//        if(candidat!=null){
//            throw  new RuntimeException("user already exist");
//            }

//        Candidat.Builder().nom(registerForm.getNom()).prenom(registerForm.getPrenom())
//                .email(registerForm.getEmail())
//                .cv(registerForm.getCv())
//                .photo(registerForm.getPhoto())
//                .username(registerForm.getUsername())
//                .password(registerForm.getPassword())
//                .Build();


//        candidat.setUsername(registerForm.getUsername());
//        candidat.setPassword(registerForm.getPassword());
//        candidat.setEmail(registerForm.getEmail());
//        candidat.setNom(registerForm.getNom());
//        candidat.setPrenom(registerForm.getPrenom());
        return candidatService.saveCandidat(candidat);
    }



    @RequestMapping(value = "/candidat/{id}", method = RequestMethod.GET)
    public Candidat getCandidat(@PathVariable("id") Long id) {
        logger.info("Fetching User with id {}", id);
        Candidat candidat = candidatService.findCandiadtById(id);
//        if (candidat == null) {
//            logger.error("User with id {} not found.", id);
//            return null;
//        }
        return candidat;
    }

    @RequestMapping(value = "/candidat", method = RequestMethod.PUT)
    public String updateCandidat(@RequestParam("id") long id, @RequestBody Candidat candidat) {
        logger.info(" [Controller]  Updating Candidat with id {}", id);

        Candidat currentCandidat = candidatService.findCandiadtById(id);
        if (currentCandidat == null) {
            logger.error("Unable to update. Candidat with id {} not found.", id);
            return "compte n'existe pas";
        }
        candidatService.updateCandidat(candidat);

        return "compte modifié avec success";

    }
    @RequestMapping(value = "/candidat/{id}",method = RequestMethod.DELETE)
    public String deleteCandidat(@PathVariable("id") Long id){
        logger.info(" [Controller]  deleting Candidat with id {}", id);
        Candidat candidat=candidatService.findCandiadtById(id);
        if(candidat==null){
            logger.error("Unable to delete. Candidat with id {} not found.", id);
            return "candidat n'existe pas";
        }
             candidatService.deleteCandidatById(id);
             return "compte deleted";
    }



//
//
}
