package services;

import models.MonHoc;

import repositories.MonHocRepo;

import java.util.List;

public class MonHocService {

    private MonHocRepo monHocRepo = new MonHocRepo();

    public void add(MonHoc monHoc) {
        MonHoc sv = this.getByMaMonHoc(monHoc.getMaMonHoc());
        if (sv != null) {
            System.out.println("Mã môn học đã tồn tại");
            return;
        }
        this.monHocRepo.add(monHoc);
    }

    public MonHoc getByMaMonHoc(String maMonHoc) {
        return this.monHocRepo.getByMaMonHoc(maMonHoc);
    }

    public List<MonHoc> getAll() {
        return this.monHocRepo.getAll();
    }

}
