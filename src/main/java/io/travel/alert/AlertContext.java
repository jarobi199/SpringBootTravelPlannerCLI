package io.travel.alert;

import io.travel.model.BudgetSummary;
import io.travel.model.Trip;

public record AlertContext (Trip trip, BudgetSummary budgetSummary) {}