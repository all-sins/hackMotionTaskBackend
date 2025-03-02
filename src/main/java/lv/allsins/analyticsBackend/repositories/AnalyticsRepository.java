package lv.allsins.analyticsBackend.repositories;

import lv.allsins.analyticsBackend.enums.AnalyticsEventType;
import lv.allsins.analyticsBackend.models.AnalyticsEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnalyticsRepository extends MongoRepository<AnalyticsEvent, String> {
    List<AnalyticsEvent> findByUserId(String userId);
    void deleteByUserId(String userId);
    List<AnalyticsEvent> findByEventType(AnalyticsEventType eventType);
    List<AnalyticsEvent> findByEventTypeAndTimestampBetween(AnalyticsEventType eventType, Date start, Date end);
}
