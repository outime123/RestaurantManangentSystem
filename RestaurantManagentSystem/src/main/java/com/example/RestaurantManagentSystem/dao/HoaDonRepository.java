package com.example.RestaurantManagentSystem.dao;

import com.example.RestaurantManagentSystem.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
    @Query(value = "SELECT * FROM hoadon WHERE month(ngaytao) = :month ",nativeQuery = true)
    List<HoaDon> getHDByMonth(@Param("month") int month);

}
