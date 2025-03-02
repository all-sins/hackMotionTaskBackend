package lv.allsins.analyticsBackend.services;

import lv.allsins.analyticsBackend.models.AnalyticsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import lv.allsins.analyticsBackend.repositories.AnalyticsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyticsService {
    private final AnalyticsRepository analyticsRepository;
    private static final Logger logger = LoggerFactory.getLogger(AnalyticsService.class);

    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public void saveEvent(AnalyticsEvent event) {
        logger.info("[Saving event]:{}", event.toString());
        analyticsRepository.save(event);
    }

    public AnalyticsEvent getEventByEventId(String eventId) {
        Optional<AnalyticsEvent> optional = analyticsRepository.findById(eventId);
        return optional.orElse(null);
    }

    public List<AnalyticsEvent> getAllEvents() {
        return analyticsRepository.findAll();
    }

    public List<AnalyticsEvent> getEventsByUserId(String userId) {
        return analyticsRepository.findByUserId(userId);
    }

    public void deleteEventById(String eventId) {
        analyticsRepository.deleteById(eventId);
    }

    public void deleteEventsByUserId(String userId) {
        analyticsRepository.deleteByUserId(userId);
    }

    public void clearDb() {
        analyticsRepository.deleteAll();
    }
}
