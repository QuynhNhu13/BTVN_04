package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.SinhVien;

public class Main {

    public static void main(String[] args) {
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("_____MENU_____");
            System.out.println("1. Them sinh vien vao trong lop hoc.");
            System.out.println("2. Xoa sinh vien khoi lop hoc.");
            System.out.println("3. In thong tin sinh vien.");
            System.out.println("4. Sua thong tin sinh vien theo ma so sinh vien.");
            System.out.println("5. In ra thong tin toan bo sinh vien nam.");
            System.out.println("6. In ra thong tin toan bo sinh vien nu.");
            System.out.println("0. Thoat!!!");
            System.out.println("Nhap vao lua chon cua ban!!!");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addSinhVien(listSinhVien, sc);
                    break;
                case 2:
                    removeSinhVien(listSinhVien, sc);
                    break;
                case 3:
                    printAllSinhVien(listSinhVien);
                    break;
                case 4:
                    editSinhVien(listSinhVien, sc);
                    break;
                case 5:
                    printSinhVienNamNu(listSinhVien, "Nam");
                    break;
                case 6:
                    printSinhVienNamNu(listSinhVien, "Nu");
                    break;
                case 0:
                    System.out.println("Ban da thoat khoi menu!!!");
                    break;
                default:
                    System.out.println("Lua chon cua ban khong hop le!!!");
                    break;

            }

        } while (choice != 0);
    }

    public static void addSinhVien(ArrayList<SinhVien> listSinhVien, Scanner sc) {
        System.out.println("NHAP THONG TIN SINH VIEN:");
        System.out.print("ID: ");
        String id = sc.nextLine();
        for (SinhVien i : listSinhVien) {
            if (i.getId().equals(id)) {
                System.out.println("ID da ton tai trong danh sach!!!");
                return;

            }
        }
        System.out.print("Ho va Ten: ");
        String name = sc.nextLine();
        String gender;
        do {
            System.out.print("Gioi tinh: ");
            gender = sc.nextLine().toLowerCase();
            if(!gender.equals("nam") && !gender.equals("nu")){
                System.out.println("Vui long nhap gioi tinh la 'Nam' hoac 'Nu'.");
            }
        } while (!gender.equals("nam") && !gender.equals("nu"));
        System.out.print("Chuyen nghanh: ");
        String major = sc.nextLine();

        listSinhVien.add(new SinhVien(id, name, gender, major));
        System.out.println("SINH VIEN DA DUOC THEM VAO THANH CONG!!!");
    }

    public static void removeSinhVien(ArrayList<SinhVien> listSinhVien, Scanner sc) {
        System.out.println("Nhap ID cua sinh vien can xoa: ");
        String id = sc.nextLine();
        boolean find = false;
        for (SinhVien i : listSinhVien) {
            if (i.getId().equals(id)) {
                listSinhVien.remove(i);
                find = true;
                System.out.println("SINH VIEN DA DUOC XOA KHOI DANH SACH THANH CONG!!!");
                break;
            }
        }
        if (!find) {
            System.out.println("KHONG TIM THAY SINH VIEN CO ID LA: " + id);
        }
    }

    public static void printAllSinhVien(ArrayList<SinhVien> listSinhVien) {
        System.out.println("THONG TIN TOAN BO SINH VIEN:");
        for (SinhVien i : listSinhVien) {
            System.out.println(i.toString());
        }
    }

    public static void editSinhVien(ArrayList<SinhVien> listSinhVien, Scanner sc) {
        System.out.println("Nhap ID cua sinh vien can sua: ");
        String id = sc.nextLine();
        boolean find = false;
        for (SinhVien i : listSinhVien) {
            if (i.getId().equals(id)) {
                System.out.print("Ho va Ten: ");
                String name = sc.nextLine();
                System.out.print("Gioi tinh: ");
                String gender = sc.nextLine();
                System.out.print("Chuyen nghanh: ");
                String major = sc.nextLine();

                i.setName(name);
                i.setGender(gender);
                i.setMajor(major);
                find = true;
                System.out.println("THONG TIN CUA SINH VIEN DA DUOC THAY DOI!!!");
                break;
            }
        }
        if (!find) {
            System.out.println("KHONG TIM THAY SINH VIEN CO ID LA " + id);
        }
    }

    public static void printSinhVienNamNu(ArrayList<SinhVien> listSinhVien, String gender) {
        System.out.println("Thong tin sinh vien co gioi tinh " + gender + ":");
        for (SinhVien i : listSinhVien) {
            if (i.getGender().equalsIgnoreCase(gender)) {
                System.out.println(i.toString());
            }
        }
    }

}
