package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo insFeed(FeedInsDto dto) {
        FeedInsProcDto pDto = new FeedInsProcDto(dto);
        int result = mapper.insFeed(pDto);

        FeedPicsInsProcDto p2Dto = new FeedPicsInsProcDto(pDto.getIfeed(), dto.getPics());
        int result2 = mapper.insFeedPic(p2Dto);
        return new ResVo(pDto.getIfeed());
    }

    public List<FeedSelVo> getFeed(int page) {
        int rowCount = 3;
        return mapper.selFeed(FeedSelDto.builder().startIdx((page - 1) * rowCount).rowCount(rowCount).build());
    }
}
