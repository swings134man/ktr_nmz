package com.diablo.ktr.user.dao;

import com.diablo.ktr.user.dto.CustMgmtDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final SqlSessionTemplate db;

    public CustMgmtDTO custOne(CustMgmtDTO inDTO) {
        CustMgmtDTO out = db.selectOne("memberMapper.one",inDTO);
        return out;
    }

    // 고객 가입
    public int custEntr(CustMgmtDTO inDTO) {
        int result = db.insert("",inDTO);
        return result;
    }

    // 고객 탈퇴
    public int custDelete(CustMgmtDTO inDTO) {
        int result = db.delete("", inDTO);
        return result;
    }

    // 고객 수정
    public int custUpdate (CustMgmtDTO inDTO) {
        int result = db.update("", inDTO);
        return result;
    }

    // 고객 login
    public String custLogin(CustMgmtDTO inDTO) {
        String custPw = db.selectOne("", inDTO);
        return custPw;
    }

}
