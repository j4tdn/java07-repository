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
import util.SqlUtils;

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
			SqlUtils.close(rs, st, conn);
		}
		return itemGroups;
	}

	@Override
	public ItemGroup get(int id) {
		ItemGroup itemGroup = null;
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
			SqlUtils.close(rs, st, conn);
		}
		return itemGroup;
	}

	

	@Override
	public List<ItemGroupDetailRawData> getItemGroupDetails() {

		List<ItemGroupDetailRawData> result  = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "select lh.Maloai,lh.tenloai,Sum(mh.soluong) Soluonghang,group_concat(concat(mh.tenmh,\":\",mh.soluong) separator '-') ChiTietMatHang\n" 
				+"FROM MATHANG MH\r\n" 
				+"join loaihang lh on mh.maloai=lh.maloai\n" 
				+"group by lh.maloai;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroupDetailRawData dto=new ItemGroupDetailRawData();
				dto.setId(rs.getInt("Maloai"));
				dto.setName(rs.getString("TenLoai"));
				dto.setAmountOfItem(rs.getInt("SoLuongHang"));
				dto.setDetail(rs.getString("ChiTietMatHang"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st, conn);
		}
		return result;
		
	}
}