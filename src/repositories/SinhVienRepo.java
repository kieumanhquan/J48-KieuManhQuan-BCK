package repositories;

import models.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienRepo {

    private List<SinhVien> sinhVienList = new ArrayList<>();

    /**
     * Add a sinhVien object
     * @param sinhVien
     */
    public void add(SinhVien sinhVien) {
        this.sinhVienList.add(sinhVien);
    }

    /**
     * Edit a exist sinhVien
     * Step 1: remove sinhVien at position which stored
     * Step 2: add sinhVien at position which removed
     * @param sinhVien
     * @param position
     */
    public void edit(SinhVien sinhVien, int position) {
        this.sinhVienList.remove(position);
        this.sinhVienList.add(position, sinhVien);
    }

    /**
     * Delete a sinhVien
     * @param position
     */
    public void delete(int position) {
        this.sinhVienList.remove(position);
    }

    /**
     * Method used for save data before close
     */
    public void saveData() {
        // TODO: copy đoạn code ghi file vào đây
    }

    /**
     * Get a sinhVien by maSinhVien
     * @param maSinhVien
     * @return a sinhVien which has maSinhVien map for parameter maSinhVien
     */
    public SinhVien getByMaSinhVien(String maSinhVien) {
        for (SinhVien item : this.sinhVienList) {
            if (maSinhVien.toLowerCase().equals(item.getMaSinhVien().toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    /**
     * Get all sinhVien
     * @return list sinhVien
     */
    public List<SinhVien> getAll(int page, int size, int totalRecords) {
        int from = page  * size;
        int to = (page + 1) * size;
        if (to > totalRecords) {
            return this.sinhVienList.subList(from, totalRecords);
        }
        return this.sinhVienList.subList(from, to);
    }

    /**
     * Find a position's sinhVien is stored in array
     * @param maSinhVien maSinhVien
     * @return position is stored in array
     */
    public int getPosition(String maSinhVien) {
        for (int i = 0; i < this.sinhVienList.size(); i++) {
            SinhVien sinhVien = this.sinhVienList.get(i);
            if (maSinhVien.equals(sinhVien.getMaSinhVien())) {
                return i;
            }
        }
        return -1; // nếu không tìm thấy sinh viên nào thì trả về -1
    }
}
