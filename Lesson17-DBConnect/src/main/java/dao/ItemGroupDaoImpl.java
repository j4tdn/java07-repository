package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import dto.ItemGroupDetailDto;
import dto.ItemGroupDetailRawData;
import dto.ItemGroupDetailDto;
import entities.ItemGroup;

public class ItemGroupDaoImpl implements ItemGroupDao {
	private final ConnectionManager connection;
	private Statement st;
	private ResultSet rs;

	public ItemGroupDaoImpl() {
		connection = new ConnectionManagerImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ItemGroupDetailDto> getItemGroupDetails() {
		List<ItemGroupDetailDto> result = new ArrayList<>();
		Connection conn = connection.getConnection();
		String query = "SELECT lh.MaLoai,lh.TenLoai,\n" + "SUM(mh.SoLuong) SoLuongHang,\n"
				+ "group_concat(concat(mh.TenMH,\":\",mh.SoLuong) separator'-')\n" + "from MatHang mh\n"
				+ "join LoaiHang lh ON mh.MaLoai=lh.MaLoai\n" + "group by lh.MaLoai;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ItemGroupDetailRawData itemGroupDetailRawData = new ItemGroupDetailRawData(rs.getInt("MaLoai"),
						rs.getString("TenLoai"), rs.getInt("SoLuongHang"), rs.getString("ChiTietHang"));
				result.add(itemGroupDetailRawData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);

		}
		return result;
	}

	

	@Override
	public List<ItemGroup> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
