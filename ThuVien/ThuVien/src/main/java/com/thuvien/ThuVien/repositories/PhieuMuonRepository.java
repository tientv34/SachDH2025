package com.thuvien.ThuVien.repositories;

import com.thuvien.ThuVien.entitys.PhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhieuMuonRepository extends JpaRepository<PhieuMuon, Long> {
    @Query(value = "SELECT * FROM phieu_muon WHERE member_id = :memberId", nativeQuery = true)
    List<PhieuMuon> findAllByMemberId(@Param("memberId") Long memberId);

    @Query(value = "SELECT * FROM phieu_muon WHERE create_date >= :fromDate AND return_date <= :toDate", nativeQuery = true)
    List<PhieuMuon> findByDateRange(
            @Param("fromDate") LocalDateTime fromDate,
            @Param("toDate") LocalDateTime toDate
    );

    @Query(value = "SELECT * FROM phieu_muon WHERE status = :status", nativeQuery = true)
    List<PhieuMuon> findAllByStatus(@Param("status") String status);

}
