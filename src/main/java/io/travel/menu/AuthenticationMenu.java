package io.travel.menu;

import io.travel.authentication.AuthenticationService;
import io.travel.util.InputHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMenu implements IMenu {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public void show() {
        boolean authenticated = false;

        while (!authenticated) {
            System.out.println("Please enter your username:");
            String username = InputHandler.getStringInput();
            System.out.println("Please enter your password:");
            String password = InputHandler.getStringInput();
            authenticated = authenticationService.authenticate(username, password);
            if (authenticated) {
                System.out.println("You have successfully logged in with the username: " + username + "!\n");
            }
            else
            {
                System.out.println("Invalid username or password!\n");
            }
        }
    }

    @Override
    public void printOptions() {
        //Not needed. No options.
    }

   public void initialize() {
        authenticationService.initializeUser("Kwame Jackson", "kjackson", "password", "USD");
    }

}
