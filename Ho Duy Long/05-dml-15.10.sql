-- disable fk
set foreign_key_checks = 0;

-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
select * from nhanvien;
delete from nhanvien
where HoTen like '%Văn Hoàng%';
-- 2. Xóa bộ phận giao hàng trong hệ thống
   -- . NO ACTION
   -- . CASCADE
select * from phongban;
delete from phongban
where MaPB = 4;
-- 3. Xóa tất cả các mặt hàng có mã loại bằng 4
select * from mathang;
delete from mathang
where MaLoai = 4;
-- 4. Xóa tất cả các mặt hàng trong hệ thống
delete from mathang;
-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
select * from donhang;
delete from donhang
where NgayDatHang = str_to_date('23-11-2019', '%d-%m-%Y');

-- C. UPDATE
-- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
select * from phongban;
update phongban
set TenPB = 'Bộ phận quản lý'
where MaPB = 2;
-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
select * from donhang; 
alter table donhang
add GhiChu text;
update donhang
set GhiChu = 'Giao hàng sau 10h sáng'
where MaDH = 1;
-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật 
   -- MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
select * from ttdh;
select * from giaohang;
insert into giaohang(MaDH, MaTTDH, ThoiGian)
values(1, 5, current_timestamp());
-- 4. Cập nhật tổng tiền trong bảng hóa đơn thành 890 cho đơn hàng 01
select * from hoadon;
select * from xulydonhang;
insert into hoadon(MaHD, NgayXuat, PhiVanChuyen, TongTien, MaDH)
with TongTien_CTE as (
	select xldh.MaDH, SUM(mh.GiaBan*xldh.SoLuong) TongTien
    from xulydonhang xldh
    join mathang mh on xldh.MaMH = mh.MaMH
    where xldh.MaDH = 1
)
select 1,
		current_timestamp(),
        10,
        cte.TongTien,
        dh.MaDH
from donhang dh
join TongTien_CTE cte on dh.MaDH = cte.MaDH
where dh.MaDH = 1;

use java07_shopping;

-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
select * from mathang;
select * from loaihang;
update mathang
set GiaBan = 190
where MaLoai = (select MaLoai from loaihang
				where TenLoai like '%Mũ%');
                
-- SELECT 
-- Top 5 mặt hàng có giá bán cao nhất
select * from mathang
order by GiaBan desc
limit 0, 5;
-- Được bán trong ngày 28/11/2019
select * from donhang 
where NgayDatHang = str_to_date('28/11/2019', '%d-%m-%Y');
-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019

-- Được bán trong tháng 11/2019
select * from donhang 
where month(NgayDatHang) = 11
and year(NgayDatHang) = 2020;
-- Được giao hàng tại Hòa Khánh

-- Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
select GiaBan, cast(GiaBan * 0.8 as signed) GiaKhuyenMai
from mathang;
-- Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
select GiaBan, cast(GiaBan * 0.8 as signed) GiaKhuyenMai
from mathang
where current_date() = '2020-10-18';
-- Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
select distinct MauSac from mathang;
-- Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
select mh.MaMH, mh.TenMH, dh.NgayDatHang
from mathang mh
join xulydonhang xldh on mh.MaMH = xldh.MaMH
join donhang dh on xldh.MaDH = dh.MaDH and dh.NgayDatHang = '2020-11-17';
-- Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
	-- C1:
select * from mathang mh
join loaihang lh on mh.MaLoai = lh.MaLoai
where lh.TenLoai like '%Mũ%' || lh.TenLoai like '%Thắt lưng%';
	-- C2:
select *
from mathang
where MaLoai in (select MaLoai
				from loaihang
                where TenLoai like '%Mũ%' || TenLoai like '%Thắt lưng%');
-- Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
select * from mathang
order by GiaBan ASC, GiaMua DESC;
-- Đếm số lượng các mặt hàng trong hệ thống
-- count(*)
-- count(column): not null
-- count(distinct column): unique - not null
select count(distinct MauSac) from mathang;

-- SELECT GROUP BY - HAVING
-- Đếm số lượng các mặt hàng theo từng loại hàng
select lh.MaLoai, lh.TenLoai, count(*) SoLuong
from mathang mh
join loaihang lh on mh.MaLoai = lh.MaLoai
group by lh.MaLoai, lh.TenLoai
having SoLuong >= 2;
-- Tìm giá bán cao nhất của các mặt hàng trong loại hàng 'Áo'
with MAX_COST as (
	select max(GiaBan) cost
	from mathang 
	where MaLoai = (select MaLoai
					from loaihang
					where TenLoai like '%Áo%')
)
select * from mathang 
where GiaBan = (select cost from MAX_COST);
-- Tìm giá bán cao nhất của mỗi loại hàng
select MaLoai, max(GiaBan) MaxPrice
from mathang 
group by MaLoai;
-- Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
select MaLoai, sum(SoLuong) Quantity
from mathang 
group by MaLoai
having SoLuongLoaiHang >= 80;
-- Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
with MaxItems as (
	select MaLoai, max(SoLuong) SoLuong
    from mathang
    group by MaLoai
)
select mh.MaLoai, mh.TenMH, mi.SoLuong 
from mathang mh
join MaxItems mi
on mh.MaLoai = mi.MaLoai and mh.SoLuong = mi.SoLuong;
-- Hiển thị giá bán trung bình của mỗi loại hàng
select MaLoai, cast(avg(GiaBan) as signed) AvgPrice
from mathang
group by MaLoai;
-- In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
select MaLoai, sum(SoLuong) Quantity
from mathang
group by MaLoai
order by Quantity desc
limit 0, 3;


-- xxxxxxxxxxxxxx
select * 
from mathang mh
where exists (select *
				from loaihang lh
                where lh.MaLoai = mh.MaLoai
                and (lh.TenLoai like '%Mũ%' or lh.TenLoai like '%Áo%'));







