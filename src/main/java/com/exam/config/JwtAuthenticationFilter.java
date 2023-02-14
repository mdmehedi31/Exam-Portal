package com.exam.config;


import com.exam.service.imple.UserDetailsServiceImple;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.jar.JarOutputStream;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter implements Filter {

    @Autowired
    private UserDetailsServiceImple userDetailsServiceImple;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

         final String requestTokenHeader=request.getHeader("Authorization");

        System.out.println(requestTokenHeader);
        String username=null;
        String jwtToken=null;

        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")){


           try{
               jwtToken=requestTokenHeader.substring(7);
               username=  this.jwtUtils.extractUsername(jwtToken);
           }catch (ExpiredJwtException e){
               e.printStackTrace();
               System.out.println("jwt token has expired");
           }catch (Exception e){
               e.printStackTrace();
               System.out.println("error");
           }

        }
        else {
            System.out.println("Invalid Token, not start with bearer");
        }

        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            final UserDetails userDetails =this.userDetailsServiceImple.loadUserByUsername(username);

            if(this.jwtUtils.validateToken(jwtToken,userDetails)){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));


                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        else{
            System.out.println("Token is not valid");
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws javax.servlet.ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, javax.servlet.FilterChain filterChain) throws IOException, javax.servlet.ServletException {

    }
}
