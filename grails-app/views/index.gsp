<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Lentoyhtiö Lentsikka Oy</title><%-- man! --%>
</head>
<body>
    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Lentsikan Hallintasivusto</h1><%-- man! --%>

            <div id="controllers" role="navigation">
                <h2>Saatavilla olevat näkymät: </h2><%-- man! --%>
                <ul>
                        <li class="controller">
                            <g:link controller="Flight">Lennot</g:link><%-- man! --%>
                        </li>
                        <li class="controller"><%-- man! --%>
                            <g:link controller="City">Kaupungit</g:link><%-- man! --%>
                        </li><%-- man! --%>
                </ul>
            </div>
        </section>
    </div>

</body>
</html>
