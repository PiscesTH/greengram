package com.green.greengram.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileInfoVo {
    private int feedCnt;
    private int favCnt;
    private String nm;
    private String createdAt;
}
