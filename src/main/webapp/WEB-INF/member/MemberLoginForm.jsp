<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function register(){
		location.href="registerForm.me"; // => MemberRegisterController.java
	}
	
	function memberList(){
		location.href="list.me";
	}
</script>
WEB-INF\member\MemberLoginForm.jsp<br><br><br>

<form method="post" action="loginForm.me">
	<table border="1" width="40%" height="150px">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="kim"></td>
		</tr>
		
		<tr>
			<td>비번</td>
			<td><input type="password" name="password"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onClick="register()">
				<input type="button" value="회원목록보기"  onClick="memberList()">   
			</td>
		</tr>
	</table>
</form>




