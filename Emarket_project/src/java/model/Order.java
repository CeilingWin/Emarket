/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class Order {
    private int id_order;
	private int user_id;
	private int ma_san_pham;
	private Timestamp ngay_mua;
	private int so_luong;
	private double thanh_tien;
        private int trangthai;
	
	public Order() {
	}

    public Order(int user_id, int ma_san_pham, Timestamp ngay_mua, int so_luong, double thanh_tien, int trangthai) {
        this.user_id = user_id;
        this.ma_san_pham = ma_san_pham;
        this.ngay_mua = ngay_mua;
        this.so_luong = so_luong;
        this.thanh_tien = thanh_tien;
        this.trangthai = trangthai;
    }

        
    public Order(int id_order, int user_id, int ma_san_pham, Timestamp ngay_mua, int so_luong, double thanh_tien, int trangthai) {
        this.id_order = id_order;
        this.user_id = user_id;
        this.ma_san_pham = ma_san_pham;
        this.ngay_mua = ngay_mua;
        this.so_luong = so_luong;
        this.thanh_tien = thanh_tien;
        this.trangthai = trangthai;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public Timestamp getNgay_mua() {
        return ngay_mua;
    }

    public void setNgay_mua(Timestamp ngay_mua) {
        this.ngay_mua = ngay_mua;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(double thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
        
        
}

    