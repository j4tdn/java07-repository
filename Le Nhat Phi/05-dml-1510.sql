use java07_Shopping ;
-- disable fk
set foreign_key_checks = 0;
delete from loaihang;
set foreign_key_checks = 1;
-- Delete :DML => able to rollback
-- truncate ddl => unnable

-- index
-- partiton
-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
-- 2. Xóa bộ phận giao hàng trong hệ thống
--   . NO ACTION
--   . CASCADE
-- 3. Xóa tất cả các mặt hàng có mã loại bằng 4
-- 4. Xóa tất cả các mặt hàng trong hệ thống
-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
-- 1

select *from phongban;
delete  from nhanvien  
where hoten like '%Văn Hoàng%';
-- 2
set foreign_key_checks = 0;
delete from phongban
where Mapb = 4;
set foreign_key_checks = 1;

-- 3
delete 
from mathang 
where Maloai = 4;
-- 4
delete from mathang;
-- 5
delete 
from donhang 
where NgayDathang = STR_TO_DATE('22-11-2019','%d-%m-%Y');

-- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
update phongban
set TenPB = 'Bộ Phận Quản Lý'
where MaPB = 2;
-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'

alter table donhang 
add ghichu Text;

select *from donhang;
update donhang
set ghichu = 'Giao Hàng sau 10h sáng'
where MaDH = 01;
-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật  MaTTDH = 03, ThoiGian = Thời gian hiện tại
select *from hoadon;
insert into giaohang(MaDH, MaTTDH, ThoiGian)
value(1,5,current_timestamp());
-- 4. Cập nhật tổng tiền trong bảng hóa đơn thành 890 cho đơn hàng 01

insert into hoadon(MaHD, NgayXuat,  PhiVanChuyen, TongTien, MaDH)
with TongTien_CTE as(
select xldh.MaDH, Sum(mh.GiaBan*xldh.SoLuong) TongTien
From xulydonhang xldh
join mathang mh On xldh.MaMh = mh.MaMH
where xldh.MaDh = 1
)
select 1, current_timestamp() ,10,cte.TongTien,1
from donhang dh
join TongTien_CTE cte on dh.MaDH = cte.MaDH
where dh.MaDH = 1 

-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
update mathang
set GiaBan = 199
where MaLoai = (Select MaLoai from loaihang
				where TenLoai like '%Giày%')

-- D. SELECT - SLIDE 25-44
-- 1. Toàn bộ thông tin các loại hàng
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    -- Top 5 mặt hàng có giá bán cao nhất
    select *
    from mathang mh,loaihang lh
    where mh.MaLoai = lh.MaLoai and lh.TenLoai = 'Thắt Lưng'
    
    select  *from mathang
    ORDER BY GiaBan DESC
    limit 0,5;
    
-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
    select * from donhang
    where NgayDathang = STR_TO_DATE('18-11-2020','%d-%m-%Y'); -- có thể  Y-m-d 
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
  
    select * from donhang
    where NgayDathang between STR_TO_DATE('16-11-2020','%d-%m-%Y') and STR_TO_DATE('18-11-2020','%d-%m-%Y');
    
    -- Được bán trong tháng 11/2019
	-- lấy tháng ra = tháng nớ ko, năm nớ ra = năm nó ko
    select * from donhang
    -- where NgayDathang between '2020-11-1' and '2020-11-30'
    where month(NgayDatHang) = 11 and year(NgayDatHang) = 2020;
    
    -- Được giao hàng tại Hòa Khánh
    select * from donhang
    where DiaChiGIaoHang like '%Hoà Khánh' 
    
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
	select GiaBan ,ROUND(GiaBan * 0.8 , 2) as GiaKhuyenMai 
    from mathang
    
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
	
	select GiaBan ,cast(GiaBan * 0.8 as signed) as GiaKhuyenMai 
    from mathang
    where curdate() = '2020-10-18'
-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
-- distin tránh trùng màu
	select MauSac from mathang
    
