package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import dto.ItemGroupDetailRawData;
import entities.ItemGroup;
import utils.SqlUtils;

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
		List<ItemGroup> itemGroups = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "select * from loaihang";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				itemGroups.add(itemGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, conn);
		}
		return itemGroups;
	}

	@Override
	public List<ItemGroup> get(String name) {
		List<ItemGroup> itemGroups = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "select * from loaihang where TenLoai = '" + name + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				itemGroups.add(itemGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, conn);
		}
		return itemGroups;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup itemGroup = null;
		Connection conn = connection.getConnection();
		String query = "select *from loaihang where MaLoai = " + id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, conn);
		}
		return itemGroup;
	}

	

	@Override
	public List<ItemGroupDetailRawData> getItemGroupDetails() {
		List<ItemGroupDetailRawData> result = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "select lh.MaLoai, lh.TenLoai, sum(mh.SoLuong) SoLuongHang, group_concat(concat(mh.TenMH, \":\", mh.SoLuong) separator '-') ChiTietMatHang \n" + 
				"from mathang mh join loaihang lh\n" + 
				"on mh.MaLoai = lh.MaLoai\n" + 
				"group by lh.MaLoai;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroupDetailRawData dto = new ItemGroupDetailRawData();
				dto.setId(rs.getInt("MaLoai"));
				dto.setName(rs.getString("TenLoai"));
				dto.setAmountOfItems(rs.getInt("SoLuongHang"));
				dto.setDetail(rs.getString("ChiTietMatHang"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst, conn);
		}
		return result;
	}
}