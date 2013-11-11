<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>start new game</title>
<script type="text/javascript">
function chosePlayer(id) {
	alert("Player added " + id);
} 
</script>
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

					<div class="well">
					<table class="table table-striped table-bordered table-condensed">
						<tr>
							<th width="20%"><B>first name</B>
							</th>
							<th width="50%"><B>login</B>
							</th>
							<th width="30%"><B>last name</B>
							</th>
							<th width="0%">
							</th>
							
						</tr>
						<s:iterator var="user" value="%{#request.users}">
							<tr id="user_%{#user.id}">
								<td><s:property value="%{#user.firstname}" />
								</td>
								<td><s:property value="%{#user.login}" />
								</td>
								<td><s:property value="%{#user.lastname}" />
								</td>
								<td><s:a href="#" cssClass="btn btn-danger" onclick="chosePlayer(%{#user.id});">
											<i class="icon-trash icon-white"></i>
											<s:text name="cancel.order" />
										</s:a>
								</td>
								<td><s:if
										test="%{#order.orderStatus == @by.gsu.epamlab.model.beans.OrderStatusEnum@ORDERED || #order.orderStatus == @by.gsu.epamlab.model.beans.OrderStatusEnum@NEW}">
										<s:url value="orderChangesCancel" var='cancelLink'>
											<s:param name="orderId" value="%{#order.id}" />
										</s:url>
										<s:a href="%{cancelLink}" cssClass="btn btn-danger">
											<i class="icon-trash icon-white"></i>
											<s:text name="cancel.order" />
										</s:a>
										<BR>
									</s:if> <s:else>
										<s:text name="no.order.action" />
									</s:else></td>
							</tr>
						</s:iterator>
					</table>
					</div>

</br>
</br>


</body>
</html>