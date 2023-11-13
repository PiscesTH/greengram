package com.green.greengram.feed.model;


import lombok.Data;
import java.util.List;

@Data
public class FeedInsDto {
    private int iuser;
    private String contents;
    private String location;    // feed에서 사용
    private List<String> pics;  // feed_pics에서 사용
    //사용하는 곳이 분리 되어서 박스갈이 ? 필요 ?
}
