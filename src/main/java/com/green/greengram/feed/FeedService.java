package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo insFeed(FeedInsDto dto){
        FeedInsProcDto pDto = new FeedInsProcDto(dto);
        System.out.println(dto);
        System.out.println(pDto);
        return null;
    }
}
