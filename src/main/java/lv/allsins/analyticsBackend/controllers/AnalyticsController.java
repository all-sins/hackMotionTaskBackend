package lv.allsins.analyticsBackend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lv.allsins.analyticsBackend.models.AnalyticsEvent;
import lv.allsins.analyticsBackend.services.AnalyticsService;
import lv.allsins.analyticsBackend.utility.IpExtractor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    private final AnalyticsService analyticsService;
    private final IpExtractor ipExtractor;
    private static final Logger logger = LoggerFactory.getLogger(AnalyticsController.class);

    public AnalyticsController(AnalyticsService analyticsService, IpExtractor ipExtractor) {
        this.analyticsService = analyticsService;
        this.ipExtractor = ipExtractor;
    }

    @PostMapping("/events/page-view")
    public ResponseEntity<String> logPageView(@RequestBody AnalyticsEvent event, HttpServletRequest request) {
        try {
            event.setIpAddress(ipExtractor.getClientIp(request, event.getIpAddress()));
            analyticsService.saveEvent(event);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("Page View event logged successfully.");
    }

    @PostMapping("/events/video-view")
    public ResponseEntity<String> logVideoView(@RequestBody AnalyticsEvent event, HttpServletRequest request) {
        try {
            event.setIpAddress(ipExtractor.getClientIp(request, event.getIpAddress()));
            analyticsService.saveEvent(event);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("Video View event logged successfully.");
    }

    @DeleteMapping("/events/delete/{eventId}")
    public void deleteEvent(@PathVariable String eventId) {
        analyticsService.deleteEventById(eventId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AnalyticsEvent>> getEventsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(analyticsService.getEventsByUserId(userId));
    }

    @DeleteMapping("/user/delete/{userId}")
    public void deleteEventsByUserId(@PathVariable String userId) {
        analyticsService.deleteEventsByUserId(userId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnalyticsEvent>> getEventsByUser() {
        return ResponseEntity.ok(analyticsService.getAllEvents());
    }

    @GetMapping("/db/reset")
    public void clearDatabase() {
        analyticsService.clearDb();
    }
}
