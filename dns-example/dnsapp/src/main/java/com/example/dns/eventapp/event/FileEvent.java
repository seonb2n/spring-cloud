package com.example.dns.eventapp.event;

import java.util.Map;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FileEvent {
    private String evendId;
    private String type;
    private Map<String, Object> data;

    public static FileEvent toCompleteEvent(Map data) {
        return FileEvent.builder()
        .evendId(UUID.randomUUID().toString())
        .type(EventType.COMPLETE.name())
        .data(data)
        .build();

    }

    public static FileEvent toErrorEvent(Map data) {
        return FileEvent.builder()
        .evendId(UUID.randomUUID().toString())
        .type(EventType.ERROR.name())
        .data(data)
        .build();
    }
}
