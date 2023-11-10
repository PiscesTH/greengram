package com.green.greengram.user.model;

import lombok.Data;

@Data // getter, setter, toString 생성자 등등 다 만들어 주는 애노테이션
public class UserInsDto {
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
