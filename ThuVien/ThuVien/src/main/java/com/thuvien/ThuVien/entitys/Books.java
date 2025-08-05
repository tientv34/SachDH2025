package com.thuvien.ThuVien.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenSach")
    private String tenSach;

    @Column(name = "tacGia")
    private String tacGia;

    @Column(name = "nhaXuatBan")
    private String nhaXuatBan;

    @Column(name = "namXuatBan")
    private Integer namXuatBan;

    @Column(name = "theLoai")
    private String theLoai;

    @Column(name = "isbn" , unique = true)
    private String isbn;

    @Column(name = "soLuong")
    private Integer soLuong;

}
