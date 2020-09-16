package models;

public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private float heSo;

    public MonHoc() {
    }

    public MonHoc(String maMonHoc, String tenMonHoc, float heSo) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.heSo = heSo;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public float getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "maMonHoc=" + maMonHoc +
                ", tenMonHoc='" + tenMonHoc + '\'' +
                ", heSo='" + heSo +
                '}';
    }
}
