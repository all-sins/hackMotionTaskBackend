#!/bin/bash
curl -X POST http://localhost:8080/api/analytics/events/page-view \
     -H "Content-Type: application/json" \
     -d '{
           "userId": "sample-user-id",
           "eventType": "PAGE_VIEW",
           "url": "http://example.com",
           "timestamp": "2025-03-02T12:31:30.227+02:00",
           "browserInfo": {
               "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36",
               "language": "en-US"
           },
           "deviceInfo": {
               "width": 1280,
               "height": 720,
               "platform": "Win32"
           },
           "ipAddress": "AUTO"
         }'
