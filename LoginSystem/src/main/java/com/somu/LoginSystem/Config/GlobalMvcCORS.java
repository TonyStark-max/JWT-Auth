package com.somu.LoginSystem.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class GlobalMvcCORS {
   public void addCorsMappings(CorsRegistry registry){
       registry.addMapping("/**")
               .allowedOrigins("http://localhost:63343")
               .allowedMethods("GET,POST")
               .allowedHeaders("*");
   }
}
