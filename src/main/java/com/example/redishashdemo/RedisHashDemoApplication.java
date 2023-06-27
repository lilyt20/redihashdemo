package com.example.redishashdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisHashDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisHashDemoApplication.class, args);
	}


	@Bean
	JedisConnectionFactory jedisConnectionFactory(@Value("${spring.redis.host}") String redisHost, @Value("${spring.redis.port}") String redisPort) {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
		configuration.setHostName(redisHost);
		configuration.setPort(Integer.parseInt(redisPort));
		return new JedisConnectionFactory(configuration, JedisClientConfiguration.defaultConfiguration());
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory);
		return template;
	}
}
