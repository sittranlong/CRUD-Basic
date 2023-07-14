package com.fpoly.lab2.lab2.controller;

import com.fpoly.lab2.lab2.entity.GiangVien;
import com.fpoly.lab2.lab2.service.GiangVienServiceImpl;
import com.fpoly.lab2.lab2.service.impl.GiangVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "giangVienServlet", value = {
        "/giang-vien/hien-thi",         //GET
        "/giang-vien/search",           //GET
        "/giang-vien/giang-vien-nu",    //GET
        "/giang-vien/detail",           //GET
        "/giang-vien/remove",           //GET
        "/giang-vien/view-update",      //GET
        "/giang-vien/update",           //POST
        "/giang-vien/view-add",         //GET
        "/giang-vien/add"               //POST
})

public class GiangVienServlet extends HttpServlet {
    private GiangVienService giangVienService = new GiangVienServiceImpl();
    private List<GiangVien> lists = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            // lam chuc nang hien thi
            this.hienThiGiangVien(req, resp);
        } else if (uri.contains("search")) {
            // Lam chuc nang search
            this.searchGiangVien(req, resp);
        } else if (uri.contains("giang-vien-nu")) {
            // Lam chuc nang search
            this.filterGiangVienNu(req, resp);
        } else if (uri.contains("view-add")) {
            // hien thi view add
            this.viewAddGiangVien(req, resp);
        } else if (uri.contains("remove")) {
            // lam chuc nang xoa
            this.xoaGiangVien(req, resp);
        } else if (uri.contains("detail")) {
            //lam chuc nang detai
            this.detailGiangVien(req, resp);
        } else {
            //lam chuc nang view update
            this.viewUpdateGiangVien(req, resp);
        }
    }

    private void filterGiangVienNu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GiangVien> nuGiangViens = giangVienService.getAll().stream()
                .filter(gv -> gv.getGioiTinh().equalsIgnoreCase("Nữ"))
                .collect(Collectors.toList());

        req.setAttribute("giangvien", nuGiangViens);
        req.getRequestDispatcher("/view.jsp").forward(req, resp);
    }

    private void viewUpdateGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        GiangVien giangVien = giangVienService.getById(id);

        req.setAttribute("giangvien", giangVien);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    private void detailGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        GiangVien giangVien = giangVienService.getById(id);

        req.setAttribute("giangvien", giangVien);
        req.getRequestDispatcher("/detail.jsp").forward(req, resp);
    }

    private void xoaGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        giangVienService.remove(id);

        resp.sendRedirect(req.getContextPath() + "/giang-vien/hien-thi");
    }

    private void viewAddGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    private void searchGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("searchKeyword");
        List<GiangVien> searchResults = giangVienService.getAll().stream()
                .filter(gv -> gv.getTen().contains(keyword) || gv.getMa().contains(keyword))
                .collect(Collectors.toList());

        req.setAttribute("giangvien", searchResults);
        req.getRequestDispatcher("/view.jsp").forward(req, resp);
    }

    private void hienThiGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lists = giangVienService.getAll(); // có 10 bản ghi
        List<GiangVien> t5 = lists.subList(0, 5); // Lấy chỉ 5 bản ghi đầu tiên
        // Truyen servlet => jsp
        req.setAttribute("giangvien", t5);
        req.getRequestDispatcher("/view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            this.addGiangVien(req, resp);
        } else {
            this.updateGiangVien(req, resp);
        }
    }

    private void updateGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Lấy thông tin từ request và cập nhật thông tin giảng viên
        String id = req.getParameter("id");
        GiangVien giangVien = giangVienService.getById(id);

        // Lấy thông tin từ request và cập nhật thông tin giảng viên
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String tuoiStr = req.getParameter("tuoi");
        int tuoi = 0;

        try {
            tuoi = Integer.parseInt(tuoiStr);
        } catch (NumberFormatException e) {
            // Ghi log lỗi
            e.printStackTrace();

            // Hiển thị thông báo lỗi cho người dùng
            String errorMessage = "Giá trị tuổi không hợp lệ. Vui lòng nhập một số nguyên.";
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
        }
        String gioiTinhStr = req.getParameter("gioiTinh");
        String gioiTinh = gioiTinhStr != null ? gioiTinhStr : "";
        String diaChi = req.getParameter("diaChi");

        giangVien.setMa(ma);
        giangVien.setTen(ten);
        giangVien.setTuoi(tuoi);
        giangVien.setGioiTinh(gioiTinh);
        giangVien.setDiaChi(diaChi);

        resp.sendRedirect(req.getContextPath() + "/giang-vien/hien-thi");
    }

    private void addGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        int tuoi = Integer.parseInt(req.getParameter("tuoi"));
        String diaChi = req.getParameter("diaChi");

        String gioiTinh = "";
        boolean gioiTinhValid = false;

        while (!gioiTinhValid) {
            String gioiTinhStr = req.getParameter("gioiTinh");
            if ("nam".equalsIgnoreCase(gioiTinhStr)) {
                gioiTinh = "Nam";
                gioiTinhValid = true;
            } else if ("nữ".equalsIgnoreCase(gioiTinhStr)) {
                gioiTinh = "Nữ";
                gioiTinhValid = true;
            } else {
                // Yêu cầu nhập lại nếu giới tính không hợp lệ
                // Có thể hiển thị thông báo lỗi cho người dùng tại đây
                resp.getWriter().println("Giới tính không hợp lệ. Vui lòng nhập lại.");
                // Hoặc chuyển hướng tới một trang thông báo lỗi
                // Ví dụ: resp.sendRedirect(req.getContextPath() + "/error.jsp");
                gioiTinhValid = false;
            }
        }

        // Tạo một đối tượng GiangVien mới và thêm vào danh sách
        GiangVien giangVien = new GiangVien();
        giangVien.setId(id);
        giangVien.setMa(ma);
        giangVien.setTen(ten);
        giangVien.setTuoi(tuoi);
        giangVien.setGioiTinh(gioiTinh);
        giangVien.setDiaChi(diaChi);

        giangVienService.add(giangVien);
        resp.sendRedirect(req.getContextPath() + "/giang-vien/hien-thi");
    }

}
