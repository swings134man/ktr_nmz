package com.diablo.ktr.user.dao;

import com.diablo.ktr.user.dto.CustMgmtDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final SqlSessionTemplate db;

    public CustMgmtDTO custOne(CustMgmtDTO inDTO) {

        CustMgmtDTO out = db.selectOne("memberMapper.one",inDTO);
        return out;
    }

}
