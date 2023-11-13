package com.green.greengram.feed;

import com.green.greengram.feed.model.FeedInsProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);
}
