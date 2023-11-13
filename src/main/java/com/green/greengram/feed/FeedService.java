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
        int result = mapper.insFeed(pDto);

        FeedPicsInsProcDto p2Dto = new FeedPicsInsProcDto(pDto.getIfeed(),dto.getPics());
        int result2 = mapper.insFeedPic(p2Dto);
        return new ResVo(pDto.getIfeed());
    }
}
