package com.example.kh_pgg.controller;

import com.example.kh_pgg.entity.KhachHang;
import com.example.kh_pgg.entity.PhieuGiamGia;
import com.example.kh_pgg.repository.KhachHangRepository;
import com.example.kh_pgg.repository.PhieuGiamGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/phieu-giam-gia")
public class PhieuGiamGiaController {
    @Autowired
    KhachHangRepository khRepo;
    private List<PhieuGiamGia> ds;
    private List<KhachHang> listKH;
    @Autowired
    private PhieuGiamGiaRepository pggRepo;

    public PhieuGiamGiaController() {
        this.ds = new ArrayList<>();
    }

    @ModelAttribute("listKhachHang")
    List<KhachHang> listKhachHang() {
        return khRepo.findAll();
    }

    @GetMapping("hien-thi")
    public String hienThi(Model model, @ModelAttribute("pgg") PhieuGiamGia pgg) {
        this.ds = this.pggRepo.findAll();
        model.addAttribute("listKH", this.listKH);
        model.addAttribute("listPGG", this.ds);
        return "phieu_giam_gia/index";
    }

    @GetMapping("/delete/{maPhieu}")
    public String delete(@PathVariable("maPhieu") String maPG){
        this.pggRepo.deleteById(maPG);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @GetMapping("/detail/{maPhieu}")
    public String detail(Model model,
                         @PathVariable("maPhieu") String maPGG){
        PhieuGiamGia phieuGiamGia;
        phieuGiamGia = pggRepo.getPhieuGiamGiaById(maPGG);
        model.addAttribute("pgg", phieuGiamGia);
        return "phieu_giam_gia/detail";
    }

    @PostMapping("/update/{maPhieu}")
    public String update(Model model,
                         @PathVariable("maPhieu") String maPG,
                         @RequestParam("tenPhieu") String tenPG,
                         @RequestParam("giaTriGiam") String giaTriGiam,
                         @RequestParam("giaTriGiamToiDa") String giaTriGiamTD,
                         @RequestParam("ngayBatDau") String ngayBD,
                         @RequestParam("ngayKetThuc") String ngayKT,
                         @RequestParam("khach_hang") String maKH){
        PhieuGiamGia phieuGiamGia;
        phieuGiamGia = pggRepo.getPhieuGiamGiaById(maPG);
        model.addAttribute("pgg", phieuGiamGia);
        phieuGiamGia.setTenPhieu(tenPG);
        phieuGiamGia.setGiaTriGiam(giaTriGiam);
        phieuGiamGia.setGiaTriGiamToiDa(giaTriGiamTD);
        phieuGiamGia.setNgayBatDau(ngayBD);
        phieuGiamGia.setNgayKetThuc(ngayKT);
//        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy/mm/nn");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("nn/mm/yyyy");
//
//        try {
//            Date ngayBatDauDate = inputFormat.parse(ngayBD);
//            Date ngayKetThucDate = inputFormat.parse(ngayKT);
//
//            String ngayBatDauFormatted = outputFormat.format(ngayBatDauDate);
//            String ngayKetThucFormatted = outputFormat.format(ngayKetThucDate);
//
//            phieuGiamGia.setNgayBatDau(ngayBatDauFormatted);
//            phieuGiamGia.setNgayKetThuc(ngayKetThucFormatted);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        KhachHang khachHang = khRepo.getOne(maKH);
        phieuGiamGia.setKhach_hang(khachHang);
        pggRepo.save(phieuGiamGia);
        return "redirect:/phieu-giam-gia/hien-thi";
    }
}
