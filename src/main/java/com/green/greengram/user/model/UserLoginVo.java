package com.green.greengram.user.model;

import lombok.*;

@Getter
@Builder
public class UserLoginVo {
    private int iuser;
    private String nm;
    private String pic;
    private int result;
}
