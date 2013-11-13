<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login Application</title>
</head>
 
<body>
<h2>Struts 2 - Login Application</h2>
<s:actionerror />
<s:form name="loginform" action="login" method="post" namespace="/">
    <s:textfield name="username" key="label.username" maxlength="25" required="true" cssClass="span3"/>
	<BR>
	<s:password name="password" key="label.password" maxlength="25" required="true" cssClass="span3"/>
	<BR>
    <s:submit method="execute" key="label.login" align="center" cssClass="btn btn-warning"/>
</s:form>

</br>
</br>


<s:a href="addUser-page">
	<s:text name="welcome.addUser" />
</s:a>
</br>

<s:a href="addGame-page">
	<s:text name="welcome.addGame" />
</s:a>

</br>

<s:a href="addGame-page">
	<s:text name="welcome.addGame" />
</s:a>

</body>
</html>