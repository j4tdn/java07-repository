package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.codec.digest.DigestUtils;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import utils.sqlUtils;

public class StaffDaoImpl implements StaffDao {
	private final ConnectionManager connection;
	private PreparedStatement pst;
	private ResultSet rs;

	public StaffDaoImpl() {
		connection = new ConnectionManagerImpl();
	}

	@Override
	public boolean updateAcount(Integer staffId, String username, String password) {
		int affectedRow = 0;
		Connection conn = connection.getConnection();
		String query = "update NhanVien \n"
				+"Set TaiKhoan = ?, \n"
				+"MatKhau = ? \n"
				+ "Where MaNV = ?";
		try {
			pst =  conn.prepareStatement(query);
			pst.setString(1,username);
			pst.setString(2, sqlUtils.md5Heax(password));
			pst.setInt(3, staffId);
			affectedRow = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			sqlUtils.close(pst,conn);
		}
		
		return affectedRow > 0;
	}

}
