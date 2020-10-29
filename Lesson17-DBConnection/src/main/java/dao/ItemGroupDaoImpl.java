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
import dto.ItemGroupDetailDto;
import dto.ItemGroupDetailRawData;
import entities.ItemGroup;
import utils.SqlUtils;

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
			SqlUtils.close(rs, st, conn);
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
			SqlUtils.close(rs, st, conn);
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
			SqlUtils.close(rs, st, conn);
		}
		return itemGroup;
	}
	@Override
	public List<ItemGroupDetailRawData> getItemGroupDetails() {
		List<ItemGroupDetailRawData> itemGroupDetails = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "select lh.MaLoai ,\n" 
				+ "lh.TenLoai,\n" 
				+ "sum(mh.SoLuong) SoLuongHang, \n" 
				+ "group_concat(concat(mh.TenMh,':',mh.SoLuong) separator' - ') ChiTiet\n"
				+ "from MatHang mh\n" 
				+ "join LoaiHang lh on mh.MaLoai = lh.MaLoai\n" 
				+ "group by lh.MaLoai";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				ItemGroupDetailRawData dto = new ItemGroupDetailRawData();
				dto.setId(rs.getInt("MaLoai"));
				dto.setName(rs.getString("MaLoai"));
				dto.setAmountOfItem(rs.getInt("SoLuongHang"));
				dto.setDetail(rs.getString("ChiTiet"));
				itemGroupDetails.add(dto);
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, conn);
		}
		return itemGroupDetails;
	}

	

	

}
