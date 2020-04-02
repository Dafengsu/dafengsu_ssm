package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author su
 * @description
 * @date 2020/4/1
 */
public interface MemberDao {
    @Select("SELECT * FROM MEMBER WHERE ID = #{memberId}")
    Member findByd(String memberId) throws Exception;
}
