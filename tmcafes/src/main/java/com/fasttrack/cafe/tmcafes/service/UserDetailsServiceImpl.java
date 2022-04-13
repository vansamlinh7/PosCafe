package com.fasttrack.cafe.tmcafes.service;

import com.fasttrack.cafe.tmcafes.model.CurrentUser;
import com.fasttrack.cafe.tmcafes.model.Users;
import com.fasttrack.cafe.tmcafes.repository.UserRepository;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String USER_IS_DISABLED = "user is disable!!";
    // DI dependence injection
    //@autowired
    //setter
    //constructor
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //AUTHENTICATION
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUsername(username);
        //Ruby, kotlin
        //null pointer ex
        user.orElseThrow(() -> new UsernameNotFoundException("Could not find " + username));
        if (!user.get().isEnabled())
            throw new DisabledException(USER_IS_DISABLED);
        return new CurrentUser(user.get());
    }

}
