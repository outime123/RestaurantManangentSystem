package com.example.RestaurantManagentSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ban")
@AllArgsConstructor
@NoArgsConstructor
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "thutu")
    private int thutu;
    @Column(name = "soghe")
    private int soghe;
    @OneToMany(mappedBy = "ban",fetch = FetchType.LAZY)
    private List<HoaDon> hoaDonList;
}
