package com.example.RestaurantManagentSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class DoanhThuThang {
//    private int id;
//    private List<HoaDon> hoaDonList;
//    private List<KhachHang> khachHangList;
    private int tt;
    private int thang;
    private int nam;
    private int tongtien;

    public DoanhThuThang() {
    }
}
