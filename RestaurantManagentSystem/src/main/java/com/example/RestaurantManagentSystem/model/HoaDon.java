package com.example.RestaurantManagentSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hoadon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ngaytao")
    @Temporal(TemporalType.DATE)
    private Date ngaytao;
    @Column(name = "tongtien")
    private String tongtien;
    @ManyToOne
    @JoinColumn(name = "khachhang_id", nullable = false)
    private KhachHang khachhang;
    @ManyToOne
    @JoinColumn(name = "thanhvien_id", nullable = false)
    private ThanhVien thanhvien;
    @OneToMany(mappedBy = "hoadon")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MonAn> monAnList ;
    @OneToMany(mappedBy = "hoadon")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Combo> comboList;
    @ManyToOne
    @JoinColumn(name = "ban_id",nullable = false)
    private Ban ban;
}
