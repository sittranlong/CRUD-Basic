package com.fpoly.lab2.lab2.service;

import com.fpoly.lab2.lab2.entity.GiangVien;
import com.fpoly.lab2.lab2.service.impl.GiangVienService;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    private List<GiangVien> giangViens = new ArrayList<>();

    public GiangVienServiceImpl() {
        giangViens.add(new GiangVien("1", "GV001", "Nguyễn Văn A", 30, "Nam", "Hà Nội"));
        giangViens.add(new GiangVien("2", "GV002", "Trần Thị B", 35, "Nữ", "Hồ Chí Minh"));
        giangViens.add(new GiangVien("3", "GV003", "Lê Văn C", 40, "Nam", "Đà Nẵng"));
        giangViens.add(new GiangVien("4", "GV004", "Phạm Thị D", 28, "Nữ", "Hải Phòng"));
        giangViens.add(new GiangVien("5", "GV005", "Nguyễn Văn E", 32, "Nam", "Cần Thơ"));
        giangViens.add(new GiangVien("6", "GV006", "Trần Thị F", 37, "Nữ", "Vũng Tàu"));
        giangViens.add(new GiangVien("7", "GV007", "Lê Văn G", 41, "Nam", "Nha Trang"));
        giangViens.add(new GiangVien("8", "GV008", "Phạm Thị H", 29, "Nữ", "Bình Dương"));
        giangViens.add(new GiangVien("9", "GV009", "Nguyễn Văn I", 33, "Nam", "Long An"));
        giangViens.add(new GiangVien("10", "GV010", "Trần Thị K", 38, "Nữ", "An Giang"));
    }

    @Override
    public List<GiangVien> getAll() {
        return giangViens;
    }

    @Override
    public void remove(String id) {
        GiangVien giangVienToRemove = null;
        for (GiangVien giangVien : giangViens) {
            if (giangVien.getId().equals(id)) {
                giangVienToRemove = giangVien;
                break;
            }
        }
        if (giangVienToRemove != null) {
            giangViens.remove(giangVienToRemove);
        }
    }

    @Override
    public GiangVien getById(String id) {
        for (GiangVien giangVien : giangViens) {
            if (giangVien.getId().equals(id)) {
                return giangVien;
            }
        }
        return null;
    }

    @Override
    public void add(GiangVien giangVien) {
        if (findByMa(giangVien.getMa()) == null) {
            giangViens.add(giangVien);
        } else {
            // Xử lý trường hợp trùng lặp mã giảng viên
            throw new IllegalArgumentException("Mã giảng viên đã tồn tại");
        }
    }

    public GiangVien findByMa(String ma) {
        for (GiangVien giangVien : giangViens) {
            if (giangVien.getMa().equals(ma)) {
                return giangVien;
            }
        }
        return null;
    }

}
