<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>start new game</title>

</head>
 
<body>
<h2>Chose players</h2>

					<div class="well">
					<table id="users" class="table table-striped table-bordered table-condensed">
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
						<s:iterator var="user" value="%{#session.users}">
							<tr id="user_<s:property value="%{#user.id}" />">
								<td><s:property value="%{#user.firstname}" />
								</td>
								<td><s:property value="%{#user.login}" />
								</td>
								<td><s:property value="%{#user.lastname}" />
								</td>
								<td><s:a href="#" cssClass="btn btn-danger" onclick="chosePlayer(%{#user.id});">
											<i class="icon-trash icon-white"></i>
											<s:text name="chose" />
										</s:a>
										<s:a href="#" cssClass="btn btn-danger" onclick="removePlayer(%{#user.id});">
											<i class="icon-trash icon-white"></i>
											<s:text name="remove" />
										</s:a>
								</td>
								
							</tr>
						</s:iterator>
					</table>
					</div>

</br>
</br>

<h2>Players</h2>

<div class="well">
					<table id="players" class="table table-striped table-bordered table-condensed">
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
					</table>
</div>

<script src="js/jquery-1.7.1.js"></script>
<script type="text/javascript">
function chosePlayer(id){
	console.log(id);
	$("#user_"+id).appendTo("#players");
};

function removePlayer(id){
	console.log(id);
	$("#user_"+id).appendTo("#users");
};
</script>
</body>
</html>