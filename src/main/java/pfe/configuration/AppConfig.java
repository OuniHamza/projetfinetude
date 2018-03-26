package pfe.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pfe.service.*;


@Configuration
public class AppConfig {
//    @Bean
//    public RecruteurService recruteurService(){
//        return new RecruteurServiceImpl();
//    }
    @Bean
    public OffreService offreService(){
        return new OffreServiceImpl();
    }
    @Bean
    public EntretienService entretienService(){
        return new EntretienServiceImpl();
    }
    @Bean
    public CandidatService candidatService(){
        return new CandidatServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }


}
