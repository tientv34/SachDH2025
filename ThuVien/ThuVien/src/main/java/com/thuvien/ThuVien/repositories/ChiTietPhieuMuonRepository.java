package com.thuvien.ThuVien.repositories;

import com.thuvien.ThuVien.entitys.ChiTietPhieuMuon;
import com.thuvien.ThuVien.entitys.PhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietPhieuMuonRepository extends JpaRepository<ChiTietPhieuMuon, Long> {
    @Query(value = "SELECT * FROM chi_tiet_phieu_muon WHERE phieuMuon_id = :id", nativeQuery = true)
    List<ChiTietPhieuMuon> findAllByPhieuMuon(@Param("id") String id);
}
