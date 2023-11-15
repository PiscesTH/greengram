package com.green.greengram.user;

import com.green.greengram.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user") // 공통된 주소값 가지게 함.
public class UserController {
    private final UserService service;

    @PostMapping
    public ResVo insUser(@RequestBody UserInsDto dto) {
        int result = service.insUser(dto);
        return new ResVo(result);
    }

    @GetMapping
    public List<UserSelAllVo> selAllUser() {
        return service.selAllUser();
    }

    @PostMapping("/signin")
    public UserLoginVo login(@RequestBody UserSigninDto dto) {
        return service.signin(dto);
    }


}
