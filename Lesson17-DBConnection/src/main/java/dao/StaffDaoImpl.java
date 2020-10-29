package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import utils.SqlUtils;

public class StaffDaoImpl implements StaffDao {
	private final ConnectionManager connection;
	private PreparedStatement pst;

	public StaffDaoImpl() {
		connection = new ConnectionManagerImpl();
	}

	@Override
	public boolean updateAccount(Integer staffId, String username, String password) {
		Connection conn = connection.getConnection();
		String query = "update nhanvien set TaiKhoan = ?, MatKhau = ? where MaNV = ?";
		int affectedRows = 0;
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, SqlUtils.md5Hex(password));
			pst.setInt(3, staffId);
			affectedRows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst, conn);
		}
		return (affectedRows > 0);
	}

}
