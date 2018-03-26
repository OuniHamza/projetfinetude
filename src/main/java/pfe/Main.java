package pfe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pfe.dao.repository.CandidatRepository;
import pfe.dao.repository.OffreRepository;
import pfe.dao.repository.RecruteurRepository;
import pfe.dao.repository.RoleRepository;


@SpringBootApplication
public class Main implements CommandLineRunner {

   @Autowired
   RecruteurRepository recruteurRepository;
   @Autowired
   RoleRepository roleRepository;
   @Autowired
   OffreRepository offreRepository;
   @Autowired
   CandidatRepository candidatRepository;


    public static void main(String[] args)  {
         SpringApplication.run(Main.class, args);

         }



   @Override
   public  void run(String... strings) throws Exception {

//        Recruteur recruteur = recruteurRepository.save(new Recruteur.Builder()
//              .nom("anis")
//              .prenom("bensalem")
//              .username("anis.bensalem")
//              .password("123")
//              .email("anis@gmail.com").active(true)
//              .Build());
//
//        Candidat candidat = candidatRepository.save(new Candidat.Builder()
//                .nom("haythem")
//                .prenom("chaabeen")
//                .username("haythem.chaabeen")
//                .password("tunis")
//                .email("haythem@gmail.com").active(true)
//                .Build());
//        Role role=roleRepository.save(new Role.Builder().roleName("ADMIN").Build());
//        Role role1=roleRepository.save(new Role.Builder().roleName("USER").Build());
//
//       Candidat candidat1 = candidatRepository.save(new Candidat.Builder()
//               .nom("salah")
//               .prenom("ouni")
//               .username("salah.ouni")
//               .password("sousse")
//               .email("salah@gmail.com").active(true)
//               .Build());
//        Offre offre=offreRepository.save(new Offre.Builder()
//                .description("creation d'un site web")
//                .titre("web")
//                .missions("platforme de recrutement")
//                .recruteur(recruteur)
//                .qualificationRequises("débutant")
//                .Build());
   }
}
