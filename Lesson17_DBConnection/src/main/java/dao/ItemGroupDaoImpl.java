package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entity.ItemGroup;

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
		List<ItemGroup> itemGoups = new ArrayList<>();
		Connection con = connection.getConnection();
		String query = "SELECT * FROM donhang";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroup itemGoup = new ItemGroup(rs.getInt("MaDH"), rs.getString("DiaChiGiaoHang"));
				itemGoups.add(itemGoup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, con);
		}
		return itemGoups;
	}

	@Override
	public List<ItemGroup> getName(String name) {
		List<ItemGroup> itemGoups = new ArrayList<>();
		Connection con = connection.getConnection();
		String query = "SELECT *" + "FROM loaihang " + "WHERE TenLoai LIKE ?";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup itemGoup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				itemGoups.add(itemGoup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, con);
		}
		return itemGoups;
	}

	@Override
	public ItemGroup getId(int id) {
		ItemGroup itemGoup = new ItemGroup();
		Connection con = connection.getConnection();
		String query = "SELECT *" + "FROM loaihang " + "WHERE MaLoai = " + id;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				itemGoup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, con);
		}
		return itemGoup;
	}

	private <T extends AutoCloseable> void close(@SuppressWarnings("unchecked") T... closedElements) {
		Arrays.stream(closedElements).forEach(e -> {
			if (e != null) {
				try {
					e.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
}