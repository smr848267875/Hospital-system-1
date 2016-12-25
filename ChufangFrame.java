package hospital.frame;

import hospital.util.JdbcUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JOptionPane;

public class ChufangFrame implements ActionListener {
	Statement stmt = null;
	String sql;

	Frame frm3 = new Frame("医院管理系统");

	// 处方管理界面
	Label labe9 = new Label("    Ｅ处方管理：（查询，删除时直接输入处方编号)");
	Label labe10 = new Label("    处方编号：");
	Label labe11 = new Label("    处方内容：");
	Button qry = new Button("E 查询");
	Button del = new Button("E 删除");
	Button add = new Button("E 录入");

	TextField lst41 = new TextField();
	TextArea txa1 = new TextArea();

	public void clearFrame() {
		lst41.setText("");
		txa1.setText("");
	}


	public ChufangFrame() {

		// 处方管理系统界面
		labe9.setBounds(5, 45, 400, 20);
		labe10.setBounds(5, 70, 90, 20);
		labe11.setBounds(5, 100, 90, 20);
		lst41.setBounds(100, 70, 100, 20);
		txa1.setBounds(20, 125, 400, 175);
		add.setBounds(30, 325, 50, 20);
		del.setBounds(140, 325, 50, 20);
		qry.setBounds(250, 325, 50, 20);
		frm3.add(labe9);
		frm3.add(labe10);
		frm3.add(labe11);
		frm3.add(lst41);
		frm3.add(txa1);
		frm3.add(qry);
		frm3.add(del);
		frm3.add(add);

		qry.addActionListener(this);
		del.addActionListener(this);
		add.addActionListener(this);

		frm3.setLayout(null);
		frm3.setBounds(500, 200, 460, 400);
		frm3.setBackground(Color.ORANGE);
		frm3.setVisible(true);

		// 实现窗口关闭按扭的事件
		frm3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm3.dispose();
			}
		});

		frm3.setResizable(false);// 固定窗口的大小

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
        public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		ResultSet rs = null;
		String _id = lst41.getText().trim();
		if (soruce == qry) {
			try {

				if (_id.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的处方编号！");
					return;
				}

				sql = "select * from Presno where Presno='" + _id + "'";

				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					txa1.setText(rs.getString(2));
				} else {
					JOptionPane.showMessageDialog(null, "没有查询到【" + _id + "】!");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == del) {
			try {
				if (_id.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要删除的处方编号！");
					return;
				}

				sql = "delete from Presno where Presno='" + _id + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "没有查询到【" + _id + "】！");
				} else {
					JOptionPane.showMessageDialog(null, "删除【" + _id + "】成功！");
					clearFrame();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == add) {
			try {
				if (_id.equals("")) {
					JOptionPane.showMessageDialog(null, "处方编号不能为空！");
					return;
				}

				sql = "select * from Presno where Presno='" + _id + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "处方编号【" + _id
							+ "】已经存在，请重新输入！");
					return;
				}

				sql = "insert into Presno" + "(Presno,Pcontent) values('"
						+ lst41.getText().trim() + "','"
						+ txa1.getText().trim() + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "录入信息成功！");
				clearFrame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}
}
