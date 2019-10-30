<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/button.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/message.css">
<link rel="stylesheet" type="text/css" href="./css/title.css">
<link rel="stylesheet" type="text/css" href="./css/verticalList.css">
<title>パスワード再設定画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>パスワード再設定画面</h1>

	<!--  ResetPasswordConfirmActionでのエラー判定結果表示  -->
	<s:if test="errorMessage!=null">
		<div class="message_red"><p><s:property value="errorMessage"/></p></div>
	</s:if>

	<s:if test="stringListUserId!=null && stringListUserId.size()>0">
		<div class="message_red">
			<s:iterator value="stringListUserId">
				<p><s:property /><br></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test="stringListPassword!=null && stringListPassword.size()>0">
		<div class="message_red">
			<s:iterator value="stringListPassword">
				<p><s:property /><br></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test="stringListPasswordNew!=null && stringListPasswordNew.size()>0">
		<div class="message_red">
			<s:iterator value="stringListPasswordNew">
				<p><s:property /><br></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test="stringListPasswordNewConfirm!=null && stringListPasswordNewConfirm.size()>0">
		<div class="message_red">
			<s:iterator value="stringListPasswordNewConfirm">
				<p><s:property /><br></p>
			</s:iterator>
		</div>
	</s:if>

	<!-- パスワード再設定入力フォーム -->
	<s:form action="ResetPasswordConfirmAction">
		<table class="vertical_list">
		<tr>
			<th>ユーザーID</th>
			<td><s:textfield id="input" name="userId" value="%{#session.resetPasswordUserId}" placeholder="ユーザーID"/></td>
		</tr>
		<tr>
			<th>現在のパスワード</th>
			<td><s:password id="input" name="password" placeholder="現在のパスワード"/></td>

		</tr>
		<tr>
			<th>新しいパスワード</th>
			<td><s:password id="input" name="passwordNew" placeholder="新しいパスワード"/></td>
		</tr>
		<tr>
			<th>（再確認）</th>
			<td><s:password  id="input" name="PasswordNewConfirm" placeholder="新しいパスワード（再確認用）"/></td>
		</tr>

		</table>
		<br>
		<div id="btn_position"><s:submit value="確認" class="submit_btn"/></div>
	</s:form>
</body>
</html>