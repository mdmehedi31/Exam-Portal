package com.exam.service.imple;


import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl /*implements UserDetailsService*/ {

  /*  @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =this.userRepository.findByUsername(username);

        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user Not Found");
        }
        return user;
    }*/
}
