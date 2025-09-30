package br.com.estudos.screensoud;

import br.com.estudos.screensoud.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreensoudApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal();
        principal.exibeMenu();
    }
}


