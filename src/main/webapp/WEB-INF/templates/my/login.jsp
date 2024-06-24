<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="actionUrl" value="login" />
<fmt:setBundle basename="messages.commons" />
<layout:main title="my-로그인">
    <h1>my-로그인</h1>
    <form name="frm" method="post" action="${actionUrl}">
        <fmt:message key="이메일" /><input type="text" name="email">
        <fmt:message key="비밀번호" /><input type="password" name="password">
        <button type="submit"><fmt:message key="로그인" /></button>
    </form>
</layout:main>