package io.travel;

import io.travel.menu.AuthenticationMenu;
import io.travel.menu.MainMenu;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootTravelPlannerCLIApplication implements CommandLineRunner {

    @Autowired
    private AuthenticationMenu authenticationMenu;
    @Autowired
    private MainMenu mainMenu;

    static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootTravelPlannerCLIApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    public void run(String @NonNull ... args) {
        System.out.println("==========================================================");
        System.out.println("        Welcome To The Travel Planner Application!");
        System.out.println("==========================================================");
        System.out.println();

        authenticationMenu.show();
        mainMenu.show();

        System.out.println();
        System.out.println("GOODBYE!");
    }
}
