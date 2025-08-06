package com.thuvien.ThuVien.services;

import com.thuvien.ThuVien.entitys.ChiTietPhieuMuon;
import com.thuvien.ThuVien.model.request.ChiTietPhieuMuonRequest;

import java.util.List;

public interface ChiTietPhieuMuonServices {
    List<ChiTietPhieuMuon> getAll(String id);

    ChiTietPhieuMuon update(ChiTietPhieuMuonRequest chiTietPhieuMuonRequest, String id);
}
