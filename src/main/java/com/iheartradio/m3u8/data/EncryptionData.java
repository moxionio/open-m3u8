package com.iheartradio.m3u8.data;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EncryptionData {
    private final EncryptionMethod mMethod;
    private final String mUri;
    private final List<Byte> mInitializationVector;
    private final String mKeyFormat;
    private final List<Integer> mKeyFormatVersions;
    private final List<Byte> mKeyId;

    private EncryptionData(EncryptionMethod method, String uri, List<Byte> initializationVector, String keyFormat, List<Integer> keyFormats, List<Byte> keyId) {
        mMethod = method;
        mUri = uri;
        mInitializationVector = initializationVector == null ? null : Collections.unmodifiableList(initializationVector);
        mKeyFormat = keyFormat;
        mKeyFormatVersions = keyFormats == null ? null : Collections.unmodifiableList(keyFormats);
        mKeyId = keyId;
    }

    public EncryptionMethod getMethod() {
        return mMethod;
    }

    public boolean hasUri() {
        return mUri != null && !mUri.isEmpty();
    }

    public String getUri() {
        return mUri;
    }

    public boolean hasInitializationVector() {
        return mInitializationVector != null;
    }

    public List<Byte> getInitializationVector() {
        return mInitializationVector;
    }

    public boolean hasKeyFormat() {
        return mKeyFormat != null;
    }

    public String getKeyFormat() {
        return mKeyFormat;
    }

    public boolean hasKeyFormatVersions() {
        return mKeyFormatVersions != null;
    }

    public List<Integer> getKeyFormatVersions() {
        return mKeyFormatVersions;
    }

    public boolean hasKeyId() {
        return mKeyId != null;
    }

    public List<Byte> getKeyId() {
        return mKeyId;
    }

    public Builder buildUpon() {
        return new Builder(mMethod, mUri, mInitializationVector, mKeyFormat, mKeyFormatVersions, mKeyId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(mInitializationVector, mKeyFormat, mKeyFormatVersions, mMethod, mUri, mKeyId);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EncryptionData)) {
            return false;
        }

        EncryptionData other = (EncryptionData) o;
        
        return Objects.equals(this.mInitializationVector, other.mInitializationVector) &&
                Objects.equals(this.mKeyFormat, other.mKeyFormat) &&
                Objects.equals(this.mKeyFormatVersions, other.mKeyFormatVersions) &&
                Objects.equals(this.mKeyId, other.mKeyId) &&
                Objects.equals(this.mMethod, other.mMethod) &&
                Objects.equals(this.mUri, other.mUri);
    }

    public static class Builder {
        private EncryptionMethod mMethod;
        private String mUri;
        private List<Byte> mInitializationVector;
        private String mKeyFormat;
        private List<Integer> mKeyFormatVersions;
        private List<Byte> mKeyId;

        public Builder() {
        }

        private Builder(EncryptionMethod method, String uri, List<Byte> initializationVector, String keyFormat, List<Integer> keyFormatVersions, List<Byte> keyId) {
            mMethod = method;
            mUri = uri;
            mInitializationVector = initializationVector;
            mKeyFormat = keyFormat;
            mKeyFormatVersions = keyFormatVersions;
            mKeyId = keyId;
        }

        public Builder withMethod(EncryptionMethod method) {
            mMethod = method;
            return this;
        }

        public Builder withUri(String uri) {
            mUri = uri;
            return this;
        }

        public Builder withInitializationVector(List<Byte> initializationVector) {
            mInitializationVector = initializationVector;
            return this;
        }

        public Builder withKeyFormat(String keyFormat) {
            mKeyFormat = keyFormat;
            return this;
        }

        public Builder withKeyFormatVersions(List<Integer> keyFormatVersions) {
            mKeyFormatVersions = keyFormatVersions;
            return this;
        }

        public Builder withKeyId(List<Byte> keyId) {
            mKeyId = keyId;
            return this;
        }

        public EncryptionData build() {
            return new EncryptionData(mMethod, mUri, mInitializationVector, mKeyFormat, mKeyFormatVersions,mKeyId);
        }
    }
}
