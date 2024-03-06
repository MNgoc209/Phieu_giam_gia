package com.example.kh_pgg.repository;

import com.example.kh_pgg.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
    @Query(value = "select * from khach_hang where ma_khach_hang = ?1", nativeQuery = true)
    KhachHang getKhachHangById(String maKhachHang);
}
