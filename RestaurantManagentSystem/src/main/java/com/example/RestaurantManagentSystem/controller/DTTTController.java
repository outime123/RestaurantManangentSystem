package com.example.RestaurantManagentSystem.controller;

import com.example.RestaurantManagentSystem.dao.HoaDonRepository;
import com.example.RestaurantManagentSystem.model.DoanhThuThang;
import com.example.RestaurantManagentSystem.model.HoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Controller
public class DTTTController {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @GetMapping
    public String index() throws ParseException {
        System.out.println(hoaDonRepository.getHDByMonth(10));
        //getHDByDate();
        return "gdChinhQL";
    }

    @PostMapping("/add")
    public HoaDon addHD(@RequestBody HoaDon hoaDon){
        return hoaDonRepository.save(hoaDon);
    }
    @GetMapping("/gdTKDoanhThuCuaThang/{ten}")
    public String getTKDTcuaT(Model model,@PathVariable int ten){
        List<HoaDon> donList = hoaDonRepository.getHDByMonth(ten);
        model.addAttribute("listHD",donList);
        return "/gdTKDoanhThuCuaThang";
    }
    @GetMapping("/gdTKDoanhThuTheoThang")
    public String getAllDTT(Model model){
        List<HoaDon> listhd = (List<HoaDon>) hoaDonRepository.findAll();
        List<DoanhThuThang> doanhThuThangList = new ArrayList<>();
        Set<Integer> integers = new HashSet<>();
        listhd.forEach(hoaDon -> {
            LocalDate localDate = hoaDon.getNgaytao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            integers.add(localDate.getYear()*100+localDate.getMonthValue());
        });
        integers.forEach(integer -> {
            DoanhThuThang doanhThuThang = new DoanhThuThang();
                int tongtien = listhd.stream().filter(hoaDon -> getMonthYear(hoaDon) == integer).mapToInt(hoaDon -> Integer.parseInt(hoaDon.getTongtien())).sum();
                doanhThuThang.setThang(integer%100);
                doanhThuThang.setNam(integer/100);
                doanhThuThang.setTongtien(tongtien);
                doanhThuThangList.add(doanhThuThang);
            });

        Collections.sort(doanhThuThangList,(DoanhThuThang doanhThuThang1, DoanhThuThang doanhThuThang2) ->{
            if(doanhThuThang1.getNam()==doanhThuThang2.getNam()) return Integer.toString(doanhThuThang1.getThang()+doanhThuThang1.getNam()).compareTo(Integer.toString(doanhThuThang2.getThang()+doanhThuThang2.getNam()));
            else return Integer.toString(doanhThuThang1.getNam()).compareTo(Integer.toString(doanhThuThang2.getNam()));
        });
        for (int i = 0; i < doanhThuThangList.size(); i++) {
            doanhThuThangList.get(i).setTt(i+1);
        }
        model.addAttribute("listDTT",doanhThuThangList);
        return "/gdTKDoanhThuTheoThang";
    }
    public int getMonthYear(HoaDon hoaDon){
        LocalDate localDate = hoaDon.getNgaytao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getYear()*100+localDate.getMonthValue();
    }
    public String getMonth(HoaDon hoaDon){
        LocalDate localDate = hoaDon.getNgaytao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Integer.toString(localDate.getMonthValue());
    }
    public String getYear(HoaDon hoaDon){
        LocalDate localDate = hoaDon.getNgaytao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Integer.toString(localDate.getYear());
    }
    public int getMonthYear(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getYear()*100+localDate.getMonthValue();
    }
    public void getHDByDate() throws ParseException {
        String s1 = "2020-12-01";
        String s2 = "2021-11-01";
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(s1);
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(s2);
        int dateint1 = getMonthYear(start);
        int dateint2 = getMonthYear(end);
        List<HoaDon> list = hoaDonRepository.findAll();
        list.forEach(hoaDon -> {
            if(getMonthYear(hoaDon)>dateint1 && getMonthYear(hoaDon)<=dateint2) System.out.println(hoaDon);
        });
    }
}
