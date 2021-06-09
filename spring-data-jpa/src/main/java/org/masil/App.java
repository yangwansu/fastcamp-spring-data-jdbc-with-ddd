package org.masil;

import org.masil.domains.term.Term;
import org.masil.domains.term.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {


    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(App.class);

        TermRepository termRepository = app.getBean(TermRepository.class);

        Term term = Term.of("1학기");
        termRepository.save(term);




    }
}
