package me.dio.sdw24;



import me.dio.sdw24.application.ListChampionUseCase;
import me.dio.sdw24.domain.model.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	

	@Bean
	public ListChampionUseCase provideListChampionsUseCase(ChampionsRepository repository) {
		return new ListChampionUseCase(repository);
	}
}
