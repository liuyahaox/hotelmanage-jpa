package com.example.jpa.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class Myservice implements UserDetailsService {
    @Autowired
    Usermapper usermapper;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MUser user = usermapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("not found");
        } else {
            return new User(username, encoder.encode(user.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
        }
    }

}
