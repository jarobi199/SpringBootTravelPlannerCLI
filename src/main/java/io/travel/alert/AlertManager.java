package io.travel.alert;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlertManager {
    private final List<AlertStrategy> strategies;

    public AlertManager(List<AlertStrategy> strategies) {
        this.strategies = strategies;
    }

    public List<String> evaluate(AlertContext context) {
        return strategies.stream()
                .filter(s -> s.supports(context))
                .map(s -> s.evaluate(context))
                .collect(Collectors.toList());
    }
}

