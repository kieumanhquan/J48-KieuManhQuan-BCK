package services;

import models.SinhVien;
import repositories.SinhVienRepo;

import java.util.List;

public class SinhVienService {

    private SinhVienRepo sinhVienRepo = new SinhVienRepo();

    public void add(SinhVien sinhVien) {
        SinhVien sv = this.sinhVienRepo.getByMaSinhVien(sinhVien.getMaSinhVien());
        if (sv != null) {
            System.out.println("Mã sinh viên đã tồn tại");
            return;
        }
        this.sinhVienRepo.add(sinhVien);
    }

    public void edit(SinhVien sinhVien) {

        int position = this.sinhVienRepo.getPosition(sinhVien.getMaSinhVien());

        this.sinhVienRepo.edit(sinhVien, position);
    }

    public void delete(String maSinhVien) {
        int position = this.sinhVienRepo.getPosition(maSinhVien);
        this.sinhVienRepo.delete(position);
    }

    public void saveData() {
        this.sinhVienRepo.saveData();
    }

    public SinhVien getByMaSinhVien(String maSinhVien) {
        return this.sinhVienRepo.getByMaSinhVien(maSinhVien);
    }

    public List<SinhVien> getAll(int page, int size, int totalRecords) {
        return this.sinhVienRepo.getAll(page, size, totalRecords);
    }
}
