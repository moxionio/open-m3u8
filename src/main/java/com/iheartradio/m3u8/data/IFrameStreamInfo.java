package com.iheartradio.m3u8.data;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class IFrameStreamInfo implements IStreamInfo {
    public static final BigInteger NO_BANDWIDTH = BigInteger.valueOf(-1);

    private final BigInteger mBandwidth;
    private final BigInteger mAverageBandwidth;
    private final List<String> mCodecs;
    private final Resolution mResolution;
    private final float mFrameRate;
    private final String mVideo;
    private final String mUri;
    private final VideoRangeType mVideoRange;


    private IFrameStreamInfo(
            BigInteger bandwidth,
            BigInteger averageBandwidth,
            List<String> codecs,
            Resolution resolution,
            float frameRate,
            String video,
            String uri,
            VideoRangeType videoRange) {
        mBandwidth = bandwidth;
        mAverageBandwidth = averageBandwidth;
        mCodecs = codecs;
        mResolution = resolution;
        mFrameRate = frameRate;
        mVideo = video;
        mUri = uri;
        mVideoRange = videoRange;
    }

    @Override
    public BigInteger getBandwidth() {
        return mBandwidth;
    }

    @Override
    public boolean hasAverageBandwidth() {
        return !mAverageBandwidth.equals(NO_BANDWIDTH);
    }

    @Override
    public BigInteger getAverageBandwidth() {
        return mAverageBandwidth;
    }

    @Override
    public boolean hasCodecs() {
        return mCodecs != null;
    }

    @Override
    public List<String> getCodecs() {
        return mCodecs;
    }

    @Override
    public boolean hasResolution() {
        return mResolution != null;
    }

    @Override
    public Resolution getResolution() {
        return mResolution;
    }

    @Override
    public boolean hasFrameRate() {
        return !Float.isNaN(mFrameRate);
    }

    @Override
    public float getFrameRate() {
        return mFrameRate;
    }

    @Override
    public boolean hasVideo() {
        return mVideo != null;
    }

    @Override
    public String getVideo() {
        return mVideo;
    }

    @Override
    public boolean hasVideoRange() {
        return mVideoRange != null;
    }

    @Override
    public VideoRangeType getVideoRange() {
        return mVideoRange;
    }

    public String getUri() {
        return mUri;
    }

    public Builder buildUpon() {
        return new Builder(
                mBandwidth,
                mAverageBandwidth,
                mCodecs,
                mResolution,
                mFrameRate,
                mVideo,
                mUri,
                mVideoRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mBandwidth,
                mAverageBandwidth,
                mCodecs,
                mResolution,
                mFrameRate,
                mVideo,
                mUri,
                mVideoRange);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IFrameStreamInfo)) {
            return false;
        }

        IFrameStreamInfo other = (IFrameStreamInfo) o;

        return mBandwidth.equals(other.mBandwidth) &&
               mAverageBandwidth.equals(other.mAverageBandwidth) &&
               Objects.equals(mCodecs, other.mCodecs) &&
               Objects.equals(mResolution, other.mResolution) &&
               Objects.equals(mFrameRate, other.mFrameRate) &&
               Objects.equals(mVideo, other.mVideo) &&
               Objects.equals(mUri, other.mUri) &&
               Objects.equals(mVideoRange, other.mVideoRange);
    }

    public static class Builder implements StreamInfoBuilder {
        private BigInteger mBandwidth = NO_BANDWIDTH;
        private BigInteger mAverageBandwidth = NO_BANDWIDTH;
        private List<String> mCodecs;
        private Resolution mResolution;
        private float mFrameRate = Float.NaN;
        private String mVideo;
        private String mUri;
        private VideoRangeType mVideoRange;

        public Builder() {
        }

        private Builder(
                BigInteger bandwidth,
                BigInteger averageBandwidth,
                List<String> codecs,
                Resolution resolution,
                float frameRate,
                String video,
                String uri,
                VideoRangeType videoRange) {
            mBandwidth = bandwidth;
            mAverageBandwidth = averageBandwidth;
            mCodecs = codecs;
            mResolution = resolution;
            mFrameRate = frameRate;
            mVideo = video;
            mUri = uri;
            mVideoRange = videoRange;
        }

        @Override
        public Builder withBandwidth(BigInteger bandwidth) {
            mBandwidth = bandwidth;
            return this;
        }

        @Override
        public Builder withAverageBandwidth(BigInteger averageBandwidth) {
            mAverageBandwidth = averageBandwidth;
            return this;
        }

        @Override
        public Builder withCodecs(List<String> codecs) {
            mCodecs = codecs;
            return this;
        }

        @Override
        public Builder withResolution(Resolution resolution) {
            mResolution = resolution;
            return this;
        }

        @Override
        public Builder withFrameRate(float frameRate) {
            mFrameRate = frameRate;
            return this;
        }

        @Override
        public Builder withVideo(String video) {
            mVideo = video;
            return this;
        }

        @Override
        public Builder withVideoRange(VideoRangeType videoRange) {
            mVideoRange = videoRange;
            return this;
        }

        public Builder withUri(String uri) {
            mUri = uri;
            return this;
        }

        public IFrameStreamInfo build() {
            return new IFrameStreamInfo(
                    mBandwidth,
                    mAverageBandwidth,
                    mCodecs,
                    mResolution,
                    mFrameRate,
                    mVideo,
                    mUri,
                    mVideoRange);
        }
    }
}
