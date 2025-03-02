package lv.allsins.analyticsBackend.utility;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IpExtractor {
    private static final Logger logger = LoggerFactory.getLogger(IpExtractor.class);

    public String getClientIp(HttpServletRequest request, String originalAddress) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if ( ipAddress == null || ipAddress.isEmpty() ) {
            ipAddress = request.getRemoteAddr();
        } else {
            ipAddress = ipAddress.split(",")[0];
        }
        logger.info("{} -> {}", originalAddress, ipAddress);
        return ipAddress;
    }
}
