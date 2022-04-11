package com.example.auctions_web.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserDetailService  implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        return fakeUserDetailDao
//                .selectUserDetailByUsername(username)
//                /*.orElseThrow(() ->
//                        new UsernameNotFoundException(String.format("Username %s not found", username))
//                )*/;
        return new org.springframework.security.core.userdetails.User(
                "m@m.com",
                "asdfgh",
                true,
                true,
                true,
                true,
                Collections.singletonList(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_ADMIN";
                    }
                })

        );
    }

}
