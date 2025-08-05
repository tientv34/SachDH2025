package com.thuvien.ThuVien.services.impl;

import com.thuvien.ThuVien.entitys.PhieuMuon;
import com.thuvien.ThuVien.repositories.PhieuMuonRepository;
import com.thuvien.ThuVien.services.PhieuMuonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PhieuMuonImpl implements PhieuMuonServices {

    @Autowired
    private PhieuMuonRepository phieuMuonRepository;

    @Override
    public List<PhieuMuon> getAllListPhieu() {
        return phieuMuonRepository.findAll();
    }

    @Override
    public PhieuMuon getPhieuMuonById(Long id) {
        return phieuMuonRepository.findById(id).get();
    }

    @Override
    public List<PhieuMuon> getPhieuMuonByMember(Long idMember) {
        return phieuMuonRepository.findAllByMemberId(idMember);
    }

    @Override
    public List<PhieuMuon> getPhieuMuonByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return phieuMuonRepository.findByDateRange(startDate, endDate);
    }

    @Override
    public List<PhieuMuon> getPhieuMuonByStatus(String status) {
        return phieuMuonRepository.findAllByStatus(status);
    }
}
