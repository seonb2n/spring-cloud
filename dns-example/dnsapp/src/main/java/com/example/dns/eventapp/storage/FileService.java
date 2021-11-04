package com.example.dns.eventapp.storage;

import com.example.dns.eventapp.event.FileEvent;
import com.example.dns.eventapp.event.FileEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class FileService {
    @Autowired
    FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {
        try{
            log.info("file copy complete");
            log.info("file save complete");
            FileEvent.toCompleteEvent(data);

        } catch (Exception e) {
            log.error("file upload fail", e);
            FileEvent.toErrorEvent(data);
        }
    }
}
