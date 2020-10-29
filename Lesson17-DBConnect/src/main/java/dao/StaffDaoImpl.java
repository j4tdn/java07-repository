package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
		int affectedRows = 0;
		Connection con = connection.getConnection();
		String query = "UPDATE nhanvien SET TaiKhoan = ? , MatKhau = ? WHERE MaNV = ?";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, SqlUtils.md5Hex(password));
			pst.setInt(3, staffId);
			affectedRows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst, con);
		}
		if (affectedRows != 0) {
			return true;
		}
		return false;
	}

}