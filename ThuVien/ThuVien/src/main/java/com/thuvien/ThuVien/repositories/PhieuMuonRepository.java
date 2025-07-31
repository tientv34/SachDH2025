package com.thuvien.ThuVien.repositories;

import com.thuvien.ThuVien.entitys.PhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuMuonRepository extends JpaRepository<PhieuMuon, Long> {
}
