package com.diablo.ktr.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.diablo.ktr.user.dao.UserDao;
import com.diablo.ktr.user.dto.CustMgmtDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDao userDao;

    public CustMgmtDTO custOne(String custId) {

        CustMgmtDTO inDTO = CustMgmtDTO.builder().custId(custId).build();
        CustMgmtDTO out = userDao.custOne(inDTO);

        return out;
    }

}
