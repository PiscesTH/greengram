package com.green.greengram.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSelAllVo {
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    private String createdAt;
}
