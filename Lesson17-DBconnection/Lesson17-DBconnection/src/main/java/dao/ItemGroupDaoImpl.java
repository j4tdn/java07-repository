package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.ItemGroup;

public class ItemGroupDaoImpl implements ItemGroupDao {

	private final ConnectionManager connection;
	private Statement st;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = new ConnectionManagerImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> itemGroups = new ArrayList<ItemGroup>();
		Connection conn = connection.getConnection();
		String query = "SELECT * FROM LoaiHang";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MatHang"));
				itemGroups.add(itemGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}

		return itemGroups;
	}

	@Override
	public List<ItemGroup> get(String name) {
		List<ItemGroup> itemGroups = new ArrayList<ItemGroup>();
		Connection conn = connection.getConnection();
		String query = "SELECT *" 
					+ "FROM LoaiHang"
					+ "WHERE TenLoai = '" + name + "'";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MatHang"));
				itemGroups.add(itemGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}

		return itemGroups;
	}
	
	@Override
	public ItemGroup get(int id) {
		ItemGroup itemGroups = null;
		Connection conn = connection.getConnection();
		String query = "SELECT *"
				+ "FROM LoaiHang"
				+ "WHERE Maloai = " + id;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				itemGroup = new ItemGroup(rs.getInt("Maloai"), rs.getInt("Tenloai"));
				itemGroups.add(itemGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		
		return itemGroups;
	}

	private <T extends AutoCloseable> void close(T... closedElements) {
		Arrays.stream(closedElements).forEach(elements -> {
			if (elements != null) {
				try {
					elements.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
