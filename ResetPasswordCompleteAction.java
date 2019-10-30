package com.internousdev.georgia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.georgia.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	public String execute(){
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		String ret = ERROR;
		boolean result;

		//DBにパスワード再設定の内容を反映//
		result = userInfoDAO.resetPassword(session.get("resetPasswordPassword").toString(),session.get("resetPasswordUserId").toString());
		if(result){
			ret = SUCCESS;
		}

		//パスワード再設定機能において利用するセッションを削除//
		session.remove("resetPasswordUserId");
		session.remove("resetPasswordPassword");

		return ret;
	}

	public Map<String,Object>getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
