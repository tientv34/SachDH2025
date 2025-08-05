package com.thuvien.ThuVien.services.impl;

import com.thuvien.ThuVien.entitys.ChiTietPhieuMuon;
import com.thuvien.ThuVien.repositories.ChiTietPhieuMuonRepository;
import com.thuvien.ThuVien.services.ChiTietPhieuMuonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietPhieuMuonImpl implements ChiTietPhieuMuonServices {

    @Autowired
    private ChiTietPhieuMuonRepository chiTietPhieuMuonRepository;


    @Override
    public List<ChiTietPhieuMuon> getAll(String id) {
        List<ChiTietPhieuMuon> lstChiTietPhieuMuons = chiTietPhieuMuonRepository.findAllByPhieuMuon(id);
        return lstChiTietPhieuMuons;
    }
}
