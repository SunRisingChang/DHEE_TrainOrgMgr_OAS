package com.dhee.daoLmpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dhee.dao.AdminDao;
import com.dhee.dbConnection.DBO;
import com.dhee.tools.ComparyInfoPage;
import com.dhee.tools.StudentInfoPage;
import com.dhee.vo.AdminUser;
import com.dhee.vo.ComparyInfo;
import com.dhee.vo.StudentInfo;

public class AdminImpl implements AdminDao {
	private DBO dbo;

	public AdminImpl() {
		// TODO Auto-generated constructor stub
		dbo = new DBO();
	}

	@Override
	public AdminUser selectAdminUser(AdminUser t) {
		// TODO Auto-generated method stub
		AdminUser adminUser = null;
		try {
			String sql = "SELECT * FROM admin_user WHERE uname='" + t.getUname() + "'";
			ResultSet resultSet = dbo.select(sql);
			while (resultSet.next()) {
				adminUser = new AdminUser();
				adminUser.setId(resultSet.getInt(1));
				adminUser.setUname(resultSet.getString(2));
				adminUser.setUpassword(resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminUser;
	}

	@Override
	public ComparyInfoPage selectComparyInfo(ComparyInfoPage sp) {
		// TODO Auto-generated method stub
		String sql = "";
		String sqlnum = "";
		List<ComparyInfo> list = null;
		int sum = 0;
		if (!sp.getComMan().equals("") && !sp.getComName().equals("")) {
			sql = "SELECT * FROM compary_info WHERE com_name like '%" + sp.getComName() + "%' AND com_man LIKE '%" + sp.getComMan() + "%' limit " + sp.startrow() + "," + sp.getN() + "";
			sqlnum = "SELECT COUNT(*) FROM compary_info WHERE com_name like '%" + sp.getComName() + "%' AND com_man LIKE '%" + sp.getComMan() + "%'";
		} else {
			if (sp.getComName().equals("")) {
				sql = "SELECT * FROM compary_info WHERE com_man like '%" + sp.getComMan() + "%' limit " + sp.startrow() + "," + sp.getN() + "";
				sqlnum = "SELECT COUNT(*) FROM compary_info WHERE com_man like '%" + sp.getComMan() + "%'";
			} else {
				sql = "SELECT * FROM compary_info WHERE  com_name LIKE '%" + sp.getComName() + "%' limit " + sp.startrow() + "," + sp.getN() + "";
				sqlnum = "SELECT COUNT(*) FROM compary_info WHERE  com_name LIKE '%" + sp.getComName() + "%'";
			}
		}
		try {
			ResultSet resultSet = dbo.select(sql);
			ResultSet resultSet2 = new DBO().select(sqlnum);
			list = new ArrayList<ComparyInfo>();
			while (resultSet.next()) {
				ComparyInfo comparyInfo = new ComparyInfo();
				comparyInfo.setId(resultSet.getInt(1));
				comparyInfo.setComName(resultSet.getString(2));
				comparyInfo.setComMan(resultSet.getString(3));
				comparyInfo.setZhiWu(resultSet.getString(4));
				comparyInfo.setZuoJi(resultSet.getString(5));
				comparyInfo.setShouJi(resultSet.getString(6));
				comparyInfo.setQq(resultSet.getString(7));
				comparyInfo.setWeiXin(resultSet.getString(8));
				comparyInfo.setEmail(resultSet.getString(9));
				comparyInfo.setDiZhi(resultSet.getString(10));
				comparyInfo.setFaPiao(resultSet.getString(11));
				comparyInfo.setBeiZhu(resultSet.getString(12));
				list.add(comparyInfo);
			}
			sp.setPagelist(list);
			while (resultSet2.next()) {
				sum = resultSet2.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp.setAllrow(sum);
		return sp;
	}

	@Override
	public List<ComparyInfo> selectComparyInfo(String comName, String comMan) {
		// TODO Auto-generated method stub
		String sql = "";
		List<ComparyInfo> list = null;
		if (!comName.equals("") && !comMan.equals("")) {
			sql = "SELECT * FROM compary_info WHERE com_name like '%" + comName + "%' AND com_man LIKE '%" + comMan + "%'";
		} else {
			if (comName.equals("")) {
				sql = "SELECT * FROM compary_info WHERE com_man LIKE '%" + comMan + "%'";
			} else {
				sql = "SELECT * FROM compary_info WHERE  com_name like '%" + comName + "%'";
			}
		}
		try {
			ResultSet resultSet = dbo.select(sql);
			list = new ArrayList<ComparyInfo>();
			while (resultSet.next()) {
				ComparyInfo comparyInfo = new ComparyInfo();
				comparyInfo.setId(resultSet.getInt(1));
				comparyInfo.setComName(resultSet.getString(2));
				comparyInfo.setComMan(resultSet.getString(3));
				comparyInfo.setZhiWu(resultSet.getString(4));
				comparyInfo.setZuoJi(resultSet.getString(5));
				comparyInfo.setShouJi(resultSet.getString(6));
				comparyInfo.setQq(resultSet.getString(7));
				comparyInfo.setWeiXin(resultSet.getString(8));
				comparyInfo.setEmail(resultSet.getString(9));
				comparyInfo.setDiZhi(resultSet.getString(10));
				comparyInfo.setFaPiao(resultSet.getString(11));
				comparyInfo.setBeiZhu(resultSet.getString(12));
				list.add(comparyInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deletComparyInfo(String id) {
		// TODO Auto-generated method stub
		int temp = 0;
		String sql = "delete from compary_info where id=" + id;
		temp = dbo.delete(sql);
		return temp;
	}

	@Override
	public int saveComparyInfo(ComparyInfo comparyInfo) {
		// TODO Auto-generated method stub
		int temp = 0;
		String sql = "INSERT INTO compary_info (com_name,com_man,zhi_wu,zuo_ji,shou_ji,qq,wei_xin,email,di_zhi,fa_piao,bei_zhu) VALUES ('" + comparyInfo.getComName() + "','" + comparyInfo.getComMan() + "','" + comparyInfo.getZhiWu() + "','" + comparyInfo.getZuoJi() + "','" + comparyInfo.getShouJi() + "','" + comparyInfo.getQq() + "','" + comparyInfo.getWeiXin() + "','" + comparyInfo.getEmail() + "','" + comparyInfo.getDiZhi() + "','" + comparyInfo.getFaPiao() + "','" + comparyInfo.getBeiZhu() + "')";
		System.out.println(sql);
		temp = dbo.save(sql);
		return temp;
	}

	@Override
	public int updateComparyInfo(ComparyInfo comparyInfo) {
		// TODO Auto-generated method stub
		int temp = 0;
		String sql = "UPDATE compary_info SET com_name='" + comparyInfo.getComName() + "',com_man='" + comparyInfo.getComMan() + "',zhi_wu='" + comparyInfo.getZhiWu() + "',zuo_ji='" + comparyInfo.getZuoJi() + "',shou_ji='" + comparyInfo.getShouJi() + "',qq='" + comparyInfo.getQq() + "',wei_xin='" + comparyInfo.getWeiXin() + "',email='" + comparyInfo.getEmail() + "',di_zhi='" + comparyInfo.getDiZhi() + "',fa_piao='" + comparyInfo.getFaPiao() + "',bei_zhu='" + comparyInfo.getBeiZhu() + "' WHERE (id='" + comparyInfo.getId() + "')";
		temp = dbo.save(sql);
		return temp;
	}

	@Override
	public StudentInfoPage selectStudentInfo(StudentInfoPage sp) {
		// TODO Auto-generated method stub
		String sql = "";
		String sqlnum = "";
		List<StudentInfo> list = null;
		int sum = 0;
		if (!sp.getPj().equals("") && !sp.getClassTimes().equals("")) {
			sql = "SELECT * FROM student_info WHERE pj like '%" + sp.getPj() + "%' AND class_times LIKE '%" + sp.getClassTimes() + "%' limit " + sp.startrow() + "," + sp.getN() + "";
			sqlnum = "SELECT COUNT(*) FROM student_info WHERE pj like '%" + sp.getPj() + "' AND class_times LIKE '%" + sp.getClassTimes() + "%'";
		} else {
			if (sp.getClassTimes().equals("")) {
				sql = "SELECT * FROM student_info WHERE pj like '%" + sp.getPj() + "%' limit " + sp.startrow() + "," + sp.getN() + "";
				sqlnum = "SELECT COUNT(*) FROM student_info WHERE pj like '%" + sp.getPj() + "%'";
			} else {
				sql = "SELECT * FROM student_info WHERE  class_times LIKE '%" + sp.getClassTimes() + "%' limit " + sp.startrow() + "," + sp.getN() + "";
				sqlnum = "SELECT COUNT(*) FROM student_info WHERE  class_times LIKE '%" + sp.getClassTimes() + "%'";
			}
		}
		try {
			ResultSet resultSet = dbo.select(sql);
			ResultSet resultSet2 = new DBO().select(sqlnum);
			list = new ArrayList<StudentInfo>();
			while (resultSet.next()) {
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setId(resultSet.getInt(1));
				studentInfo.setPj(resultSet.getString(2));
				studentInfo.setClassTimes(resultSet.getString(3));
				studentInfo.setOpenTime(resultSet.getString(4));
				studentInfo.setComName(resultSet.getString(5));
				studentInfo.setMan(resultSet.getString(6));
				studentInfo.setStudentName(resultSet.getString(7));
				studentInfo.setSex(resultSet.getString(8));
				studentInfo.setCard(resultSet.getString(9));
				studentInfo.setXueLi(resultSet.getString(10));
				studentInfo.setZhuanYe(resultSet.getString(11));
				studentInfo.setBiyeTime(resultSet.getString(12));
				studentInfo.setZhiCheng(resultSet.getString(13));
				studentInfo.setZhiWu(resultSet.getString(14));
				studentInfo.setPhone(resultSet.getString(15));
				studentInfo.setMail(resultSet.getString(16));
				studentInfo.setIsAcee(resultSet.getString(17));
				studentInfo.setBukaoTime(resultSet.getString(18));
				studentInfo.setBukaoIs(resultSet.getString(19));
				list.add(studentInfo);
			}
			sp.setPagelist(list);
			while (resultSet2.next()) {
				sum = resultSet2.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp.setAllrow(sum);
		return sp;
	}

	@Override
	public List<StudentInfo> selectStudentInfo(String className, String studentName) {
		// TODO Auto-generated method stub
		String sql = "";
		List<StudentInfo> list = null;
		if (!className.equals("") && !studentName.equals("")) {
			sql = "SELECT * FROM student_info WHERE pj like '%" + className + "%' AND class_times LIKE '%" + studentName + "%'";
		} else {
			if (studentName.equals("")) {
				sql = "SELECT * FROM student_info WHERE pj like '%" + className + "%'";
			} else {
				sql = "SELECT * FROM student_info WHERE  class_times LIKE '%" + studentName + "%'";
			}
		}
		try {
			ResultSet resultSet = dbo.select(sql);
			list = new ArrayList<StudentInfo>();
			while (resultSet.next()) {
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setId(resultSet.getInt(1));
				studentInfo.setPj(resultSet.getString(2));
				studentInfo.setClassTimes(resultSet.getString(3));
				studentInfo.setOpenTime(resultSet.getString(4));
				studentInfo.setComName(resultSet.getString(5));
				studentInfo.setMan(resultSet.getString(6));
				studentInfo.setStudentName(resultSet.getString(7));
				studentInfo.setSex(resultSet.getString(8));
				studentInfo.setCard(resultSet.getString(9));
				studentInfo.setXueLi(resultSet.getString(10));
				studentInfo.setZhuanYe(resultSet.getString(11));
				studentInfo.setBiyeTime(resultSet.getString(12));
				studentInfo.setZhiCheng(resultSet.getString(13));
				studentInfo.setZhiWu(resultSet.getString(14));
				studentInfo.setPhone(resultSet.getString(15));
				studentInfo.setMail(resultSet.getString(16));
				studentInfo.setIsAcee(resultSet.getString(17));
				studentInfo.setBukaoTime(resultSet.getString(18));
				studentInfo.setBukaoIs(resultSet.getString(19));
				list.add(studentInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int isStudentInfoName(String name) {
		// TODO Auto-generated method stub
		int temp = 0;
		String sql = "SELECT * FROM student_info WHERE student_name='" + name + "'";
		try {
			ResultSet resultSet = dbo.select(sql);
			if (resultSet.next()) {
				temp = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int deletStudentInfo(String id) {
		// TODO Auto-generated method stub
		int temp = 0;
		String sql = "delete from student_info where id=" + id;
		temp = dbo.delete(sql);
		return temp;
	}

	@Override
	public int saveStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		int temp = 0;
		String sql = "INSERT INTO student_info (pj,class_times,open_time,com_name,man,student_name,sex,card,xue_li,zhuan_ye,biye_time,zhi_cheng,zhi_wu,phone,mail,is_acee,bukao_time,bukao_is) VALUES ('" + studentInfo.getPj() + "','" + studentInfo.getClassTimes() + "','" + studentInfo.getOpenTime() + "','" + studentInfo.getComName() + "','" + studentInfo.getMan() + "','" + studentInfo.getStudentName() + "','" + studentInfo.getSex() + "','" + studentInfo.getCard() + "','" + studentInfo.getXueLi() + "','" + studentInfo.getZhuanYe() + "','" + studentInfo.getBiyeTime() + "','" + studentInfo.getZhiCheng() + "','" + studentInfo.getZhiWu() + "','" + studentInfo.getPhone() + "','" + studentInfo.getMail() + "','" + studentInfo.getIsAcee() + "','" + studentInfo.getBukaoTime() + "','"
				+ studentInfo.getBukaoIs() + "')";
		System.out.println(sql);
		temp = dbo.save(sql);
		return temp;
	}

	@Override
	public int updateStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		int temp = 0;
		String sql = "UPDATE student_info SET pj='" + studentInfo.getPj() + "',class_times='" + studentInfo.getClassTimes() + "',open_time='" + studentInfo.getOpenTime() + "',com_name='" + studentInfo.getComName() + "',man='" + studentInfo.getMan() + "',student_name='" + studentInfo.getStudentName() + "',sex='" + studentInfo.getSex() + "',card='" + studentInfo.getCard() + "',xue_li='" + studentInfo.getXueLi() + "',zhuan_ye='" + studentInfo.getZhuanYe() + "',biye_time='" + studentInfo.getBiyeTime() + "',zhi_cheng='" + studentInfo.getZhiCheng() + "',zhi_wu='" + studentInfo.getZhiWu() + "',phone='" + studentInfo.getPhone() + "',mail='" + studentInfo.getMail() + "',is_acee='" + studentInfo.getIsAcee() + "',bukao_time='" + studentInfo.getBukaoTime() + "',bukao_is='" + studentInfo.getBukaoIs()
				+ "' WHERE (id='" + studentInfo.getId() + "')";
		temp = dbo.save(sql);
		return temp;
	}

}
