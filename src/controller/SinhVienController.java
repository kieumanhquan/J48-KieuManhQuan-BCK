package controller;

import models.SinhVien;
import services.SinhVienService;

import java.util.List;

public class SinhVienController {

    private SinhVienService sinhVienService = new SinhVienService();

    public void add(SinhVien sinhVien) {
        this.sinhVienService.add(sinhVien);
    }

    public void edit(SinhVien sinhVien) {
        this.sinhVienService.edit(sinhVien);
    }

    public void delete(String maSinhVien) {
        this.sinhVienService.delete(maSinhVien);
    }

    public void saveData() {
        this.sinhVienService.saveData();
    }

    public SinhVien getByMaSinhVien(String maSinhVien) {
        return this.sinhVienService.getByMaSinhVien(maSinhVien);
    }

    public List<SinhVien> getAll(int page, int size, int totalRecords) {
        return this.sinhVienService.getAll(page, size, totalRecords);
    }
}
