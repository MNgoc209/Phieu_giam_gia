package com.example.kh_pgg.controller;

import com.example.kh_pgg.entity.KhachHang;
import com.example.kh_pgg.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    private List<KhachHang> ds;
    @Autowired
    private KhachHangRepository khRepo;

    public KhachHangController(){
        this.ds = new ArrayList<>();
    }
}
