package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FeedSelDto {
    private int startIdx;
    private int rowCount;

    private FeedSelDto(int startIdx, int rowCount) { //private 생성자
        this.startIdx = startIdx;
        this.rowCount = rowCount;
    }

    public static FeedSelDto.builder builder() {
        return new FeedSelDto.builder();
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

        public FeedSelDto build() {
            return new FeedSelDto(startIdx, rowCount);
        }
    }
}
