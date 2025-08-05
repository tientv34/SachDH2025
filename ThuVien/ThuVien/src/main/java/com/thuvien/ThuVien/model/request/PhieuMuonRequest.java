package com.thuvien.ThuVien.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuMuonRequest {
    private String id;
    private String idMember;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
}
