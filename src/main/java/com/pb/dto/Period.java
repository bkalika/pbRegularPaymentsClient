package com.pb.dto;

/**
 * @author @bkalika
 */
public enum Period {
    MINUTE(1L),
    HOUR(60L),
    DAY(1440L);
    private final Long durationInMinute;

    Period(Long durationInMinute) {
        this.durationInMinute = durationInMinute;
    }

    public Long getDurationInMinute() {
        return durationInMinute;
    }
}
