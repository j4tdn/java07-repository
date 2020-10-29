package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import DTO.ItemGroupDetailDTO;
import DTO.ItemGroupDetailRawData;
import DTO.ItemGroupDetailRawData;
import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entity.ItemGroup;
import utils.sqlUtils;

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
			sqlUtils.close(rs, st, con);
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
			sqlUtils.close(rs, st, con);
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
			sqlUtils.close(rs, st, con);
		}
		return itemGoup;
	}
	
	@Override
	public List<ItemGroupDetailRawData> getItemGroupDetails() {
		List<ItemGroupDetailRawData> result = new ArrayList<>();
		Connection con = connection.getConnection();
		String query = "SELECT  lh.Maloai, lh.TenLoai, SUM(mh.SoLuong) as SoLuongHang,  group_concat(concat(mh.TenMH,\";\", mh.SoLuong) separator'-') as ChiTietMatHang\n"
					+ "FROM mathang mh\n"
					+ "JOIN loaihang lh on mh.MaLoai = lh.MaLoai\n"
					+ "GROUP By lh.MaLoai\n"
					+ "";
		try {	
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroupDetailDTO dto = new ItemGroupDetailDTO();
				dto.setId(rs.getInt("MaLoai"));
				dto.setName(rs.getString("TenLoai"));
				dto.setAmountOfItems(rs.getInt("SoLuongHang"));
				dto.setDetail(rs.getString("ChiTietMatHang"));
				result.addAll((Collection<? extends ItemGroupDetailRawData>) dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, st, con);
		}
		return result;
		
	}
}