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
import dto.ItemGroupDetailRawData;
import entities.ItemGroup;
import utils.SqlUtils;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private final ConnectionManager connection;
	private PreparedStatement preStatement;
	private Statement statement;
	private ResultSet resultSet;

	public ItemGroupDaoImpl() {
		connection = new ConnectionManagerImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> itemGroups = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "SELECT * FROM LoaiHang";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ItemGroup itemGroup = new ItemGroup(resultSet.getInt("MaLoai"), resultSet.getString("TenLoai"));
				itemGroups.add(itemGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(resultSet, statement, conn);
		}
		return itemGroups;
	}

	@Override
	public ItemGroup getById(int id) {
		ItemGroup itemGroup = null;
		Connection conn = connection.getConnection();
		String query = "SELECT *\n"
				+ "FROM LoaiHang\n"
				+ "WHERE MaLoai =" + id;
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				itemGroup = new ItemGroup(resultSet.getInt("MaLoai"), resultSet.getString("TenLoai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(resultSet, statement, conn);
		}
		return itemGroup;
	}

	@Override
	public List<ItemGroup> getByName(String name) {
		List<ItemGroup> itemGroups = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "SELECT *\n"
				+ "FROM LoaiHang\n"
				+ "WHERE TenLoai LIKE ?";
		System.out.println(query);
		try {
			preStatement = conn.prepareStatement(query);
			preStatement.setString(1, "%" +name +"%");
			resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
				ItemGroup itemGroup = new ItemGroup(resultSet.getInt("MaLoai"), resultSet.getString("TenLoai"));
				itemGroups.add(itemGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(resultSet, statement, conn);
		}
		return itemGroups;
	}

	@Override
	public List<ItemGroupDetailRawData> getItemGroupDetail() {
		List<ItemGroupDetailRawData> results = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "SELECT lh.MaLoai, lh.TenLoai, SUM(mh.SoLuong) SoLuongHang, GROUP_CONCAT(concat(mh.TenMH, \":\", mh.SoLuong) separator '-') ChiTietMatHang\r\n"  
				+ "FROM mathang mh\r\n" 
				+ "JOIN loaihang lh on mh.MaLoai = lh.MaLoai\r\n" 
				+ "GROUP BY lh.MaLoai;";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ItemGroupDetailRawData itemGroupDetail = new ItemGroupDetailRawData(
						resultSet.getInt("MaLoai"),
						resultSet.getString("TenLoai"),
						resultSet.getInt("SoLuongHang"),
						resultSet.getString("ChiTietMatHang"));
				results.add(itemGroupDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(resultSet, statement, conn);
		}
		return results;
	}

}
