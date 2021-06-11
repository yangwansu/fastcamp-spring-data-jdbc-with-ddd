package org.masil;

import org.masil.infrastructure.repositories.DataJdbcLectureRepository;
import org.masil.infrastructure.repositories.DataJdbcTermRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@EnableAsync
@SpringBootApplication
public class App {

    @Configuration
    public static class DataJdbcConfig extends AbstractJdbcConfiguration {
        @Override
        public JdbcCustomConversions jdbcCustomConversions() {
            return new JdbcCustomConversions(Arrays.asList(
                    DataJdbcTermRepository.LongToTermId.INSTANCE, DataJdbcTermRepository.TermIdToLong.INSTANCE,
                    DataJdbcLectureRepository.LongToLectureId.INSTANCE, DataJdbcLectureRepository.LectureIdToLong.INSTANCE
                    ));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
