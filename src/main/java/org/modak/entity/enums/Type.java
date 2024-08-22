package org.modak.entity.enums;

import java.time.Duration;
import java.time.Instant;

public enum Type {
    NEWS(1, Duration.ofDays(1)),
    MARKETING(3, Duration.ofHours(1));

    private final int limit;
    private final Duration duration;

    Type(int limit, Duration duration){
        this.limit = limit;
        this.duration = duration;
    }

    public int getLimit() {
        return limit;
    }

    public Duration getDuration() {
        return duration;
    }

}
