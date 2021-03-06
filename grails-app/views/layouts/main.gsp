<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Lentsikka Oy"/><%-- man! --%>
    </title>

    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>
    <asset:javascript src="jquery-2.2.0.min.js"/><%-- man! --%>

    <g:layoutHead/>
</head>
<body>
    <div align="right"><%-- man! --%>
            <g:img dir="images" file="lentokonelogo.jpg"/><%-- man! --%>
        </div><%-- man! --%>
    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
