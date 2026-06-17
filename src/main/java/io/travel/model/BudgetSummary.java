package io.travel.model;

import java.util.List;

public record BudgetSummary(int estimatedTotal, int actualCost, int remaining, List<CategoryBreakdown> categoryBreakdowns) {}
