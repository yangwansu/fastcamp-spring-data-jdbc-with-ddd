package org.masil;

import org.masil.intrarastures.jdbc.Converts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@SpringBootApplication
@EnableAsync
public class App {

    @Configuration
    public static class DataJdbcConfig extends AbstractJdbcConfiguration {
        @Bean
        @Override
        public JdbcCustomConversions jdbcCustomConversions() {
            return new JdbcCustomConversions(
                    Arrays.asList(
                            Converts.LectureIdToLong.INSTANCE,
                            Converts.LongToLectureId.INSTANCE,
                            Converts.TermIdToLong.INSTANCE,
                            Converts.LongToTermId.INSTANCE,
                            Converts.StudentIdToLong.INSTANCE,
                            Converts.LongToStudentId.INSTANCE
                            ));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
