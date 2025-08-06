package com.thuvien.ThuVien.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phieuMuon")
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Members member;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "actual_return")
    private LocalDateTime actualReturn;

    @Column(name = "status")
    private String status;

    @Column(name = "loaiphieu")
    private String loaiPhieu;

    @OneToMany(mappedBy = "phieuMuon", cascade = CascadeType.ALL)
    private List<ChiTietPhieuMuon> lstChiTietPhieuMuon;
}
