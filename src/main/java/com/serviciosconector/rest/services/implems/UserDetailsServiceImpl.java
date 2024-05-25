package com.serviciosconector.rest.services.implems;

import com.serviciosconector.rest.models.dao.ClientDao;
import com.serviciosconector.rest.models.entity.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowire
    private ClientDao clientDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client client = clientDao.findClientByClient_name(username)
                .orElseThrow(() -> new UsernameNotFoundException("el usuario "  +  username + " no existe"));

        Collection<? extends GrantedAuthority> authorities = client.getRoles().stream().map(
                role -> new SimpleGrantedAuthority("ROLE".concat(role.getName().name())))
                .collect(Collectors.toSet());
        return new User(client.getClient_name(),
                client.getPass(),
                true,
                true,
                true,
                true,
                authorities );
    }
}
