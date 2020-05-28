package com.iheartradio.m3u8.data;

import java.math.BigInteger;
import java.util.List;

public interface StreamInfoBuilder {
    public StreamInfoBuilder withBandwidth(BigInteger bandwidth);

    public StreamInfoBuilder withAverageBandwidth(BigInteger averageBandwidth);

    public StreamInfoBuilder withCodecs(List<String> codecs);

    public StreamInfoBuilder withResolution(Resolution resolution);

    public StreamInfoBuilder withFrameRate(float frameRate);

    public StreamInfoBuilder withVideo(String video);

    public StreamInfoBuilder withVideoRange(VideoRangeType videoRange);

}
