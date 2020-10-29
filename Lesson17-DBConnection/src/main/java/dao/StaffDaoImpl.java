package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import utils.SqlUtils;

public class StaffDaoImpl implements StaffDao{
	
	private final ConnectionManager connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public StaffDaoImpl() {
		connection = new ConnectionManagerImpl();
	}

	@Override
	public boolean updateAcount(Integer staffId, String username, String password) {
		Connection conn = connection.getConnection();
		int affectedRows = 0;
		String query = "UPDATE NHANVIEN \n"
				+ "SET TaiKhoan = ?, \n"
				+ "MatKhau = ? \n"
				+ "WHERE MaNV = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, SqlUtils.md5Hex(password));
			pst.setInt(3, staffId);
			affectedRows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst, conn);
		}
		
		return affectedRows > 0;
	}

}
