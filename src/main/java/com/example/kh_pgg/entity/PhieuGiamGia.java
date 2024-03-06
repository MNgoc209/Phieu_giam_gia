package com.example.kh_pgg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phieu_giam_gia")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuGiamGia {
    @Id
    @Column(name = "ma_phieu")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String maPhieu;

    @Column(name = "ten_phieu")
    private String tenPhieu;

    @Column(name = "ngay_bat_dau")
    private String ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private String ngayKetThuc;

    @Column(name = "hinh_thuc_giam")
    private String giaTriGiam;

    @Column(name = "gia_tri_giam_toi_da")
    private String giaTriGiamToiDa;

    @Column(name = "trang_thai")
    private int trangThai;

    @ManyToOne()
    @JoinColumn(name = "ma_khach_hang")
    private KhachHang khach_hang;
}
