package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<FeedSelVo> getFeedSol(int page) {
        int rowCount = 3;
        List<FeedSelVo> result = mapper.selFeed(FeedSelDto.builder()
                .startIdx((page - 1) * rowCount)
                .rowCount(rowCount)
                .build());
        List<Integer> ifeeds = new ArrayList<>();
        Map<Integer, FeedSelVo> feedMap = new HashMap<>();
        for (FeedSelVo feedSelVo : result) {
            ifeeds.add(feedSelVo.getIfeed());    //ifeeds에 FeedSelVo의 ifeed값 하나씩 add
            feedMap.put(feedSelVo.getIfeed(), feedSelVo);
            //key = ifeed, value = ifeed(key)값을 가진 FeedSelVo 객체의 주소값 Map에 저장
        }
        if (!ifeeds.isEmpty()) {
            List<FeedPicsVo> pics = mapper.selFeedPics(ifeeds);
            for (FeedPicsVo feedPicsVo : pics) {
                FeedSelVo feedVo = feedMap.get(feedPicsVo.getIfeed());
                //FeedSelVo의 ifeed 값을 key로 Map에 저장된 FeedSelVo를 호출하여 주소값 저장
                feedVo.getPics().add(feedPicsVo.getPic());
                //FeedSelVo의 멤버필드 List<String> pics 주소값으로 접근하여 pics에 FeedPicsVo의 pic 값 add
            }
        }
        return result;
    }

    public List<FeedSelVo> getFeed(int page) {
        int rowCnt = 5;
        List<FeedSelVo> result = mapper.selFeed(FeedSelDto.builder()
                .startIdx((page - 1) * rowCnt)
                .rowCount(rowCnt).build());
        List<Integer> iFeedList = new ArrayList<>();
        Map<Integer, FeedSelVo> map = new HashMap<>();
        for (FeedSelVo feedSelVo : result) {
            iFeedList.add(feedSelVo.getIfeed());

            map.put(feedSelVo.getIfeed(), feedSelVo);
        }
        if (!iFeedList.isEmpty()) {
            List<FeedPicsVo> picsList = mapper.selFeedPics(iFeedList);
            for (FeedPicsVo feedPicsVo : picsList) {
                FeedSelVo feedVo = map.get(feedPicsVo.getIfeed());
                feedVo.getPics().add(feedPicsVo.getPic());
            }
        }
        return result;
    }

    //1:좋아요  2:취소
    public ResVo procFav(FeedFavProcDto dto) {
        int result = mapper.delFeedFav(dto);
        if (result == 1) {
            return new ResVo(2);
        }
        return new ResVo(mapper.insFeedFav(dto));
    }
}
