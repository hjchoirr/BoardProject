<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='게시판글쓰기' />
<c:url var="actionUrl" value="/board/boardsave" />
<layout:main title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
        <form name="frmBoardSave" method="post" action="${actionUrl}" enctype="multipart/form-data" autocomplete="off" target="ifrmProcess">
            <dl>
                <dt>
                    <fmt:message key="제목" />
                </dt>
                <dd>
                    <input type="text" name="artTitle">

                </dd>
            </dl>
            <dl>
                <dt>
                    <fmt:message key="작성자" />
                </dt>
                <dd>
                        <input type="text" name="userName" value="${member.userName}" readonly>
                </dd>
            </dl>
            <dl>
                <dt>
                    <fmt:message key="본문" />
                </dt>
                <dd>
                    <textarea name="artBody"  rows="4" cols="50"></textarea>
                </dd>
            </dl>
            <dl>
                <dt>
                    <fmt:message key="첨부파일"/>
                </dt>
                <dd>
                    <input type="file" name="file"><br>
                </dd>

            </dl>
            <div class="button-group">
                <button type="reset">
                    <fmt:message key="다시입력" />
                </button>
                <button type="submit">
                    <fmt:message key="작성하기" />
                </button>
            </div>
            <input type="hidden" name="userNo" value="${member.userNo}">
        </form>
    </section>
</layout:main>