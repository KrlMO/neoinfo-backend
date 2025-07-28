package com.neoinfo.neoback;

import com.neoinfo.modulos.rrhh.entity.Persona;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.neoinfo")
@EntityScan({
    "com.neoinfo.modulos.rrhh.entity",
    "com.neoinfo.modulos.venta.entity",
    "com.neoinfo.modulos.gestioncurso.entity",
    "com.neoinfo.modulos.auth.entity"
})
@EnableJpaRepositories(basePackages = {
    "com.neoinfo.modulos.rrhh.repository",
    "com.neoinfo.modulos.venta.repository",
    "com.neoinfo.modulos.gestioncurso.repository",
    "com.neoinfo.modulos.auth.repository"
})
public class NeobackApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeobackApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(EntityManager em) {
        return args -> {
            System.out.println("🔍 Tablas encontradas en 'public':");
            List<String> tablas = em.createNativeQuery("SELECT tablename FROM pg_tables WHERE schemaname = 'public'").getResultList();
            tablas.forEach(System.out::println);
        };
    }

}
