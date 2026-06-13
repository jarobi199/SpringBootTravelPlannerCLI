package io.travel.model;

import io.travel.enums.ItemType;

import java.util.Map;

public record BudgetSummary(int estimatedTotal, int actualCost, int remaining, Map<ItemType, Integer> categoryBreakdown){}
