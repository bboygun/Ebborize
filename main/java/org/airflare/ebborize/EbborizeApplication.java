package org.airflare.ebborize;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("org.airflare.ebborize.mapper")
public class EbborizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbborizeApplication.class, args);
    }

}
