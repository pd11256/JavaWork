package com.lec.spring.config04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lec.beans.Score;

@Configuration
@ImportResource("classpath:appCtx04.xml") //xml설정을 Java 설정안에 가져오기
public class AppConfig04 {

	@Bean
	public Score score2() {
		return new Score(80,40,60, "나빠요");
	}
	
	@Bean
	public Score score1() {
		return new Score(30,42,60, "만만점");
	}
}
