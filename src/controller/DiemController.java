package controller;

import models.Diem;
import services.DiemService;

import java.util.List;

public class DiemController {

    private DiemService diemService = new DiemService();

    public void add(Diem diem) {
        this.diemService.add(diem);
    }

    public List<Diem> getAllDiemByMaSinhVien(String maSinhVien) {
        return this.diemService.getAllDiemByMaSinhVien(maSinhVien);
    }
}
