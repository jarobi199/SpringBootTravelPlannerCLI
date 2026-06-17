package io.travel.model;

import io.travel.enums.ItemType;

public record  CategoryBreakdown(ItemType itemType, int estimatedCost, int actualCost) {}
