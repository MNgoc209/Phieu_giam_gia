package com.example.kh_pgg.repository;

import com.example.kh_pgg.entity.PhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, String> {
    @Query(value = "select pgg.ma_phieu, pgg.ten_phieu, pgg.ngay_bat_dau, pgg.ngay_ket_thuc, pgg.gia_tri_giam, pgg.trang_thai, kh.ten_khach_hang\n" +
            "from phieu_giam_gia pgg join khach_hang kh\n" +
            "on pgg.ma_khach_hang = kh.ma_khach_hang", nativeQuery = true)
    List<PhieuGiamGia> getAllByKhachHang();

    @Query(value = "select * from phieu_giam_gia where ma_phieu = ?", nativeQuery = true)
    PhieuGiamGia getPhieuGiamGiaById(String maPG);
}
