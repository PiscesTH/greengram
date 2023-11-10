package com.green.greengram.user;

import com.green.greengram.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public UserSelOneVo selOneUser(int iuser) {
        return mapper.selOneUser(iuser);
    }
    //1 : 아이디/비번 맞췄음, 2:아이디 없음, 3: 비밀번호 다름

    public int singinSol(UserSigninDto dto){
        int result = 3;
        String savedUpw = mapper.selUserByUid(dto.getUid());
        if (savedUpw == null){
            result = 2;
        }else if (savedUpw.equals(dto.getUpw())){
            result = 1;
        }
        return result;
    }

    public int singin(UserSigninDto dto) {
        List<UserSelAllVo> list = mapper.selAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUid().equals(dto.getUid()) && list.get(i).getUpw().equals(dto.getUpw())) {
                return 1;
            }
        }
        List<String> strList = new ArrayList<>();
        for (UserSelAllVo s : list) {
            strList.add(s.getUid());
        }
        if (strList.contains(dto.getUid())){
            return 3;
        }
        return 2;
    }
}