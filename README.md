# Emarket
Bài tập lớn CNPM 20191 nhóm 03
1.Giới thiệu project
  Emarket là 1 web application với chức năng của 1 website thương mại điện tử.
  Các chức năng của web gồm có:
    +Trưng bày sản phẩm
    +Đăng ký tài khoản người dùng, đăng nhập, đăng xuất.
    +Xem thông tin sản phẩm, thêm sản phẩm vào giỏ hàng,mua hàng.
    +Đối với admin có thể thêm sản phẩm, xóa người dùng,xác nhận đơn hàng.
2.Công nghệ sử dụng
  +Frontend: html,css,bosstrap 3
  +Backend: sử dụng Java Web với jsp servlet 
  +Database: SQL server
3.Cách cài đặt
  Sử dụng netBean để mở project
  Chọn Resolve Reference Problems để import lại 2 thư viện javax.mail và sqljdbc4 vào project
  Backup database cnpm với file backup "cnpm.bak" trong sql server
  Vào source packages chọn class dao.DBConnect.java, cấu hình lại dbURL theo sql server đang có trên máy
  Run project
