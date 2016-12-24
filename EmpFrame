package hospital.frame;

import hospital.util.JdbcUtil;

import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EmpFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm4 = new Frame("医院管理系统");

	// 医院职员管理界面
	Label labe12 = new Label("    Ｆ医院工作员工管理：（注意：查询，删除请输入姓名）");
	Label labe13 = new Label("    姓        名:");
	Label labe14 = new Label("    工作编号:");
	Label labe15 = new Label("    年       龄:");
	Label labe16 = new Label("    性       别:");
	Label labe17 = new Label("    联系电话:");
	Label labe18 = new Label("    职       务:");
	Label labe19 = new Label("    学       历:");
	Label labe20 = new Label("    自我评价:");
	Label labe21 = new Label("    工作经历:");

	TextField lst51 = new TextField();
	TextField lst52 = new TextField();
	TextField lst53 = new TextField();
	TextField lst54 = new TextField();
	TextField lst55 = new TextField();
	TextField lst56 = new TextField();
	TextField lst57 = new TextField();
	TextField lst58 = new TextField();
	TextArea txa2 = new TextArea();

	Button qry = new Button("E 查询");
	Button del = new Button("E 删除");
	Button add = new Button("E 录入");

	public void clearFrame() {
		lst51.setText("");
		lst52.setText("");
		lst53.setText("");
		lst54.setText("");
		lst55.setText("");
		lst56.setText("");
		lst57.setText("");
		lst58.setText("");
		txa2.setText("");
	}



	public EmpFrame() {

		// 医院员工管理界面
		labe12.setBounds(50, 45, 375, 20);
		labe13.setBounds(50, 80, 80, 20);
		labe14.setBounds(50, 115, 80, 20);
		labe15.setBounds(50, 145, 80, 20);
		labe16.setBounds(340, 175, 80, 20);
		labe17.setBounds(50, 175, 80, 20);
		labe18.setBounds(340, 205, 80, 20);
		labe19.setBounds(50, 205, 80, 20);
		labe20.setBounds(50, 235, 80, 20);
		labe21.setBounds(50, 315, 80, 20);
		lst51.setBounds(140, 85, 120, 20);
		lst52.setBounds(140, 115, 120, 20);
		lst53.setBounds(140, 145, 120, 20);
		lst54.setBounds(420, 175, 120, 20);
		lst55.setBounds(140, 175, 120, 20);
		lst56.setBounds(420, 205, 120, 20);
		lst57.setBounds(140, 205, 120, 20);
		lst58.setBounds(140, 235, 400, 70);
		txa2.setBounds(70, 335, 475, 135);
		qry.setBounds(340, 475, 50, 20);
		del.setBounds(215, 475, 50, 20);
		add.setBounds(90, 475, 50, 20);
		frm4.add(labe12);
		frm4.add(labe13);
		frm4.add(labe14);
		frm4.add(labe15);
		frm4.add(labe16);
		frm4.add(labe17);
		frm4.add(labe18);
		frm4.add(labe19);
		frm4.add(labe20);
		frm4.add(labe21);
		frm4.add(lst51);
		frm4.add(lst52);
		frm4.add(lst53);
		frm4.add(lst54);
		frm4.add(lst55);
		frm4.add(lst56);
		frm4.add(lst57);
		frm4.add(lst58);
		// frm4.add(lst59);
		frm4.add(txa2);
		frm4.add(qry);
		frm4.add(del);
		frm4.add(add);
		qry.addActionListener(this);
		del.addActionListener(this);
		add.addActionListener(this);

		frm4.setLayout(null);
		frm4.setBounds(500, 200, 610, 540);
		frm4.setBackground(Color.ORANGE);
		frm4.setVisible(true);

		// 实现窗口关闭按扭的事件
		frm4.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm4.dispose();
			}
		});

		frm4.setResizable(false);// 固定窗口的大小

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		ResultSet rs = null;
		String _name = lst51.getText().trim();
		if (soruce == qry) {

			try {
				sql = "select * from Doctor where Dname='"
						+ lst51.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst51.setText(rs.getString(1));
					lst52.setText(rs.getString(2));
					lst53.setText(rs.getString(5));
					lst54.setText(rs.getString(7));
					lst55.setText(rs.getString(4));
					lst56.setText(rs.getString(3));
					lst57.setText(rs.getString(6));
					lst58.setText(rs.getString(9));
					txa2.setText(rs.getString(8));
				} else {
					JOptionPane
							.showMessageDialog(null, "没有查询到【" + _name + "】！");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == del) {

			try {
				if (_name.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的姓名！");
					return;
				}
				sql = "delete from Doctor where Dname='"
						+ lst51.getText().trim() + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane
							.showMessageDialog(null, "没有查询到到【" + _name + "】");
				} else {
					JOptionPane.showMessageDialog(null, "删除【" + _name + "】成功！");
					clearFrame();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == add) {
			try {

				if (_name.equals("")) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！");
					return;
				} else if (lst52.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "编号不能为空！");
					return;
				}
				sql = "select * from Doctor where Dno='"
						+ lst51.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "编号【"
							+ lst51.getText().trim() + "】已经存在，请重新输入！");
					return;
				}
				sql = "insert into Doctor(Dname,Dno,Dsex,Dposition,Dtelephone,Dage,Drecord,Dexperience,Djudgement) values('"
						+ lst51.getText().trim()
						+ "','"
						+ lst52.getText().trim()
						+ "','"
						+ lst53.getText().trim()
						+ "','"
						+ lst54.getText().trim()
						+ "','"
						+ lst55.getText().trim()
						+ "','"
						+ lst56.getText().trim()
						+ "','"
						+ lst57.getText().trim()
						+ "','"
						+ lst58.getText().trim()
						+ "','"
						+ txa2.getText().trim() + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "录入信息成功！");
				clearFrame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

}
