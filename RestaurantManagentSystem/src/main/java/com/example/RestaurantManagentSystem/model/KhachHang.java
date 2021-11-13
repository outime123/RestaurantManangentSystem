package com.example.RestaurantManagentSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "mota")
    private String mota;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "khachhang")
    List<HoaDon> list;
    public KhachHang(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "khachhang")
    private List<HoaDon> hoaDonList;
}
