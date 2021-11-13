package com.example.RestaurantManagentSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "thanhvien")
public class ThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "ngaysinh")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "sodienthoai")
    private String sodienthoai;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy = "thanhvien",fetch = FetchType.EAGER)
    private List<HoaDon> hoaDonList;
}
