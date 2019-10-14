package com.dhee.dao;

import java.util.List;
import com.dhee.tools.ComparyInfoPage;
import com.dhee.tools.StudentInfoPage;
import com.dhee.vo.AdminUser;
import com.dhee.vo.ComparyInfo;
import com.dhee.vo.StudentInfo;

public interface AdminDao {
	// 查询教师--admin登陆
	public AdminUser selectAdminUser(AdminUser t);

	// 分页查询学员信息
	public StudentInfoPage selectStudentInfo(StudentInfoPage sp);

	// 导出exl查询学员信息
	public List<StudentInfo> selectStudentInfo(String className, String studentName);

	// 是否已经添加过该学员的详细信息
	public int isStudentInfoName(String name);

	// 删除学员信息
	public int deletStudentInfo(String id);

	// 保存学员信息
	public int saveStudentInfo(StudentInfo sInfo);

	// 更新学员信息
	public int updateStudentInfo(StudentInfo sInfo);

	// 分页查询公司信息
	public ComparyInfoPage selectComparyInfo(ComparyInfoPage sp);

	// 导出exl查询公司信息
	public List<ComparyInfo> selectComparyInfo(String className, String studentName);

	// 删除公司信息
	public int deletComparyInfo(String id);

	// 保存公司信息
	public int saveComparyInfo(ComparyInfo sInfo);

	// 更新公司信息
	public int updateComparyInfo(ComparyInfo sInfo);

}
