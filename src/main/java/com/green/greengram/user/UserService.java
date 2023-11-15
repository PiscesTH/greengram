package com.green.greengram.user;

import com.green.greengram.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int insUser(UserInsDto dto) {
        return mapper.insUser(dto);
    }

    public List<UserSelAllVo> selAllUser() {
        return mapper.selAllUser();
    }

    //1 : 아이디/비번 맞췄음, 2:아이디 없음, 3: 비밀번호 다름
    public UserLoginVo signin(UserSigninDto dto) {
        int result = 3;
        UserLoginVo vo;
        String savedUpw = mapper.selUserByUid(dto.getUid());
        if (savedUpw == null) {
            result = 2;
        } else if (savedUpw.equals(dto.getUpw())) {
            result = 1;
            UserSelOneVo oneVo = mapper.selOneUser(dto.getUid());
            vo = UserLoginVo.builder()
                    .iuser(oneVo.getIuser())
                    .nm(oneVo.getNm())
                    .pic(oneVo.getPic())
                    .result(result)
                    .build();
            return vo;
        }
        vo = UserLoginVo.builder()
                .result(result)
                .build();
        return vo;
    }

    // 1 : 아이디/비번 맞췄음, 2:아이디 없음, 3: 비밀번호 다름
    public int singinSelf(UserSigninDto dto) {
        List<UserSelAllVo> list = mapper.selAllUser();
        for (UserSelAllVo userSelAllVo : list) {
            if (userSelAllVo.getUid().equals(dto.getUid()) && userSelAllVo.getUpw().equals(dto.getUpw())) {
                return 1;
            }
            if (userSelAllVo.getUid().equals(dto.getUid())) {
                return 3;
            }
        }
        return 2;
    }

/*    public UserLoginVo signin2(UserSigninDto dto){
        int result = 3;
        UserLoginVo vo = new UserLoginVo();
        String savedUpw = mapper.selUserByUid(dto.getUid());
        if (savedUpw == null){
            result = 2;
            vo.setResult(result);
        }else if (savedUpw.equals(dto.getUpw())){
            result = 1;
            vo = mapper.selLoginInfo(dto.getUid());
            vo.setResult(result);
            return vo;
        }
        vo.setResult(result);
        return vo;
    }*/
}