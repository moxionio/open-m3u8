package com.iheartradio.m3u8.data;

import java.util.HashMap;
import java.util.Map;

public enum VideoRangeType {
    SDR("SDR"),
    PQ("PQ");

    private static final Map<String, VideoRangeType> sMap = new HashMap<String, VideoRangeType>();

    private final String value;

    static {
        for (VideoRangeType mediaType : VideoRangeType.values()) {
            sMap.put(mediaType.value, mediaType);
        }
    }

    private VideoRangeType(String value) {
        this.value = value;
    }

    public static VideoRangeType fromValue(String value) {
        return sMap.get(value);
    }
    
    public String getValue() {
        return value;
    }
}
