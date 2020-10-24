-- liệt ke mat hang 
use java07_Shopping ;

DELIMITER $$
drop procedure if exists getItems;

create procedure getItems(catId int)
begin
	select MaLoai, 
		   gruop_concat(TenMH separator '-') DanhSachMatHang
	from MatHang
	Where MaLoai = catId;
end $$
DELIMITER ;
call getItems(1)

-- p2
DELIMITER $$
-- drop procedure if exists getItems;

create procedure operate(a int , b int)
begin
	declare result int;
    set result = a + b;
    select a, b, result as sum;
end $$
DELIMITER ;
call operate(2, 3)
 -- p3  liet ke các phần tử chẵn bé hơn n
 
 DELIMITER $$
	create procedure getEvenNumber(n int)
	begin
		declare i int DEFAULT 0 ;
        declare result   varchar(255) DEFAULT "";
        -- loop điều kiện dừng
		simple_lable:Loop
			if (i >= n) then
				leave simple_lable;
            end if;
            if  (i mod 2 = 0  ) then
				set result = concat(result,i, " ") ; -- hoĂC dung concat(result, i ," ")
            end if;
            	set i = i + 1;
         end loop;
        select result;
    end $$
 DELIMITER ;
 call getEvenNumber(20);
 
 -- using while
  DELIMITER $$
	create procedure getOddNumber1(n int)
	begin
		declare digits int DEFAULT 0 ;
        declare result   varchar(255) DEFAULT "";
        while (digits > n) do
			if (digits mod 2 != 0) then
				set result = concat(result,digits," ");
            end if;
			set digits = digits + 1;
        end while;
        select result;
    end $$
 DELIMITER ;
 call getOddNumber1(10);


  
DELIMITER $$
	create procedure addDataInToLoaiHang(numBerOfRow int)
	begin
			declare rowIndex int DEFAULT 10;
			while rowIndex < numBerOfRow do
				insert into LoaiHang(Maloai, TenLoai)
				values(rowIndex, concat("XYZ",rowIndex));
				set rowIndex = rowIndex + 1;
			end while;
		end $$
 DELIMITER ;
 call addDataInToLoaiHang(13)