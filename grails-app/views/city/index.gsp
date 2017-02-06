<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:message code="default.list.search"/></li><!-- man! -->
                <li><g:form name="findCity" action="findCity" method="GET"><!-- man! -->
                    <g:field type="text" name="text" required="" value="${text}"/><!-- man! -->
                </g:form></li><!-- man! -->
                <li><g:link class="city"><input type="button" value="Nollaa"/></g:link></li><!-- man! -->
            </ul>
        </div>

        <div id="list-city" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${cityList}" properties="['cityName', 'countryName', 'airfieldName']" /> <!-- man! -->

            <div class="pagination">
                <g:paginate total="${cityCount ?: 0}" />
            </div>
        </div>
    </body>
</html>