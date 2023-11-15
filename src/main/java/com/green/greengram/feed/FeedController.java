package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResVo insFeed(@RequestBody FeedInsDto dto) {  //form-data로 받을 때는 @RequestBody 없이 작성
        return service.insFeed(dto);
    }

    @GetMapping
    public List<FeedSelVo> getFeed(int page, int iuser) {
        return service.getFeed(page, iuser);
        //http://localhost:8080/api/feed?page=3 브라우저 로 요청하면 page = 3 저장됨.
    }

    @GetMapping("/{ifeed}/fav")
    public ResVo procFav(@PathVariable int ifeed, int iuser) {
        return service.procFav(FeedFavProcDto.builder()
                .ifeed(ifeed)
                .iuser(iuser)
                .build());
    }
}
