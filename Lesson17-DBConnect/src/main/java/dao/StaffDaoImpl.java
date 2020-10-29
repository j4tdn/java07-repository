package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import ultils.SqlUltils;

public class StaffDaoImpl implements StaffDao {
	private final ConnectionManager connection;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;

	public StaffDaoImpl() {
		connection = new ConnectionManagerImpl();
	}
	@Override
	public boolean updateAccount(Integer staffId, String username, String password) {
		int aff=0;
		Connection conn = connection.getConnection();
		String sql ="update nhanvien "
				+ "set taikhoan = ?, matkhau = ? "
				+ "where manv = ?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, SqlUltils.md5Hex(password));
			pst.setInt(3, staffId);
			aff= pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUltils.close(pst,conn);
		}
		return aff>0;
	}

}
