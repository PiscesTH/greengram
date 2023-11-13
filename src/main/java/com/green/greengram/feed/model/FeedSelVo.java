package com.green.greengram.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private int iuser;
    private String writer;
    private String createdAt;
    private List<String> pics;
}
