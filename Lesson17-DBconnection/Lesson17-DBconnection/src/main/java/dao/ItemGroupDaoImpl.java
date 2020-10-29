package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ItemGroupDetailRawData.ItemGroupDetailDto;
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
			close(rs, st, conn);
		}
		return itemGroups;
	}

	@Override
	public List<ItemGroup> get(String name) {
		List<ItemGroup> itemGroups = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "select *\n" + "from loaihang\n" + "where TenLoai like ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroup itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				itemGroups.add(itemGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return itemGroups;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup itemGroup = null;
		;
		Connection conn = connection.getConnection();
		String query = "select *\n" + "from loaihang\n" + "where MaLoai = " + id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				itemGroup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return itemGroup;
	}

	private <T extends AutoCloseable> void close(T... closedElements) {
		Arrays.stream(closedElements).forEach(element -> {
			if (element != null) {
				try {
					element.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public List<ItemGroupDetailDto> getItemGroupDetails() {
		List<ItemGroupDetailDto> itemGroupDetails = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "SELECT lh.MaLoai, "
				+ "lh.TenLoai, "
				+ "SUM(mh.SoLuong) SoLuongHang, "
				+ "group_concat(concat(mh.TenMH, ':', mh.SoLuong), separator '--') ChiTietMatHang \n" 
				+ "FROM mathang mh \n" 
				+ "JOIN LoaiHang lh ON mh.MaLoai = lh.MaLoai\n" 
				+ "GROUP BY lh.MaLoai";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroupDetailDto dto = new ItemGroupDetailDto();
				dto.setId(rs.getInt("MaLoai"));
				dto.setName(rs.getString("TenLoai"));
				dto.setAmountOfItems(rs.getInt("SoLuongHang"));
				dto.setItemList(rs.getString("ChiTietMatHang"));
				itemGroupDetails.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return itemGroupDetails;
	}
}
