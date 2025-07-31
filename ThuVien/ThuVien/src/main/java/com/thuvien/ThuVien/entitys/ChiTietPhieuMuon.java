package com.thuvien.ThuVien.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="chi_tiet_phieu_muon")
public class ChiTietPhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "phieuMuon_id")
    private PhieuMuon phieuMuon;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;

    @JoinColumn(name = "quantity")
    private Integer quantity;
}
