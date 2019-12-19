/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.History;
import model.Order;

/**
 *
 * @author Admin
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public List<Order> getOrder() {
        Connection con = DBConnect.getConnecttion();
		String sql = "select * from orders ";
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_order = rs.getInt("id_order");
				int user_id = rs.getInt("user_id");
				int ma_san_pham = rs.getInt("ma_san_pham");
                                Date ngay_mua_tmp=rs.getDate("ngay_mua");
				Timestamp ngay_mua = new Timestamp(ngay_mua_tmp.getTime());
				int so_luong = rs.getInt("so_luong");
				double thanh_tien = rs.getDouble("thanh_tien");
                                int trangthai = rs.getInt("trangthai");
				list.add(new Order(id_order, user_id, ma_san_pham, ngay_mua, so_luong, thanh_tien, trangthai));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
    }

    @Override
    public void updateOrder(int id_order, int x) {
         Connection con = DBConnect.getConnecttion();
		String sql = "update orders set trangthai = ? where id_order = ?";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, x);
			ps.setInt(2, id_order);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void addOrder(Order o) {
        Connection con = DBConnect.getConnecttion();
		String sql = "insert into orders(user_id,ma_san_pham,ngay_mua,so_luong,thanh_tien, trangthai) values(?,?,?,?,?,?)";
		PreparedStatement ps;

		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, o.getUser_id());
			ps.setInt(2, o.getMa_san_pham());
			ps.setTimestamp(3, o.getNgay_mua());
			ps.setInt(4, o.getSo_luong());
			ps.setDouble(5, o.getThanh_tien());
                        ps.setInt(6, o.getTrangthai());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
