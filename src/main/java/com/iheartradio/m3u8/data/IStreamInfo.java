package com.iheartradio.m3u8.data;

import java.math.BigInteger;
import java.util.List;

public interface IStreamInfo {
    public BigInteger getBandwidth();

    boolean hasAverageBandwidth();

    BigInteger getAverageBandwidth();

    boolean hasCodecs();

    List<String> getCodecs();

    boolean hasResolution();

    Resolution getResolution();

    boolean hasFrameRate();

    float getFrameRate();

    boolean hasVideo();

    String getVideo();

    boolean hasVideoRange();

    VideoRangeType getVideoRange();
}
