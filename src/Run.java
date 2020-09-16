import controller.DiemController;
import controller.MonHocController;
import controller.SinhVienController;
import models.Diem;
import models.MonHoc;
import models.SinhVien;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Run {

    static int TOTAL_RECORDS = 0;
    static int TOTAL_PAGE = 0;
    static int PAGE = 0;
    static int SIZE = 10;

    static Scanner sc = new Scanner(System.in);
    static SinhVienController sinhVienController = new SinhVienController();
    static MonHocController monHocController = new MonHocController();
    static DiemController diemController = new DiemController();

    public static void main(String[] args) {
        try {
            List<SinhVien> sinhViens = readSinhVienFile(); // 27 records
            TOTAL_RECORDS = sinhViens.size();

            if (TOTAL_RECORDS % SIZE == 0) {
                TOTAL_PAGE = TOTAL_RECORDS / SIZE; // 2 pages
            } else {
                TOTAL_PAGE = (TOTAL_RECORDS / SIZE) + 1; // 3 pages
            }
            sinhViens.forEach(item -> {
                sinhVienController.add(item);
            });

            List<MonHoc> monHocs = readMonHocFile();

            monHocs.forEach(item -> {
                monHocController.add(item);
            });

            List<Diem> diems = readDiemFile();

            diems.forEach(item -> {
                diemController.add(item);
            });

            mainMenu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void mainMenu() {
        int option = 0;

        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                Nội dung                                │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("│\t 1. Sinh viên                                                        │");
        System.out.println("│\t 2. Môn học                                                          │");
        System.out.println("│\t 3. Điểm                                                             │");
        System.out.println("│\t 4. Thoát                                                            │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("Lựa chọn: ");
        option = sc.nextInt();
        switch (option) {
            case 1:
                actionSinhVien();
                break;
            case 2:
                actionMonHoc();
                break;
            case 3:
                break;
            case 4:
                sinhVienController.saveData();
                break;
            default:
                break;
        }
    }

    public static void actionSinhVien() {
        int optionSinhVien = 0;

        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                Sinh viên                               │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("│\t 1. Thêm mới                                                         │");
        System.out.println("│\t 2. Sửa                                                              │");
        System.out.println("│\t 3. Xóa                                                              │");
        System.out.println("│\t 4. Tìm kiếm theo mã sinh viên                                       │");
        System.out.println("│\t 5. Hiển thị danh sach                                               │");
        System.out.println("│\t 6. Quay lại                                                         │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("Lựa chọn: ");
        optionSinhVien = sc.nextInt();
        switch (optionSinhVien) {
            case 1:
                addSinhVien();
                break;
            case 2:
                editSinhVien();
                break;
            case 3:
                deleteSinhVien();
                break;
            case 4:
                getByMaSinhVien();
                break;
            case 5:
                getAllSinhVien();
                break;
            case 6:
                mainMenu();
                break;
            default:
                break;
        }
    }

    public static void addSinhVien() {
        System.out.println("Nhập mã sinh viên: ");
        String maSinhVien = sc.nextLine();

        System.out.println("Nhập họ & tên đệm: ");
        String hoDem = sc.nextLine();

        System.out.println("Nhập tên: ");
        String ten = sc.nextLine();

        System.out.println("Nhập ngày sinh: ");
        String ngaySinh = sc.nextLine();

        System.out.println("Nhập giới tính: ");
        String gioiTinh = sc.nextLine();

        SinhVien sinhVien = new SinhVien(maSinhVien, hoDem, ten, ngaySinh, gioiTinh);

        sinhVienController.add(sinhVien);

        actionSinhVien();
    }

    public static void editSinhVien() {
        System.out.println("Nhập mã sinh viên muốn sửa: ");
        String maSinhVien = sc.nextLine();

        SinhVien sinhVien = sinhVienController.getByMaSinhVien(maSinhVien);

        if (sinhVien == null) {
            System.out.println("Mã sinh viên không tồn tại");
            return;
        }

        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.format("│ Mã Sinh Vien │      Họ tên              │     Ngày sinh    │ Giới tính │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("│ "+sinhVien.getMaSinhVien()+"            │ "+sinhVien.getHoDem()+" "+sinhVien.getTen()+"           │ "+sinhVien.getNgaySinh()+"       │ "+sinhVien.getGioiTinh()+"         │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");

        System.out.println("Nhập họ & tên đệm: ");
        String hoDem = sc.nextLine();

        System.out.println("Nhập tên: ");
        String ten = sc.nextLine();

        System.out.println("Nhập ngày sinh: ");
        String ngaySinh = sc.nextLine();

        System.out.println("Nhập giới tính: ");
        String gioiTinh = sc.nextLine();

        SinhVien sv = new SinhVien(maSinhVien, hoDem, ten, ngaySinh, gioiTinh);

        sinhVienController.edit(sv);

        actionSinhVien();
    }

    public static void deleteSinhVien() {
        System.out.println("Nhập mã sinh viên muốn xóa: ");
        String maSinhVien = sc.nextLine();

        sinhVienController.delete(maSinhVien);
    }

    public static void getAllSinhVien() {

        List<SinhVien> sinhViens = sinhVienController.getAll(PAGE, SIZE, TOTAL_RECORDS);

        sinhViens.sort(new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getTen().compareTo(sv2.getTen());
            }
        });

        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ Mã Sinh Viên │      Họ tên              │     Ngày sinh    │ Giới tính │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        for (SinhVien sinhVien : sinhViens) {
            System.out.format("│%-14s│", sinhVien.getMaSinhVien());
            System.out.format("%-26s│", sinhVien.getHoDem() + " " + sinhVien.getTen());
            System.out.format("%-18s│", sinhVien.getNgaySinh());
            System.out.format("%-11s│", sinhVien.getGioiTinh());
            System.out.println("");
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("Trang: "+ (PAGE + 1) + " / " + TOTAL_PAGE + " │ Tổng số " + TOTAL_RECORDS + " bản ghi.");
        if (PAGE + 1 != TOTAL_PAGE) {
            System.out.println("1. Xem trang tiếp theo");
            System.out.println("2. Đến trang cuối");
        }
        System.out.println("3. Xem trang cụ thể");
        System.out.println("4. Trở lại trang trước");
        System.out.println("5. Đến trang đầu");
        System.out.println("6. Quay lại");
        System.out.println("Chọn chức năng: ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                if (PAGE + 1 == TOTAL_PAGE) {
                    break;
                }
                nextPage();
                break;
            case 2:
                goToLastPage();
                break;
            case 3:
                goToDetailPage();
                break;
            case 4:
                previousPage();
                break;
            case 5:
                goToFirstPage();
                break;
            case 6:
                PAGE = 0;
                actionSinhVien();
                break;
            default:
                break;
        }
    }

    public static void getByMaSinhVien() {

        System.out.println("Nhập mã sinh viên muốn tìm kiếm: ");
        String maSinhVien = sc.next();

        SinhVien sinhVien = sinhVienController.getByMaSinhVien(maSinhVien);

        if (sinhVien == null) {
            System.out.println("Mã sinh viên không tồn tại");
            return;
        }

        List<Diem> diems = diemController.getAllDiemByMaSinhVien(sinhVien.getMaSinhVien());

        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ Mã Sinh Viên │      Họ tên              │     Ngày sinh    │ Giới tính │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.format("│%-14s│", sinhVien.getMaSinhVien());
        System.out.format("%-26s│", sinhVien.getHoDem() + " " + sinhVien.getTen());
        System.out.format("%-18s│", sinhVien.getNgaySinh());
        System.out.format("%-11s│", sinhVien.getGioiTinh());
        System.out.println("");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("0. Quay lại");
        System.out.println("1. Xem bảng điểm");
        System.out.println("Chọn chức năng: ");
        int option = sc.nextInt();
        if (option == 0) {
            actionSinhVien();
        }

        if (option == 1) {
            showBangDiem(sinhVien, diems);
        }
    }

    public static List<SinhVien> readSinhVienFile() throws IOException {
        List<SinhVien> sinhVienList = new ArrayList<>();

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/datas/sinhvien.txt"));
        String line;
        boolean firstLine = true;
        while ((line = bufferedReader.readLine()) != null) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] data = line.split(";");
            String maSinhVien = data[0];
            String hoDem = data[1];
            String ten = data[2];
            String ngaySinh = data[3];
            String gioiTinh = data[4];
            SinhVien sinhVien = new SinhVien(maSinhVien, hoDem, ten, ngaySinh, gioiTinh);
            sinhVienList.add(sinhVien);
        }

        return sinhVienList;
    }

    public static void nextPage() {
        PAGE = PAGE + 1;
        getAllSinhVien();
    }

    public static void previousPage() {
        PAGE = PAGE - 1;
        getAllSinhVien();
    }

    public static void goToFirstPage() {
        PAGE = 0;
        getAllSinhVien();
    }

    public static void goToDetailPage() {
        System.out.println("Nhập trang muốn xem: ");
        int page = sc.nextInt();
        if (page > TOTAL_PAGE) {
            System.out.println("Không có trang này");
            return;
        }
        if (page < 0) {
            System.out.println("Không có trang này");
            return;
        }
        PAGE = page - 1;
        getAllSinhVien();
    }

    public static void goToLastPage() {
        PAGE = TOTAL_RECORDS / SIZE;
        getAllSinhVien();
    }

    public static void actionMonHoc() {
        int optionMonHoc = 0;

        System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                Môn học                                 │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("│\t 1. Hiển thị danh sach                                               │");
        System.out.println("│\t 2. Quay lại                                                         │");
        System.out.println("└────────────────────────────────────────────────────────────────────────┘");
        System.out.println("Lựa chọn: ");
        optionMonHoc = sc.nextInt();

        if (optionMonHoc == 1) {
            getAllMonHoc();
        }

        if (optionMonHoc == 2) {
            mainMenu();
        }
    }

    public static void getAllMonHoc() {
        List<MonHoc> monHocs = monHocController.getAll();

        monHocs.sort(new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return o1.getTenMonHoc().compareTo(o2.getTenMonHoc());
            }
        });

        System.out.println("┌───────────────────────────────────────────────────────────┐");
        System.out.println("│ Mã môn học │      Tên môn học              │     Hệ số    │");
        System.out.println("└───────────────────────────────────────────────────────────┘");
        for (MonHoc monHoc : monHocs) {
            System.out.format("│%-12s│", monHoc.getMaMonHoc());
            System.out.format("%-31s│", monHoc.getTenMonHoc());
            System.out.format("%-14s│", monHoc.getHeSo());
            System.out.println("");
        }
        System.out.println("└───────────────────────────────────────────────────────────┘");
        System.out.println("1. Quay lại");
        System.out.println("Chọn chức năng: ");
        int option = sc.nextInt();
        if (option == 1) {
            actionMonHoc();
        }
    }

    public static List<MonHoc> readMonHocFile() throws IOException {
        List<MonHoc> monHocList = new ArrayList<>();

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/datas/monhoc.txt"));
        String line;
        boolean firstLine = true;
        while ((line = bufferedReader.readLine()) != null) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] data = line.split(";");
            String maMonHoc = data[0];
            String tenMonHoc = data[1];
            String heSo = data[2];
            MonHoc monHoc = new MonHoc(maMonHoc, tenMonHoc, Float.parseFloat(heSo));
            monHocList.add(monHoc);
        }

        return monHocList;
    }

    public static List<Diem> readDiemFile() throws IOException {
        List<Diem> diems = new ArrayList<>();

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/datas/diem.txt"));
        String line;
        boolean firstLine = true;
        while ((line = bufferedReader.readLine()) != null) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] data = line.split(";");
            String maSinhVien = data[0];
            String maMonHoc = data[1];
            String diemSo = data[2];
            Diem diem = new Diem(maSinhVien, maMonHoc, Float.parseFloat(diemSo));
            diems.add(diem);
        }

        return diems;
    }

    public static void showBangDiem(SinhVien sinhVien, List<Diem> diems) {
        System.out.println(diems);
        float sum = 0.0f;

        List<String> tenMonHoc = new ArrayList<>();

        for (Diem diem : diems) {
            sum += diem.getDiemSo();
            MonHoc monHoc = monHocController.getByMaMonHoc(diem.getMaMonHoc());
            tenMonHoc.add(monHoc.getTenMonHoc());
        }

        System.out.println("┌───────────────────────────────────────────────────────────┐");
        System.out.format("│Mã sinh viên: %-10s│", sinhVien.getMaSinhVien());
        System.out.format("%-30s│", sinhVien.getHoDem() + " " + sinhVien.getTen());
        System.out.format("%-17s│", sinhVien.getNgaySinh());
        System.out.println("");
        System.out.println("└───────────────────────────────────────────────────────────┘");
        System.out.format("│%s", "Điểm tổng kết");
        System.out.format("%-41s%-5s│", "", diems.size() == 0 ? "0" : (float)sum / diems.size());
        System.out.println("");
        System.out.println("└───────────────────────────────────────────────────────────┘");
        if (diems.size() == 0) {
            System.out.format("│%-40s|", "Sinh viên chưa có điểm môn nào");
        } else {
            for (int i = 0; i < diems.size(); i++) {
                Diem diem = diems.get(i);
                System.out.format("│%-5s %-5s %-5s", diem.getMaMonHoc(), tenMonHoc.get(i), diem.getDiemSo());
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("└───────────────────────────────────────────────────────────┘");
        System.out.println("1. Quay lại");
        System.out.println("Chọn chức năng: ");
        int option = sc.nextInt();
        if (option == 1) {
            actionSinhVien();
        }
    }
}
