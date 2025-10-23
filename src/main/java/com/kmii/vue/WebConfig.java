package com.kmii.vue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() { //CORS 문제 해결 8081포트에서 모든 요청 개방 
		 return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8081")
						.allowedMethods("GET","POST","PUT","DELETE") ;
//						.allowCredentials(true);//로그인 인증 필요 -> true 설정 필요
					}
			 
		};
	}

}
