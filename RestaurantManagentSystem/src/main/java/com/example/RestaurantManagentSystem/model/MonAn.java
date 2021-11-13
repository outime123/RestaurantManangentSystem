package com.example.RestaurantManagentSystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "monan")
public class MonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gia")
    private String gia;
    @ManyToOne
    @JoinColumn(name = "combo_id",nullable = false)
    private Combo combo;
    @ManyToOne
    @JoinColumn(name = "hoadon_id",nullable = false)
    private HoaDon hoadon;
}
