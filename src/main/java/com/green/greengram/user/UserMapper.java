package com.green.greengram.user;


import com.green.greengram.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    List<UserSelAllVo> selAllUser();
    UserSelOneVo selOneUser(String uid);
    String selUserByUid(String uid);
    UserLoginVo selLoginInfo(String uid);
    UserProfileInfoVo selUserProfileInfo(int iuser);
}
