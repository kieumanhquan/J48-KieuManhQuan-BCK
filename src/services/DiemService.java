package services;

import models.Diem;
import repositories.DiemRepo;

import java.util.List;

public class DiemService {

    private DiemRepo diemRepo = new DiemRepo();

    public void add(Diem diem) {

        this.diemRepo.add(diem);
    }

    public List<Diem> getAllDiemByMaSinhVien(String maSinhVien) {
        return this.diemRepo.getAllDiemByMaSinhVien(maSinhVien);
    }
}
