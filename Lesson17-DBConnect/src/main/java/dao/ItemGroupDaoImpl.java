package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import dto.ItemGroupDetailRawDto;
import entity.ItemGroup;
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
		List<ItemGroup> itemGoups = new ArrayList<>();
		Connection con = connection.getConnection();
		String query = "SELECT * FROM loaihang";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroup itemGoup = new ItemGroup(rs.getInt("MaLoai"), rs.getString("TenLoai"));
				itemGoups.add(itemGoup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, con);
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
			SqlUtils.close(rs, st, con);
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
			SqlUtils.close(rs, st, con);
		}
		return itemGoup;
	}

	@Override
	public List<ItemGroupDetailRawDto> getItemGroupDetailRawDto() {
		List<ItemGroupDetailRawDto> itemGoupDetailRawDtos = new ArrayList<>();
		Connection con = connection.getConnection();
		String query = "SELECT lh.MaLoai, lh.TenLoai, SUM(mh.SoLuong) SoLuongMH, group_concat(concat(mh.TenMH, ': ', mh.SoLuong) separator ', ') ChiTietMH FROM mathang mh JOIN loaihang lh ON mh.MaLoai = lh.MaLoai GROUP BY lh.MaLoai";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroupDetailRawDto itemGoupDetailRawDto = new ItemGroupDetailRawDto(rs.getInt("MaLoai"),
						rs.getString("TenLoai"), rs.getInt("SoLuongMH"), rs.getString("ChiTietMH"));
				itemGoupDetailRawDtos.add(itemGoupDetailRawDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, con);
		}
		return itemGoupDetailRawDtos;
	}
}