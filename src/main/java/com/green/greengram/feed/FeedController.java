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
    public ResVo insFeed(@RequestBody FeedInsDto dto){
        service.insFeed(dto);
        return null;
    }
    @GetMapping
    public List<FeedSelVo> getFeed(int page){
        return service.getFeed(page);
        //http://localhost:8080/api/feed?page=3 브라우저 로 요청하면 page = 3 저장됨.
    }
}
