package com.proyecto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

    public static void main(String[] args) {
        
       var codigo = new BCryptPasswordEncoder();

        System.out.println("axel (123): "+codigo.encode("123"));
        System.out.println("nicole (456): "+codigo.encode("456"));
        System.out.println("avril (789): "+codigo.encode("789"));
    }
    
}
