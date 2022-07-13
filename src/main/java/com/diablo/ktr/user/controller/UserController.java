package com.diablo.ktr.user.controller;

import com.diablo.ktr.user.dto.CustMgmtDTO;
import com.diablo.ktr.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("user/api")
public class UserController {

    private final UserService userService;

    /**
    * @info    : 고객 id 하나 조회.
    * @name    : custOne
    * @date    : 2022/07/13 4:50 PM
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   : custId
    * @return  : CustMgmtDTO
    */
    @GetMapping("/v1/one")
    public CustMgmtDTO custOne(@RequestParam String custId) {

        CustMgmtDTO out = userService.custOne(custId);
        return out;
    }



}
