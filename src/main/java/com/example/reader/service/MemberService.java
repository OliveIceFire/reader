package com.example.reader.service;

import com.example.reader.entity.Member;
import com.example.reader.entity.MemberReadState;

public interface MemberService {
    Member createMember(String username,String password,String nickname);

    Member checkLogin(String username, String password);

    Member selectById(Long member);


    MemberReadState selectMemberReadState(Long memberId, Long bookId);

    MemberReadState updateMemberReadState(Long memberId, Long bookId, Integer readState);
}
