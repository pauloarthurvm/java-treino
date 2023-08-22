package br.com.coruja.application;


import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(AlunoRepository repository) {
        return args -> {
            System.out.println("Preloading " + repository.save(
                    new Aluno("Bilbo Baggins", "burglar@google.com")));
            System.out.println("Preloading " + repository.save(
                    new Aluno("Frodo Baggins", "thief@outlook.com")));
        };
    }
}
