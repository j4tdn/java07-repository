use java07_shopping;

drop procedure if exists getItems;

DELIMITER $$
create procedure getItems(catId int) 

begin 
	select MaLoai, 
    group_concat(TenMH separator ' - ') DanhSachMatHang
    from mathang
    where MaLoai = catId;
end $$

DELIMITER ;

call getItems(2);

-- P2
DELIMITER $$
create procedure operate(a int, b int) 
begin
	declare result int;
    set result = a + b;
    select a, b, result;
end $$

DELIMITER ;

call operate(2, 7);

drop procedure if exists getEvenNumbers;

-- P3: liet ke cac phan tu chan < n
DELIMITER $$
create procedure getEvenNumbers(n int)
begin
	declare i int default 0;
    declare result varchar(255) default "";
    
    simple_label: loop
		if (i >= n) then
			leave simple_label;
		end if;
        
        if (i mod 2 = 0) then
			set result = concat(result, i, " ");
		end if;
        
        set i = i + 1;
    end loop;
    
    select result;
end $$

DELIMITER ;
call getEvenNumbers(30);

-- Using while
DELIMITER $$
create procedure getOddNumbers(n int)
begin
	declare i int default 0;
    declare result varchar(255) default "";
    
    while i < n do 
		if (i mod 2 != 0) then
			set result = concat(result, i, " ");
        end if;
        set i = i + 1;
    end while;
    
    select result;
end $$

DELIMITER ;

call getOddNumbers(10);

-- insert data
DELIMITER $$
create procedure addDataIntoLoaiHang(numberOfRows int)
begin 
	declare rowIndex int default 10;
	while rowIndex < numberOfRows do
		insert into LoaiHang(MaLoai, TenLoai)
		values (rowIndex, concat("XYZ", rowIndex));
		set rowIndex = rowIndex + 1;
    end while;
end $$
DELIMITER ;

call addDataIntoLoaiHang(13);

select * from loaihang;





