-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
-- chưa làm được
	select mh.MaMH, mh.TenMH, dh.NgayDatHang
    from mathang mh
    join xulydonhang xldh on mh.MaMH = xldh.MaMH
    join donhang dh on xldh.MaDH = dh.MaDH
	where dh.NgayDathang = '2020-11-17';
    
-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
	select * from mathang
    where GiaBan between 100 and 300
    
-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
-- like || like 
	select *
    from mathang mh
    join loaihang lh on mh.MaLoai = lh.MaLoai
    where lh.TenLoai in ('Nón','Thắt Lưng')
    
-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
	select * from mathang
    Order by GiaBan DESC
-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
	select * from mathang
    Order by GiaMua ASC
-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần

	select * from mathang
    Order by GiaBan ASC , GiaMua DESC ;
    
-- 14. Đếm số lượng các mặt hàng trong hệ thống
--	count(*) nên
-- count(distinct collum)
-- count (colum)
	select count(MaMH)
    from mathang
-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
	-- chưa làm đực 
    -- select  from joni  where count(tên mặt hàng) trong ngày
    
	select *
	from mathang , xulydonhang , donhang , 
	where mathang.MaMH=xulydonhang.MaMH and donhang.MaDH=xulydonhang.MaMH  and loaihang.MaLoai=mathang.MaLoai and maloai.TenML like '%Nón%'
    
    
-- 1. Đếm số lượng các mặt hàng theo từng loại hàng
	select lh.MaLoai, lh.TenLoai ,Count(*) soluong
    from mathang mh
    join loaihang lh on lh.MaLoai = mh.MaLoai
    group by MaLoai
    having soluong >= 2;
    
-- 2. Tìm giá bán cao nhất của các mặt hàng trong loại hàng 'Mũ'
	With Max_COST as (
		select  max(GiaBan) COST
		from mathang mh
		-- join loaihang lh on lh.MaLoai = mh.TenLoai
		where MaLoai = (select Maloai from loaihang where TenLoai like '%Thắt Lưng%')
    )
    select * from mathang
    where GiaBan = (select COST from Max_COST);
-- 3. Tìm giá bán cao nhất của mỗi loại hàng
	select MaLoai, Max(GiaBan) as maxSale
    from mathang
    group by MaLoai;
    
    
-- 4. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
	select lh.TenLoai, sum(mh.soluong)
    from loaihang lh 
    join mathang mh on mh.MaLoai = lh.MaLoai
    group by TenLoai
-- 5. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống Điều kiện tổng số lượng > 20 mặt hàng
	select lh.TenLoai, sum(mh.soluong)
    from loaihang lh 
    join mathang mh on mh.MaLoai = lh.MaLoai
    group by TenLoai
    having soluong > 20
-- 6. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng

with maxitem as(
	select MaLoai, sum(soluong)
    from mathang
    group by MaLoai
)
	select *
    from MatHang
    join maxitem mi onmh.MaLoai = lh.MaLoai and soluong=soluong
    
    
-- 7. Hiển thị giá bán trung bình của mỗi loại hàng

-- 8. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
	select MaLoai, Sum(SoLuong) SoLuongConLai
    from MatHang
    group by MaLoai
    order by soluongConLai DESC
    limit 3
    
    
    
-- loai hang 1 - áo
-- áo (áo sơ mi nam , áo sơ mi nữ)
	select MaLoai, gruop_concat(TenMH separator '-')
    from MatHang
    Where MaLoai = 1;

-- D2. SELECT UNION - INTERSECT: SLIDE 54 - 56
-- 1. Liệt kê những mặt hàng có MaLoai = 2 và những mặt hàng thuộc đơn hàng 100100

    
    select * 
    from mathang mh
    where exists (select * 
				from loaihang lh 
                where lh.MaLoai = mh.MaLoai and(lh.TenLoai like '%Nón%' or lh.TenLoai like '%Thắt Lưng%'))





	