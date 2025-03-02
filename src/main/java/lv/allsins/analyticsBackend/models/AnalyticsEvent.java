package lv.allsins.analyticsBackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.allsins.analyticsBackend.enums.AnalyticsEventType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "analytics_events")
public class AnalyticsEvent {
    @Id
    private String eventId; // Event ID.
    private String userId; // User ID.
    private AnalyticsEventType eventType;  // "PAGE_VIEW" or "VIDEO_WATCH"
    private String url;
    private Date timestamp;
    private Map<String, Object> browserInfo;
    private Map<String, Object> deviceInfo;
    private String ipAddress;
}
