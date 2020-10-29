package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		int affectedRows = 0;
		Connection conn = connection.getConnection();
		String query = "UPDATE NhanVien \n" + "SET TaiKhoan =?, \n" + "MatKhau= ? \n" + "WHERE MaNV=? \n";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, sqlUtils.md5Hex(password));
			pst.setInt(3, staffId);
			affectedRows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(pst, conn);
		}
		if (affectedRows != 0) {
			return true;
		}
		return false;
	}

}
