package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.ItemGroup;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private final ConnectionManager connection;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = new ConnectionManagerImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		Connection conn = connection.getConnection();
		String sql = "select * from loaihang";
		List<ItemGroup> list = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				list.add(new ItemGroup(id, name));
			}

		} catch (SQLException e) {
		} finally {
			close(rs, st, conn);

		}
		return list;
	}

	private <T extends AutoCloseable> void close(T... closedElements) {
		Arrays.stream(closedElements).forEach(el -> {
			if (el != null) {
				try {
					el.close();
				} catch (Exception e) {
				}
			}
		});
	}

	@Override
	public List<ItemGroup> get(String name) {
		Connection conn = connection.getConnection();
		String sql = "select * from loaihang where tenloai =?";
		List<ItemGroup> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name2 = rs.getString(2);
				list.add(new ItemGroup(id, name2));
			}

		} catch (SQLException e) {
		} finally {
			close(rs, st, conn);

		}
		return list;
	}
	
	@Override
	public ItemGroup get(int id) {
		Connection conn = connection.getConnection();
		
		ItemGroup itemGroup = null;
		String sql = "select * from loaihang"
				+ " where maloai ="+id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				itemGroup = new ItemGroup(rs.getInt(1), rs.getString(2));
			}

		} catch (SQLException e) {
		} finally {
			close(rs, st, conn);

		}
		return itemGroup;
	}

}
