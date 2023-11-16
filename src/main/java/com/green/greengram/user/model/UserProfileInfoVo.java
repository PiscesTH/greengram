package com.green.greengram.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileInfoVo {
    private String nm;
    private String createdAt;
    private int feedCnt;
    private int favCnt;
}
