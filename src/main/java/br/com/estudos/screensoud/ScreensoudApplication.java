package br.com.estudos.screensoud;

import br.com.estudos.screensoud.principal.Principal;
import br.com.estudos.screensoud.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoudApplication implements CommandLineRunner {

    @Autowired
    private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoudApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal(repository);
        principal.exibeMenu();
    }
}


