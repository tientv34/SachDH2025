package com.thuvien.ThuVien.services;

import com.thuvien.ThuVien.entitys.PhieuMuon;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface PhieuMuonServices {
    List<PhieuMuon> getAllListPhieu();

    PhieuMuon getPhieuMuonById(Long id);

    List<PhieuMuon> getPhieuMuonByMember(Long idMember);

    List<PhieuMuon> getPhieuMuonByDate(LocalDateTime startDate, LocalDateTime endDate);

    List<PhieuMuon> getPhieuMuonByStatus(String status);

}
