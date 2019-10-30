package com.internousdev.georgia.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.georgia.dao.UserInfoDAO;
import com.internousdev.georgia.util.CommonUtility;
import com.internousdev.georgia.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware{
	private String userId;
	private String password;
	private String passwordNew;
	private String passwordNewConfirm;
	private String errorMessage;
	private String passwordConceal;
	private List<String> stringListUserId = new ArrayList<String>();
	private List<String> stringListPassword = new ArrayList<String>();
	private List<String> stringListPasswordNew = new ArrayList<String>();
	private List<String> stringListPasswordNewConfirm = new ArrayList<String>();
	private Map<String,Object>session;

	public String execute(){

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		InputChecker inputChecker = new InputChecker();
		CommonUtility commonUtility = new CommonUtility();
		String ret = ERROR;

		//jsp・メソッドの引数等で利用するためセッションに格納//
		session.put("resetPasswordUserId", userId);

		//入力された文字が入力規則にしたがっているか判定//
		stringListUserId = inputChecker.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false);
		stringListPassword = inputChecker.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false, false);
		stringListPasswordNew = inputChecker.doCheck("新しいパスワード", passwordNew, 1, 16, true, false, false, true, false, false);
		stringListPasswordNewConfirm = inputChecker.doCheck("新しいパスワード（再確認）", passwordNewConfirm, 1, 16, true, false, false, true, false, false);

		if(stringListUserId .size()>0
			|| stringListPassword .size()>0
			|| stringListPasswordNew .size()>0
			|| stringListPasswordNewConfirm .size()>0){
			return ret;
		}

		//入力された情報のユーザーがいるか判定。いる場合、新規パスワードと確認用のパスワードが一致しているか判定//
		if(!userInfoDAO.isExistsUserInfo(userId, password)){
			errorMessage = "ユーザーIDまたは現在のパスワードが異なります。";
		}else{
			errorMessage = inputChecker.doPasswordCheck(passwordNew, passwordNewConfirm);
		}

		/*
		 *  エラーメッセージが何もない場合、次の確認画面に遷移
		 *  確認画面でパスワードを一文字目以外*で表示するための変換
		 *  新規パスワードはメソッドに利用するためセッションに格納
		 */
		if(errorMessage != null){
			return ret;
		}else{
			passwordConceal = commonUtility.concealPassword(passwordNew);
			session.put("resetPasswordPassword", passwordNew);
			ret = SUCCESS;
		}

		return ret;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getPasswordNew(){
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew){
		this.passwordNew = passwordNew;
	}

	public String getPasswordNewConfirm(){
		return passwordNewConfirm;
	}
	public void setPasswordNewConfirm(String passwordNewConfirm){
		this.passwordNewConfirm = passwordNewConfirm;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getPasswordConceal(){
		return passwordConceal;
	}
	public void setPasswordConceal(String passwordConceal){
		this.passwordConceal = passwordConceal;
	}

	public List<String> getStringListUserId(){
		return stringListUserId;
	}
	public void  setStringListUserId(List<String>stringListUserId){
		this.stringListUserId = stringListUserId;
	}

	public List<String> getStringListPassword(){
		return stringListPassword;
	}
	public void setStringListPassword(List<String>stringListPassword){
		this.stringListPassword = stringListPassword;
	}

	public List<String> getStringListPasswordNew(){
		return stringListPasswordNew;
	}
	public void setStringListPasswordNew(List<String>stringListPasswordNew){
		this.stringListPasswordNew = stringListPasswordNew;
	}

	public List<String> getStringListPasswordNewConfirm(){
		return stringListPasswordNewConfirm;
	}
	public void setStringListPasswordNewConfirm(List<String>stringListPasswordNewConfirm){
		this.stringListPasswordNewConfirm = stringListPasswordNewConfirm;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
}

