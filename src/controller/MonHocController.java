package controller;

import models.MonHoc;
import services.MonHocService;

import java.util.List;

public class MonHocController {

    private MonHocService monHocService = new MonHocService();

    public void add(MonHoc monHoc) {
        this.monHocService.add(monHoc);
    }

    public List<MonHoc> getAll() {
        return this.monHocService.getAll();
    }

    public MonHoc getByMaMonHoc(String maMonHoc) {
        return this.monHocService.getByMaMonHoc(maMonHoc);
    }
}
