package com.thuvien.ThuVien.services;

import com.thuvien.ThuVien.entitys.PhieuMuon;
import com.thuvien.ThuVien.model.request.PhieuMuonRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface PhieuMuonServices {
    List<PhieuMuon> getAllListPhieu(PhieuMuonRequest phieuMuon);

    PhieuMuon getPhieuMuonById(Long id);

    List<PhieuMuon> getPhieuMuonByMember(Long idMember);

    List<PhieuMuon> getPhieuMuonByDate(LocalDateTime startDate, LocalDateTime endDate);

    List<PhieuMuon> getPhieuMuonByStatus(String status);

    PhieuMuon createPhieuMuon (PhieuMuonRequest phieumuon);

    PhieuMuon updatePhieuMuon (String id, String status);

}
