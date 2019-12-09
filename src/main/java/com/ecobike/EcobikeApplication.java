package com.ecobike;

import com.ecobike.utils.impl.DrawUtilImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EcobikeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(EcobikeApplication.class, args);
        DrawUtilImpl drawUtil = ctx.getBean(DrawUtilImpl.class);

        drawUtil.readFile();
        drawUtil.drawMenu();
    }
}
