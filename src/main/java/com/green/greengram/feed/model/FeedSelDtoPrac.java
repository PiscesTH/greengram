package com.green.greengram.feed.model;

import lombok.Getter;

@Getter
public class FeedSelDtoPrac {
    private int startIdx;
    private int rowCount;

    private FeedSelDtoPrac(int startIdx, int rowCount) { //private 생성자
        this.startIdx = startIdx;
        this.rowCount = rowCount;
    }

    public static FeedSelDtoPrac.builder builder() {
        return new FeedSelDtoPrac.builder();
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

        public FeedSelDtoPrac build() {
            return new FeedSelDtoPrac(startIdx, rowCount);
        }
    }
}
