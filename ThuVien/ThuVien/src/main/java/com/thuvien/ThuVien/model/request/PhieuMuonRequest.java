package com.thuvien.ThuVien.model.request;

import com.thuvien.ThuVien.entitys.ChiTietPhieuMuon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuMuonRequest {
    private String id;
    private String idMember;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private List<ChiTietPhieuMuonRequest> lstChiTietPhieuMuon;
}
