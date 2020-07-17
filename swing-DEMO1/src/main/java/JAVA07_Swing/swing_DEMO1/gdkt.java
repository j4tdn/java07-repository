package JAVA07_Swing.swing_DEMO1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gdkt extends JFrame {

	private JPanel contentPane;
	private JTextField txtmsp;
	private JTextField txttensp;
	private JTextField txtsoluong;
	private JTextField txtdongia;
	JLabel jbltt = new JLabel("");
	JComboBox comboBox = new JComboBox();
	private JTable table;

	Vector Vtieude = new Vector();
	Vector Vndung = new Vector();
	Vector Vdong;
	float tt = 0;
	DefaultTableModel dtm = new DefaultTableModel();

	void tieude() {
		Vtieude.add("Mã sản phẩm");
		Vtieude.add("Tên sản phẩm");
		Vtieude.add("Loại sản phẩm");
		Vtieude.add("Khuyến mại");
		Vtieude.add("Số lượng");
		Vtieude.add("Đơn giá");
		Vtieude.add("Thành tiền");
	}

	void Nhap(SanPham sp) {
		Vdong = new Vector();
		Vdong.add(sp.getMasp());
		Vdong.add(sp.getTensp());
		if(comboBox.getSelectedIndex() == 0) {
			Vdong.add("Điện Thoại");
			Vdong.add("20%");
		}
		if(comboBox.getSelectedIndex() == 1) {
			Vdong.add("Điện Máy");
			Vdong.add("10%");
		}
		Vdong.add(sp.getSoluong());
		Vdong.add(sp.getDongia());
		Vdong.add(sp.tinhtien());
		Vdong.add(Vdong);
		tt+=sp.tinhtien();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gdkt frame = new gdkt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gdkt() {
		tieude();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sản Phẩm");
		lblNewLabel.setBounds(24, 11, 76, 24);
		contentPane.add(lblNewLabel);

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Điện Thoại", "Điện Máy" }));
		comboBox.setBounds(10, 35, 107, 20);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Mã SP");
		lblNewLabel_1.setBounds(146, 16, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên SP");
		lblNewLabel_2.setBounds(146, 38, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Số Lượng");
		lblNewLabel_3.setBounds(146, 63, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Đơn Giá");
		lblNewLabel_4.setBounds(146, 88, 46, 14);
		contentPane.add(lblNewLabel_4);

		txtmsp = new JTextField();
		txtmsp.setBounds(201, 13, 129, 20);
		contentPane.add(txtmsp);
		txtmsp.setColumns(10);

		txttensp = new JTextField();
		txttensp.setBounds(202, 35, 128, 20);
		contentPane.add(txttensp);
		txttensp.setColumns(10);

		txtsoluong = new JTextField();
		txtsoluong.setBounds(202, 60, 128, 20);
		contentPane.add(txtsoluong);
		txtsoluong.setColumns(10);

		txtdongia = new JTextField();
		txtdongia.setBounds(202, 85, 128, 20);
		contentPane.add(txtdongia);
		txtdongia.setColumns(10);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SanPham s = null;
				String masp = txtmsp.getText();
				String tensp = txttensp.getText();
				float sl = Float.parseFloat(txtsoluong.getText());
				float dg = Float.parseFloat(txtdongia.getText());
				if(comboBox.getSelectedIndex()==0) {
					s =  new DienThoai(masp, tensp, sl, dg);
				}
				if(comboBox.getSelectedIndex()==1) {
					s =  new DienThoai(masp, tensp, sl, dg);
				}
				jbltt.setText("" + tt);
				Nhap(s);
				dtm.setDataVector(Vndung,Vtieude);
				table.setModel(dtm);
			}
		});
		btnNewButton.setBounds(28, 126, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtdongia.setText("");
				txtmsp.setText("");
				txttensp.setText("");
				txtsoluong.setText("");
				Vdong.clear();
				dtm.setDataVector(Vdong	, Vtieude);
				table.setModel(dtm);
			}
		});
		btnXoa.setBounds(171, 126, 89, 23);
		contentPane.add(btnXoa);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(313, 126, 89, 23);
		contentPane.add(btnThoat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 494, 93);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Khuy\u1EBFn M\u00E3i", "\u0110\u01A1n Gi\u00E1", "Th\u00E0nh Ti\u1EC1n"},
			},
			new String[] {
				"Ma\u0303 Sa\u0309n Ph\u00E2\u0309m", "T\u00EAn Sa\u0309n Ph\u00E2\u0309m", "Loa\u0323i Sa\u0309n Ph\u00E2\u0309m", "S\u00F4\u0301 L\u01B0\u01A1\u0323ng", "Khuy\u00EA\u0301n Ma\u0303i", "\u0110\u01A1n Gia\u0301", "Tha\u0300nh Ti\u00EA\u0300n"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(6).setPreferredWidth(77);
		scrollPane.setRowHeaderView(table);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng Thành Tiền");
		lblNewLabel_1_1.setBounds(214, 256, 89, 14);
		contentPane.add(lblNewLabel_1_1);

		jbltt.setForeground(Color.RED);
		jbltt.setBounds(313, 256, 111, 14);
		contentPane.add(jbltt);
	}
}
