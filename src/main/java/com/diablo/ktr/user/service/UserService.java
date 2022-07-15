package com.diablo.ktr.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.diablo.ktr.user.dao.UserDao;
import com.diablo.ktr.user.dto.CustMgmtDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder pwEncoder;

    public CustMgmtDTO custOne(String custId) {

        CustMgmtDTO inDTO = CustMgmtDTO.builder().custId(custId).build();
        CustMgmtDTO out = userDao.custOne(inDTO);

        return out;
    }

    //고객 가입
    public String custEntr(CustMgmtDTO inDTO) {
        String msg = "";

        inDTO.setCustPw(pwEncoder.encode(inDTO.getCustPw())); // 고객 PW 암호화.

        int result = userDao.custEntr(inDTO);

        if (result == 1) {
            msg = "Success";
        } else {
            msg = "fail";
        }

        return msg;
    }

    // 고객 탈퇴
    public String custDelete(CustMgmtDTO inDTO) {
        String msg = "";
        int result = userDao.custDelete(inDTO);

        if(result == 1 ) {
            msg = "탈퇴 성공";
        }else {
            msg = "error";
        }

        return msg;
    }

    // 고객 수정
    public CustMgmtDTO custUpdate (CustMgmtDTO inDTO) {
        CustMgmtDTO out = new CustMgmtDTO();

        int result = userDao.custUpdate(inDTO);

        if(result == 1) {
            out = userDao.custOne(inDTO);
            out.setMsg("Success");
        }else {
            out.setMsg("Error");
        }

        return out;
    }

    // 고객 login
    public String custLogin(CustMgmtDTO inDTO) {
        String msg = "";
        String custPw = userDao.custLogin(inDTO);

        if(custPw.equals("null") || custPw.equals("")) {
            msg = "fail";
        }else {
            msg = "Login success";
        }

        // 세션 처리 로직 필요.

        return msg;

    }

}//class
