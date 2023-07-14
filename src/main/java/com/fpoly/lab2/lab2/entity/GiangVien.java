package com.fpoly.lab2.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // contructor khong tham so
@AllArgsConstructor // contructor full tham so
@Builder // Tao ra 1 contructor tuy y.
//@Data // Cam  <=> Giong viec import *
public class GiangVien {
    private String id;
    private String ma;
    private String ten;
    private int tuoi;
    private String gioiTinh;
    private String diaChi;

}
