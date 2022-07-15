package com.diablo.ktr.user.controller;

import com.diablo.ktr.user.dto.CustMgmtDTO;
import com.diablo.ktr.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public CustMgmtDTO custOne(@RequestParam String custId) {

        CustMgmtDTO out = userService.custOne(custId);
        return out;
    }

    //고객 가입
    @PostMapping("/v1/entr")
    @ResponseBody
    public String custEntr(@RequestBody CustMgmtDTO inDTO) {
        String msg = userService.custEntr(inDTO);
        return msg;
    }

    // 고객 탈퇴
    @DeleteMapping("/v1/delete")
    @ResponseBody
    public String custDelete(@RequestParam String custId) {

        CustMgmtDTO inDTO = CustMgmtDTO.builder()
                                       .custId(custId)
                                       .build();

        String msg = userService.custDelete(inDTO);
        return msg;
    }

    // 고객 수정
    @PostMapping("v1/update")
    @ResponseBody
    public CustMgmtDTO custUpdate (CustMgmtDTO inDTO) {
        CustMgmtDTO out = userService.custUpdate(inDTO);
        return out;
    }

    // 고객 login
    @PostMapping("v1/login")
    @ResponseBody
    public String custLogin(@RequestParam String custId, String custPw) {
        CustMgmtDTO inDTO = CustMgmtDTO.builder()
                                        .custId(custId)
                                        .custPw(custPw)
                                        .build();

        String msg = userService.custLogin(inDTO);

        return msg;
    }

}
