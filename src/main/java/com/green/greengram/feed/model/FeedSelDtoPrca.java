package com.green.greengram.feed.model;

import lombok.Getter;

@Getter
public class FeedSelDtoPrca {
    private int startIdx;
    private int rowCount;

    private FeedSelDtoPrca(int startIdx, int rowCount) { //private 생성자
        this.startIdx = startIdx;
        this.rowCount = rowCount;
    }

    public static FeedSelDtoPrca.builder builder() {
        return new FeedSelDtoPrca.builder();
    }

    public static class builder {
        private int startIdx;
        private int rowCount;

        public builder() {
        }

        public builder startIdx(int startIdx) {
            this.startIdx = startIdx;
            return this;
        }

        public builder rowCount(int rowCount) {
            this.rowCount = rowCount;
            return this;
        }

        public FeedSelDtoPrca build() {
            return new FeedSelDtoPrca(startIdx, rowCount);
        }
    }
}
