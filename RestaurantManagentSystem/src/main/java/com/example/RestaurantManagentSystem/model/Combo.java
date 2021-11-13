package com.example.RestaurantManagentSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name = "combo")
@AllArgsConstructor
@NoArgsConstructor
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gia")
    private String gia;
    @Column(name = "mota")
    private String mota;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "combo")
    private List<MonAn> monAnList;
    @ManyToOne
    @JoinColumn(name = "hoadon_id",nullable = false)
    private HoaDon hoadon;
}
