package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.ItemGroup;

public class ItemGroupDaoImpl implements ItemGroupDao{

	private final ConnectionManager connection;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = new ConnectionManagerImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> itemGroups = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "SELECT * FROM LoaiHang";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				itemGroups.add(itemGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return itemGroups;
	}

	public List<ItemGroup> get(String name) {
		List<ItemGroup> itemGroups = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "SELECT * \n" 
					+ "FROM LoaiHang \n" 
					+ "WHERE TenLoai LIKE ?";
		System.out.println("SQL" + query);
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "%" +name + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				itemGroups.add(itemGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return itemGroups;
	}

	public ItemGroup get(int id) {
		ItemGroup itemGroup = null;
		Connection conn = connection.getConnection();
		String query = "SELECT *\n" + "FROM LoaiHang\n" + "WHERE MaLoai =" + id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return itemGroup;
	}

	private <T extends AutoCloseable> void close(T... closedElement) {
		Arrays.stream(closedElement).forEach(element -> {
			if (element != null) {
				try {
					element.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
