package pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pfe.dao.entity.Candidat;
import pfe.dao.entity.Role;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CandidatService candidatService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Candidat user=candidatService.findCandidatByUsername(username);
        if(user==null) throw new UsernameNotFoundException(username);

        Collection<GrantedAuthority> authorities=new ArrayList<>();
        Role role=user.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));


        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
