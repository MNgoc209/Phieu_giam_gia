package com.example.kh_pgg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "khach_hang")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @Column(name = "ma_khach_hang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma_khach_hang;

    @Column(name = "ten_khach_hang")
    private String tenKhachHang;
}
