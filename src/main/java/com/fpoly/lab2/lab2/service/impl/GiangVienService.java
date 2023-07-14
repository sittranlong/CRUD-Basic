package com.fpoly.lab2.lab2.service.impl;

import com.fpoly.lab2.lab2.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    List<GiangVien> getAll();

    void remove(String id);

    GiangVien getById(String id);

    void add(GiangVien giangVien);

    GiangVien findByMa(String keyword);
}
