package com.example.kh_pgg.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuGiamGiaRequest {
    private String maPhieu;

    @NotBlank(message = "Không để trống tên")
    private String tenPhieu;

    @NotBlank(message = "Không để trống tên")
    private String ngayBatDau;

    @NotBlank(message = "Không để trống tên")
    private String ngayKetThuc;

    @NotBlank(message = "Không để trống tên")
    private String giaTriGiam;

    @NotBlank(message = "Không để trống tên")
    private String giaTriGiamToiDa;

    @NotBlank(message = "Không để trống tên")
    private int trangThai;
}
