set Global log_bin_trust_function_creators = 1;
DELIMITER $$
	create function sumDigits(a int , b int)
	returns int
	begin
		return a + b;
	end $$
 DELIMITER ;
 select 5 a, 7 b , sumDigits(5,7) as result;