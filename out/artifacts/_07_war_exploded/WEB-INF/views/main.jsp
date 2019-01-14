<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2019/1/11Wrapper
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:debug/></br>

hello world</br>
EL表达式获取username:${sessionScope.USER_IN_SESSION.username} </br>

<p>valueStack context区域数据获取</p>
OGNL表达式获取username:<s:property value="#session.USER_IN_SESSION.username"/></br>
OGNL表达式获取password:<s:property value="#session.USER_IN_SESSION.password"/></br>


<p>valueStack root区域数据获取</p>
VS_Add0:<s:property value="[0].top"/></br>
VS_Add1:<s:property value="[1].top"/></br>
VS_Add2:<s:property value="[2].top"/></br>
VS_Add3:<s:property value="[3].top"/></br>
VS_Add4:<s:property value="[4].top"/></br>
vs_set:<s:property value="VS_Set"/></br>
VS_getContext_Put:<s:property value="VS_getContext_Put"/></br>
VS_ActionContext_getContext_Put:<s:property value="VS_ActionContext_getContext_Put"/></br>
</body>
</html>
