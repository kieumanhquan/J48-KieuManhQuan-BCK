package models;

public class Diem {
    private String maSinhVien;
    private String maMonHoc;
    private float diemSo;

    public Diem() {
    }

    public Diem(String maSinhVien, String maMonHoc, float diemSo) {
        this.maSinhVien = maSinhVien;
        this.maMonHoc = maMonHoc;
        this.diemSo = diemSo;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public float getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(float diemSo) {
        this.diemSo = diemSo;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhVien=" + maSinhVien +
                ", maMonHoc='" + maMonHoc + '\'' +
                ", diemSo='" + diemSo +
                '}';
    }
}
