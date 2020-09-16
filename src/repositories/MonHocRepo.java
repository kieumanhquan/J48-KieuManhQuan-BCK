package repositories;

import models.MonHoc;

import java.util.ArrayList;
import java.util.List;

public class MonHocRepo {

    private List<MonHoc> monHocList = new ArrayList<>();

    public void add(MonHoc monHoc) {
        this.monHocList.add(monHoc);
    }

    public void edit(MonHoc monHoc, int position) {
        this.monHocList.remove(position);
        this.monHocList.add(position, monHoc);
    }

    public MonHoc getByMaMonHoc(String maMonHoc) {;
        for (int i = 0; i < this.monHocList.size(); i++) {
            MonHoc item = this.monHocList.get(i);
            if (maMonHoc.equals(item.getMaMonHoc())) {
                return item;
            }
        }

        return null;
    }

    public List<MonHoc> getAll() {
        return this.monHocList;
    }
}
