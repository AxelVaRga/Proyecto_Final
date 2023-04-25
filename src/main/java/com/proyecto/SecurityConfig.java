package com.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        
        http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/",
                        "/index/**",           
                        "/finnk/Productos/**",                    
                        "/finnk/New arrivals/**",
                        "/finnk/blogs/**",
                        "/finnk/informacion/**",
                        "/blogs/**",                      
                        "/informacion/guardar/**", 
                        "/Reclamos/guardar/**",
                        "/errores/**",
                        "/carrito/**",
                        "/css/**",
                        "/img/**",                   
                        "/cdnjs/**",
                  
                        "/webjars/**").permitAll()
                .requestMatchers(
                        "/informacion/eliminar/**",
                        "/productos/nuevo/**",
                        "/productos/eliminar/**",
                        "/productos/modificar/**",
                        "/productos/guardar/**",
                        
                        "/empleado/nuevo/**",
                        "/empleado/eliminar/**",
                        "/empleado/modificarB/**",
                        "/empleado/guardar/**",  
                        
                        "/proveedor/nuevo/**",
                        "/proveedor/eliminar/**",
                        "/proveedor/modifica/**",
                        "/proveedor/guardar/**", 
                       
                        "/tienda/nuevo/**",
                        "/tienda/eliminar/**",
                        "/tienda/modificar/**",
                        "/tienda/guardar/**",
                        "/reportes/**",     
                     
                 
                        "/Reclamos/eliminar/**")
                
              
                .hasRole("ADMIN")
                .requestMatchers(
                     
                        "/informacion/listado",                  
                        "/empleado/InventarioB",
                        "/empleado/modificaB",
                        "/proveedor/Inventario",
                        "/proveedor/modifica",
                        "/tienda/listado",
                        "/tienda/modifica",
                        "/productos/Inventario",
                        "/Reclamos/listado",
                        "/productos/modifica")
                .hasAnyRole("ADMIN")  
                .requestMatchers("/facturar/carrito")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/errores/403");
        return http.build();
    }
    
}
