package com.thuvien.ThuVien.services.impl;

import com.thuvien.ThuVien.entitys.ChiTietPhieuMuon;
import com.thuvien.ThuVien.model.request.ChiTietPhieuMuonRequest;
import com.thuvien.ThuVien.repositories.BooksRepository;
import com.thuvien.ThuVien.repositories.ChiTietPhieuMuonRepository;
import com.thuvien.ThuVien.services.ChiTietPhieuMuonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietPhieuMuonImpl implements ChiTietPhieuMuonServices {

    @Autowired
    private ChiTietPhieuMuonRepository chiTietPhieuMuonRepository;

    @Autowired
    private BooksRepository booksRepository;


    @Override
    public List<ChiTietPhieuMuon> getAll(String id) {
        List<ChiTietPhieuMuon> lstChiTietPhieuMuons = chiTietPhieuMuonRepository.findAllByPhieuMuon(id);
        return lstChiTietPhieuMuons;
    }

    @Override
    public ChiTietPhieuMuon update(ChiTietPhieuMuonRequest chiTietPhieuMuonRequest, String id) {
        ChiTietPhieuMuon chiTiet = chiTietPhieuMuonRepository.findById(Long.parseLong(id)).get();
        chiTiet.setStatus(chiTietPhieuMuonRequest.getStatus());
        chiTiet.setQuantity(chiTietPhieuMuonRequest.getQuantity());
        chiTiet.setBook(booksRepository.findById(Long.parseLong(chiTietPhieuMuonRequest.getIdBook())).get());

        return chiTietPhieuMuonRepository.save(chiTiet);
    }
}
