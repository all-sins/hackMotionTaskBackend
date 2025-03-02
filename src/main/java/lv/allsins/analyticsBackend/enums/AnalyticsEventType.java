package lv.allsins.analyticsBackend.enums;

import lombok.Getter;

@Getter
public enum AnalyticsEventType {
    PAGE_VIEW("Page View Event"),
    VIDEO_WATCH("Video Watch Event");

    private final String description;

    AnalyticsEventType(String description) {
        this.description = description;
    }
}
