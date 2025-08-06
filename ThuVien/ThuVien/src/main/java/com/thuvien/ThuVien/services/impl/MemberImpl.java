package com.thuvien.ThuVien.services.impl;

import com.thuvien.ThuVien.entitys.Members;
import com.thuvien.ThuVien.repositories.MemberRepository;
import com.thuvien.ThuVien.services.MemberServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberImpl implements MemberServices {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Members> getAllMember() {
        return memberRepository.findAll();
    }
}
