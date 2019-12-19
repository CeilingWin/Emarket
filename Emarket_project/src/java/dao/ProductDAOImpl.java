package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(Product p) {
            List<Product> list = getList();
            int x = list.size() + 1;
		Connection con = DBConnect.getConnecttion();
		String sql = "insert into product(ten_san_pham,hinh_anh,gia_ban,hang_san_xuat,thong_tin,ma_the_loai,ma_san_pham) values(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, p.getTen_san_pham());
			ps.setString(2, p.getHinh_anh());
			ps.setDouble(3, p.getGia_ban());
			ps.setString(4, p.getHang_san_xuat());
			ps.setString(5, p.getThong_tin());
                        ps.setInt(6, p.getMa_the_loai());
                         ps.setInt(7, x);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getList() {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from product";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> getListByCategory(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from product where ma_the_loai='" + id + "'";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProduct(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from product where ma_san_pham='" + id + "'";
		Product p = new Product();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				p = new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public static void main(String[] args) {
		Product p = new Product(0, 1, "S6", "da", 500000.0 ,"","");
		ProductDAOImpl productDAO = new ProductDAOImpl();
		// productDAO.addProduct(p);
		// System.out.println(productDAO.getList());
		System.out.println(productDAO.getListByCategory(1));
	}

	@Override
	public List<Product> searchList(String ten_san_pham, String ten_the_loai) {
		Connection con = DBConnect.getConnecttion();
		String sql=null;
		if(!ten_san_pham.equals("") && !ten_the_loai.equals("")){
			sql = "SELECT * FROM product, category WHERE ten_san_pham= N'"+ ten_san_pham +"' AND product.ma_the_loai = category.ma_the_loai AND ten_the_loai=N'"+ten_the_loai+"'";
		}else{
			if(ten_san_pham.equals("")){
				sql="SELECT * FROM product, category WHERE product.ma_the_loai = category.ma_the_loai AND ten_the_loai=N'"+ten_the_loai+"'";
			}else{
				if(ten_the_loai.equals("")){
					sql="SELECT * FROM product, category WHERE ten_san_pham= N'"+ten_san_pham+"' AND product.ma_the_loai = category.ma_the_loai";
				}
			}
		}
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	
	}
}
