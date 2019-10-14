package dhee_PJ3;

import org.junit.Test;

import com.dhee.dbConnection.DBO;

public class TestDome {
	@Test
	public void test1(){
		for(int i=0;i<50;i++){
			new DBO().save("INSERT INTO student_info (pj,class_times,open_time,com_name,man,student_name,sex,card,xue_li,zhuan_ye,biye_time,zhi_cheng,zhi_wu,phone,mail,is_acee,bukao_time,bukao_is) VALUES ('企业管理','第"+(i+1)+"期','2017-03-21至2017-03-13','大连华信','赵磊/12321232312342','赵明','girl','21321','大专','软禁啊工程','2017-03-07','初级工程师','项目经理','15041914007','123@123','false','2017-03-20','false')");
		}
	}
	
	@Test
	public void test2(){
		for(int i=0;i<50;i++){
			new DBO().save("INSERT INTO compary_info (com_name,com_man,zhi_wu,zuo_ji,shou_ji,qq,wei_xin,email,di_zhi,fa_piao,bei_zhu) VALUES ('大话名字','张飞"+(i+1)+"','将军','123121','31213','1231412','12314123','123@123','234231','123412','123412321')");
		}
	}

}
