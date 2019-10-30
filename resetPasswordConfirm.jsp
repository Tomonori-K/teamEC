<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/button.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/title.css">
<link rel="stylesheet" type="text/css" href="./css/verticalList.css">
<title>パスワード再設定確認画面</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<h1>パスワード再設定確認画面</h1>

	<!-- 入力内容確認テーブル表示 -->
	<s:form id="resetPasswordForm">
		<table class="vertical_list">
			<tr>
				<th>ユーザーID</th>
				<td><s:property value="userId"/></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><s:property value="passwordConceal"/></td>
			</tr>
		</table>
		<br>
		<!-- 遷移先ボタン -->
		<div id="btn_position">
			<s:submit value="パスワード再設定" class="submit_btn" onclick="goResetPasswordCompleteAction()"/>
		</div>
		<div id="btn_position">
			<s:submit value="戻る" class="submit_btn" onclick="goResetPasswordAction()">
				<s:hidden id="backFlag" name="backFlag" value="1"/>
			</s:submit>
		</div>
	</s:form>
<script src="./js/resetPassword.js"></script>
</body>
</html>