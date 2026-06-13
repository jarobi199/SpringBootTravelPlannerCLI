package io.travel.alert;

public interface AlertStrategy {
    boolean supports(AlertContext context);
    String evaluate(AlertContext context);
}
