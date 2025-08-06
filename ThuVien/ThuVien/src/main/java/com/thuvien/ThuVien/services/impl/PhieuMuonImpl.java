package com.thuvien.ThuVien.services.impl;

import com.thuvien.ThuVien.entitys.Books;
import com.thuvien.ThuVien.entitys.ChiTietPhieuMuon;
import com.thuvien.ThuVien.entitys.Members;
import com.thuvien.ThuVien.entitys.PhieuMuon;
import com.thuvien.ThuVien.model.request.ChiTietPhieuMuonRequest;
import com.thuvien.ThuVien.model.request.PhieuMuonRequest;
import com.thuvien.ThuVien.repositories.BooksRepository;
import com.thuvien.ThuVien.repositories.ChiTietPhieuMuonRepository;
import com.thuvien.ThuVien.repositories.MemberRepository;
import com.thuvien.ThuVien.repositories.PhieuMuonRepository;
import com.thuvien.ThuVien.services.PhieuMuonServices;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhieuMuonImpl implements PhieuMuonServices {

    @Autowired
    private PhieuMuonRepository phieuMuonRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private ChiTietPhieuMuonRepository chiTietPhieuMuonRepository;

    @Override
    public List<PhieuMuon> getAllListPhieu(PhieuMuonRequest phieuMuon) {
        List<PhieuMuon> lstPhieuMuon = phieuMuonRepository.findAll(buildSpec(phieuMuon));
        return lstPhieuMuon;
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

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class}, timeout = 60)
    public PhieuMuon createPhieuMuon(PhieuMuonRequest phieumuon) {
        PhieuMuon phieuMuonEntity = new PhieuMuon();

        Members member = memberRepository.findById(Long.parseLong(phieumuon.getIdMember())).get();

        phieuMuonEntity.setCreateDate(LocalDateTime.now());
        phieuMuonEntity.setReturnDate(null);
        phieuMuonEntity.setStatus("0");
        phieuMuonEntity.setMember(member);
        phieuMuonEntity.setActualReturn(phieumuon.getEndDate());
        phieuMuonEntity.setLoaiPhieu(phieumuon.getLoaiPhieu());

        PhieuMuon phieuMuonSave = phieuMuonRepository.save(phieuMuonEntity);

        for(ChiTietPhieuMuonRequest chiTietPM : phieumuon.getLstChiTietPhieuMuon()){
            Books bookEntity = booksRepository.findById(Long.parseLong(chiTietPM.getIdBook()))
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + chiTietPM.getIdBook()));

            ChiTietPhieuMuon chiTiet = new ChiTietPhieuMuon();
            chiTiet.setPhieuMuon(phieuMuonSave);
            chiTiet.setBook(bookEntity);
            chiTiet.setStatus(phieuMuonSave.getStatus());

            if(chiTietPM.getQuantity() <= bookEntity.getSoLuong()){
                chiTiet.setQuantity(chiTietPM.getQuantity());
            }else {
                new RuntimeException("So luong sach k du: " + chiTietPM.getIdBook());
                return null;
            }
            chiTietPhieuMuonRepository.save(chiTiet);
        }

        return phieuMuonSave;
    }

    @Override
    public PhieuMuon updatePhieuMuon(String id, String status) {
        PhieuMuon phieuMuon = phieuMuonRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        phieuMuon.setStatus(status);

        return phieuMuonRepository.save(phieuMuon);
    }

    public Specification<PhieuMuon> buildSpec(PhieuMuonRequest phieuMuon) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (phieuMuon.getIdMember() != null) {
                predicates.add(cb.equal(root.get("member").get("id"), phieuMuon.getIdMember()));
            }

            if (phieuMuon.getId() != null) {
                predicates.add(cb.equal(root.get("createDate"), phieuMuon.getId()));
            }

            if (phieuMuon.getStartDate() != null) {
                predicates.add(cb.equal(root.get("returnDate"), phieuMuon.getStartDate()));
            }

            if(phieuMuon.getEndDate() != null){
                predicates.add(cb.equal(root.get("returnDate"), phieuMuon.getEndDate()));
            }

            if(phieuMuon.getLoaiPhieu() != null){
                predicates.add(cb.equal(root.get("returnDate"), phieuMuon.getLoaiPhieu()));
            }

            if(phieuMuon.getStatus() != null){
                predicates.add(cb.equal(root.get("returnDate"), phieuMuon.getStatus()));
            }

            // Kết hợp tất cả điều kiện lại (AND)
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
