package com.thuvien.ThuVien.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuMuonRequest {
    private String idPhieuMuon;
    private String idBook;
    private Integer quantity;
    private String status;
}
