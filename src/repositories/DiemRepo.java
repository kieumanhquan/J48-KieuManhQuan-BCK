package repositories;

import models.Diem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiemRepo {
    private List<Diem> diemList = new ArrayList<>();

    public void add(Diem diem) {
        this.diemList.add(diem);
    }

    public void edit(Diem diem, int position) {
        this.diemList.remove(position);
        this.diemList.add(position, diem);
    }

    public List<Diem> getAllDiemByMaSinhVien (String maSinhVien) {;
        return this.diemList.stream().filter(item -> item.getMaSinhVien().equals(maSinhVien))
                .collect(Collectors.toList());
    }
}
