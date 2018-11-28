<%@tag description="Admin Layout Tag" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layouts/" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>
    <jsp:doBody/>
    <div>
        <input class="text-field"
               type="text"
        <l:if test="${empty myAttr}" >
            <c:set var="name" value="text field" />
        </l:if>
               name="text_field" required>
    </div>