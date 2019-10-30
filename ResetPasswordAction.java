package com.internousdev.georgia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	public String backFlag = "0";
	private Map<String,Object>session;

	public String execute(){
		String ret ;

		//パスワード再設定画面でのユーザーIDを表示するか判定//
		if(backFlag.equals("0")){
			session.remove("resetPasswordUserId");
		}

		ret = SUCCESS;

		return ret;
	}

	public String getBackFlag(){
		return backFlag;
	}
	public void setBackFlag(String backFlag){
		this.backFlag = backFlag;
	}

	public Map<String,Object>getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
