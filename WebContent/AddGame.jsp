<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>start new game</title>
</head>
 
<body>
<h2>Chose players</h2>
<s:actionerror />
<s:form action="addUser" method="post">
    <s:textfield name="login" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
    <s:password name="confirmpassword" key="label.password.confirm" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>

</br>
</br>


</body>
</html>