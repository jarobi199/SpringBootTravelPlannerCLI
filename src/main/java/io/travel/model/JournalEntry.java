package io.travel.model;

import io.travel.enums.Mood;

import java.time.LocalDateTime;
import java.util.List;

public record JournalEntry(String title, String body, LocalDateTime date, Mood mood, List<String> highlights, int rating) {}


