package com.dhee.action;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.dhee.daoFactory.DAOFactory;
import com.dhee.tools.ComparyInfoPage;
import com.dhee.tools.POI_ComparyInfo;
import com.dhee.tools.POI_StudentInfo;
import com.dhee.tools.StudentInfoPage;
import com.dhee.vo.AdminUser;
import com.dhee.vo.ComparyInfo;
import com.dhee.vo.StudentInfo;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class AdminAction extends SuperAction {
	private DAOFactory daoFactory = new DAOFactory();

	// 是否有该用户名
	public void isTeacherName() {
		try {
			AdminUser temp = new AdminUser();
			temp.setUname(request.getParameter("teacherName"));
			AdminUser adminUser = daoFactory.getAdminImpl().selectAdminUser(temp);
			if (adminUser == null) {
				response.getWriter().print("0");
			} else {
				response.getWriter().print("1");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("isTeacherName方法出错！");
		}
	}

	// 是否有该用户
	public void isTeacherUser() {
		try {
			AdminUser temp = new AdminUser();
			temp.setUname(request.getParameter("teacherName"));
			AdminUser teacher = daoFactory.getAdminImpl().selectAdminUser(temp);
			if (teacher == null) {
				response.getWriter().print("0");
			} else {
				if (request.getParameter("teacherPassword").equals(teacher.getUpassword())) {
					session.setAttribute("nowName", teacher.getUname());
					session.setAttribute("type", "0");
					response.getWriter().print("1");
				} else {
					response.getWriter().print("0");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("isTeacherUser方法出错！");
		}
	}

	// 注销
	public void loginOut() {
		try {
			session.setAttribute("nowName", null);
			session.setAttribute("type", null);
			session.setAttribute("studentInfo", null);
			response.getWriter().print("1");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loginOut方法出错！");
		}
	}

	// 查询学生信息
	public void selectStudentInfo() {
		try {
			String className = request.getParameter("className");
			String studentName = request.getParameter("studentName");
			String newPag = request.getParameter("newPag");
			StudentInfoPage temp = new StudentInfoPage(Integer.parseInt(newPag), 10, className, studentName);
			StudentInfoPage studentInfoPage = new DAOFactory().getAdminImpl().selectStudentInfo(temp);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessor() {
				private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

				public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
					return value == null ? "" : sd.format(value);
				}

				public Object processArrayValue(Object value, JsonConfig jsonConfig) {
					return null;
				}
			});
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.getWriter().print(JSONArray.fromObject(studentInfoPage, jsonConfig).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("selectStudentInfo方法出错！");
		}

	}

	// 添加学生信息
	public void saveStudentInfo() {
		try {
			String pj = request.getParameter("pj");
			String class_times = request.getParameter("class_times");
			String open_time = request.getParameter("open_time");
			String com_name = request.getParameter("com_name");
			String man = request.getParameter("man");
			String student_name = request.getParameter("student_name");
			String sex = request.getParameter("sex");
			String card = request.getParameter("card");
			String xue_li = request.getParameter("xue_li");
			String zhuan_ye = request.getParameter("zhuan_ye");
			String biye_time = request.getParameter("biye_time");
			String zhi_cheng = request.getParameter("zhi_cheng");
			String zhi_wu = request.getParameter("zhi_wu");
			String phone = request.getParameter("phone");
			String mail = request.getParameter("mail");
			String is_acee = request.getParameter("is_acee");
			String bukao_time = request.getParameter("bukao_time");
			String bukao_is = request.getParameter("bukao_is");
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setPj(pj);
			studentInfo.setClassTimes(class_times);
			studentInfo.setOpenTime(open_time);
			studentInfo.setComName(com_name);
			studentInfo.setMan(man);
			studentInfo.setStudentName(student_name);
			studentInfo.setSex(sex);
			studentInfo.setCard(card);
			studentInfo.setXueLi(xue_li);
			studentInfo.setZhuanYe(zhuan_ye);
			studentInfo.setBiyeTime(biye_time);
			studentInfo.setZhiCheng(zhi_cheng);
			studentInfo.setZhiWu(zhi_wu);
			studentInfo.setPhone(phone);
			studentInfo.setMail(mail);
			studentInfo.setIsAcee(is_acee);
			studentInfo.setBukaoTime(bukao_time);
			studentInfo.setBukaoIs(bukao_is);
			new DAOFactory().getAdminImpl().saveStudentInfo(studentInfo);
			response.getWriter().print("1");
		} catch (Exception e) {
			System.out.println("saveStudentInfo方法出错！");
		}
	}

	// 添加学生时判断是否添加过
	public void isStudentInfoName() {
		try {
			String name = request.getParameter("name");
			response.getWriter().print(new DAOFactory().getAdminImpl().isStudentInfoName(name));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("isStudentInfoName方法出错！");
		}
	}

	// 删除学生详细信息
	public void deleteStudentInfo() {
		try {
			String deletRow = request.getParameter("deletRow");
			new DAOFactory().getAdminImpl().deletStudentInfo(deletRow);
			response.getWriter().print("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("deleteStudentInfo方法出错！");
		}
	}

	// 更新学生的详细信息
	public void updateStudentInfo() {
		try {
			String id = request.getParameter("id");
			String pj = request.getParameter("pj");
			String class_times = request.getParameter("class_times");
			String open_time = request.getParameter("open_time");
			String com_name = request.getParameter("com_name");
			String man = request.getParameter("man");
			String student_name = request.getParameter("student_name");
			String sex = request.getParameter("sex");
			String card = request.getParameter("card");
			String xue_li = request.getParameter("xue_li");
			String zhuan_ye = request.getParameter("zhuan_ye");
			String biye_time = request.getParameter("biye_time");
			String zhi_cheng = request.getParameter("zhi_cheng");
			String zhi_wu = request.getParameter("zhi_wu");
			String phone = request.getParameter("phone");
			String mail = request.getParameter("mail");
			String is_acee = request.getParameter("is_acee");
			String bukao_time = request.getParameter("bukao_time");
			String bukao_is = request.getParameter("bukao_is");
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setId(Integer.parseInt(id));
			studentInfo.setPj(pj);
			studentInfo.setClassTimes(class_times);
			studentInfo.setOpenTime(open_time);
			studentInfo.setComName(com_name);
			studentInfo.setMan(man);
			studentInfo.setStudentName(student_name);
			studentInfo.setSex(sex);
			studentInfo.setCard(card);
			studentInfo.setXueLi(xue_li);
			studentInfo.setZhuanYe(zhuan_ye);
			studentInfo.setBiyeTime(biye_time);
			studentInfo.setZhiCheng(zhi_cheng);
			studentInfo.setZhiWu(zhi_wu);
			studentInfo.setPhone(phone);
			studentInfo.setMail(mail);
			studentInfo.setIsAcee(is_acee);
			studentInfo.setBukaoTime(bukao_time);
			studentInfo.setBukaoIs(bukao_is);
			new DAOFactory().getAdminImpl().updateStudentInfo(studentInfo);
			response.getWriter().print("1");
		} catch (Exception e) {
			System.out.println("updateStudentInfo方法出错！");
		}
	}

	// 导出学生EXL
	public void outStudentExl() {
		try {
			String className = request.getParameter("className");
			String studentName = request.getParameter("studentName");
			List<StudentInfo> list = new DAOFactory().getAdminImpl().selectStudentInfo(className, studentName);
			HSSFWorkbook wb = new POI_StudentInfo().getExcel(list);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			String filedisplay = "项目:" + (className.equals("") ? "未知" : className) + "-班次:" + (studentName.equals("") ? "未知" : studentName) + "-学生信息表.xls";
			filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
			OutputStream out = response.getOutputStream();
			wb.write(out);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("outStudentExl方法出错！");
			e.printStackTrace();
		}
	}

	// 查询企业培训信息
	public void selectComparyInfo() {
		try {
			String className = request.getParameter("className");
			String studentName = request.getParameter("studentName");
			String newPag = request.getParameter("newPag");
			ComparyInfoPage temp = new ComparyInfoPage(Integer.parseInt(newPag), 10, className, studentName);
			ComparyInfoPage studentInfoPage = new DAOFactory().getAdminImpl().selectComparyInfo(temp);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessor() {
				private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

				public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
					return value == null ? "" : sd.format(value);
				}

				public Object processArrayValue(Object value, JsonConfig jsonConfig) {
					return null;
				}
			});
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.getWriter().print(JSONArray.fromObject(studentInfoPage, jsonConfig).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("selectComparyInfo方法出错！");
		}

	}

	// 添加企业培训信息
	public void saveComparyInfo() {
		try {
			String comName = request.getParameter("comName");
			String comMan = request.getParameter("comMan");
			String zhiWu = request.getParameter("zhiWu");
			String zuoJi = request.getParameter("zuoJi");
			String shouJi = request.getParameter("shouJi");
			String qq = request.getParameter("qq");
			String weiXin = request.getParameter("weiXin");
			String email = request.getParameter("email");
			String diZhi = request.getParameter("diZhi");
			String faPiao = request.getParameter("faPiao");
			String beiZhu = request.getParameter("beiZhu");
			ComparyInfo comparyInfo = new ComparyInfo(comName, comMan, zhiWu, zuoJi, shouJi, qq, weiXin, email, diZhi, faPiao, beiZhu);
			new DAOFactory().getAdminImpl().saveComparyInfo(comparyInfo);
			response.getWriter().print("1");
		} catch (Exception e) {
			System.out.println("saveComparyInfo方法出错！");
		}
	}

	// 删除企业培训信息
	public void deleteComparyInfo() {
		try {
			String deletRow = request.getParameter("deletRow");
			new DAOFactory().getAdminImpl().deletComparyInfo(deletRow);
			response.getWriter().print("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("deleteComparyInfo方法出错！");
		}
	}

	// 更新企业培训信息
	public void updateComparyInfo() {
		try {
			String id = request.getParameter("id");
			String comName = request.getParameter("comName");
			String comMan = request.getParameter("comMan");
			String zhiWu = request.getParameter("zhiWu");
			String zuoJi = request.getParameter("zuoJi");
			String shouJi = request.getParameter("shouJi");
			String qq = request.getParameter("qq");
			String weiXin = request.getParameter("weiXin");
			String email = request.getParameter("email");
			String diZhi = request.getParameter("diZhi");
			String faPiao = request.getParameter("faPiao");
			String beiZhu = request.getParameter("beiZhu");
			ComparyInfo comparyInfo = new ComparyInfo(Integer.parseInt(id), comName, comMan, zhiWu, zuoJi, shouJi, qq, weiXin, email, diZhi, faPiao, beiZhu);
			new DAOFactory().getAdminImpl().updateComparyInfo(comparyInfo);
			response.getWriter().print("1");
		} catch (Exception e) {
			System.out.println("updateComparyInfo方法出错！");
		}
	}

	// 导出企业培训EXL
	public void outComparyInfoExl() {
		try {
			String className = request.getParameter("className");
			String studentName = request.getParameter("studentName");
			List<ComparyInfo> list = new DAOFactory().getAdminImpl().selectComparyInfo(className, studentName);
			HSSFWorkbook wb = new POI_ComparyInfo().getExcel(list);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			String filedisplay = "企业名称:" + (className.equals("") ? "未知" : className) + "-企业联系人:" + (studentName.equals("") ? "未知" : studentName) + "-学生信息表.xls";
			filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
			OutputStream out = response.getOutputStream();
			wb.write(out);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("outComparyInfoExl方法出错！");
			e.printStackTrace();
		}
	}

}
