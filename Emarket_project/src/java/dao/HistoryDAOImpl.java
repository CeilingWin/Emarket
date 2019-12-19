package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import model.Category;
import model.History;

public class HistoryDAOImpl implements HistoryDAO {

    public HistoryDAOImpl() {
    }
    
	@Override
	public void addHistory(History h) {
		Connection con = DBConnect.getConnecttion();
		String sql = "insert into history(user_id,ma_san_pham,ngay_mua,so_luong,thanh_tien) values(?,?,?,?,?)";
		PreparedStatement ps;

		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, h.getUser_id());
			ps.setInt(2, h.getMa_san_pham());
			ps.setTimestamp(3, h.getNgay_mua());
			ps.setInt(4, h.getSo_luong());
			ps.setDouble(5, h.getThanh_tien());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<History> getList(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from history where user_id='"+ id +"'";
		List<History> list = new ArrayList<History>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_history = rs.getInt("id_history");
				int user_id = rs.getInt("user_id");
				int ma_san_pham = rs.getInt("ma_san_pham");
                                Date ngay_mua_tmp=rs.getDate("ngay_mua");
				Timestamp ngay_mua = new Timestamp(ngay_mua_tmp.getTime());
				int so_luong = rs.getInt("so_luong");
				double thanh_tien = rs.getDouble("thanh_tien");
				list.add(new History(id_history, user_id, ma_san_pham, ngay_mua, so_luong, thanh_tien));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
        public static void main(String[] args) {
        List<History> historys=new HistoryDAOImpl().getList(2);
            for (History history : historys) {
                System.out.println(history.getNgay_mua());
            }
    }
	
}
