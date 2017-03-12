<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'flight.label', default: 'Flight')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <script type="text/javascript"><!-- man -->
            $(document).ready(function(){<!-- man -->
                $('#openPlane').click(function(){<!-- man -->
                    $('#getplane').toggle();<!-- man -->
                });
                $('#openPilot').click(function(){<!-- man -->
                    $('#getpilot').toggle();<!-- man -->
                });
                $('#openCoPilot').click(function(){<!-- man -->
                    $('#getcopilot').toggle();<!-- man -->
                });
                $('#getPilot').click(function(){<!-- man -->
                    var URL="${createLink(controller:'flight',action:'getPilots')}";<!-- man -->
                    $.ajax({<!-- man -->
                        url:URL,<!-- man -->
                        data: {firstName:$("#searchPilotFirstName").val(), lastName:$("#searchPilotLastName").val()},<!-- man -->
                            success: function(resp){
                                console.log(resp);<!-- man -->
                                resp.forEach(function(pilot){<!-- man -->
                                    console.log("Pilot: " + pilot);<!-- man -->
                                    console.log("Pilot JSON " + JSON.stringify(pilot));<!-- man -->
                                    $('#pilots').append($("<option></option>").attr("value",pilot.id+","+pilot.firstName + "," +pilot.lastName).text(pilot.firstName + " " +pilot.lastName));<!-- man -->
                                    $('#pilots').trigger("chosen:updated");<!-- man -->
                                });
                            }
                    });
                });
                $('#getCoPilot').click(function(){<!-- man -->
                    var URL="${createLink(controller:'flight',action:'getPilots')}";<!-- man -->

                    $.ajax({<!-- man -->
                        url:URL,<!-- man -->
                        data: {firstName:$("#searchCoPilotFirstName").val(), lastName:$("#searchCoPilotLastName").val()},<!-- man -->
                            success: function(resp){
                                console.log(resp);<!-- man -->
                                resp.forEach(function(pilot){<!-- man -->
                                    console.log("Pilot: " + pilot);<!-- man -->
                                    console.log("Pilot JSON " + JSON.stringify(pilot));<!-- man -->
                                    $('#copilots').append($("<option></option>").attr("value",pilot.id+","+pilot.firstName + "," +pilot.lastName).text(pilot.firstName + " " +pilot.lastName));<!-- man -->
                                    $('#copilots').trigger("chosen:updated");<!-- man -->
                                });
                            }
                    });
                });
                $('#getAirplane').click(function(){<!-- man -->
                    var URL="${createLink(controller:'flight',action:'getAirplanes')}";<!-- man -->
                    $("#planes").innerHtml = ''<!-- man -->

                    $.ajax({<!-- man -->
                        url:URL,<!-- man -->
                        data: {serialNumber:$("#searchPlaneSN").val()},<!-- man -->
                            success: function(resp){<!-- man -->
                                console.log(resp);<!-- man -->

                                resp.forEach(function(plane){<!-- man -->
                                    console.log("Plane: " + plane);<!-- man -->
                                    console.log("Plane JSON " + JSON.stringify(plane));<!-- man -->
                                    $('#planes').append($("<option></option>").attr("value",plane.serialNumber+","+plane.nickname).text(plane.serialNumber));<!-- man -->
                                    $('#planes').trigger("chosen:updated");<!-- man -->
                                });
                            }
                    });
                });
                $('#selectAirplane').click(function(){
                    var selectedValue = $('#planes').find(":selected").val();
                    console.log(selectedValue);
                    var split = selectedValue.split(",");
                    $('#airplaneNickname').val(split[1]);
                    $('#airplaneId').val(split[0]);
                    $('#getplane').toggle();<!-- man -->
                });
                $('#selectPilot').click(function(){
                    var selectedValue = $('#pilots').find(":selected").val();
                    var splitt = selectedValue.split(",");
                    console.log(splitt[0]);
                    $('#pilotId').val(splitt[0]);
                    $('#pilotName').val(splitt[1] + " " + splitt[2]);
                    $('#getpilot').toggle();<!-- man -->
                });
                $('#selectCoPilot').click(function(){
                    var selectedValue = $('#copilots').find(":selected").val();
                    var split = selectedValue.split(",");
                    $('#copilotId').val(split[0]);
                    $('#copilotName').val(split[1] + " " + split[2]);
                    $('#getcopilot').toggle();<!-- man -->
                });
            });
        </script><!-- man -->
        <a href="#create-flight" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-flight" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.flight}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.flight}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <f:field bean="flight" property="origin"><!-- man -->
                        <g:select name="origin" from="${cityInstanceList}" optionKey="id"/><!-- man -->
                    </f:field><!-- man -->
                    <f:field bean="flight" property="destination"><!-- man -->
                        <g:select name="destination" from="${cityInstanceList}" optionKey="id"/><!-- man -->
                    </f:field><!-- man -->
                    <f:field bean="flight" property="pilotId"/><!-- man -->
                    <f:field bean="flight" property="pilotName"/><!-- man -->
                    <f:field bean="flight" property="copilotId"/><!-- man -->
                    <f:field bean="flight" property="copilotName"/><!-- man -->
                    <f:field bean="flight" property="airplaneId"/><!-- man -->
                    <f:field bean="flight" property="airplaneNickname"/><!-- man -->


                    <button type="button" id="openPlane">Valitse lentokone</button><!-- man -->
                    <button type="button" id="openPilot">Valitse lentäjä</button><!-- man -->
                    <button type="button" id="openCoPilot">Valitse perämies</button><!-- man -->
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>

        <div id="getplane" class="findPlaneDiv" role="dialog"><!-- man -->
            Hae lentokone<br/><!-- man -->
            <input type="text" id="searchPlaneSN"></input><br/><!-- man -->
            <button id="getAirplane">Hae</button><br/><!-- man -->
            <select id="planes"></select><br/><!-- man -->
            <button id="selectAirplane">Aseta</button><br/><!-- man -->
        </div><!-- man -->

        <div id="getpilot" class="findPilotDiv" role="dialog"><!-- man -->
            Hae lentäjä<br/><!-- man -->
            <input type="text" id="searchPilotFirstName"></input><br/><!-- man -->
            <input type="text" id="searchPilotLastName"></input><br/><!-- man -->
            <button id="getPilot">Hae</button><br/><!-- man -->
            <select id="pilots"></select><br/><!-- man -->
            <button id="selectPilot">Aseta</button><br/><!-- man -->
        </div><!-- man -->

        <div id="getcopilot" class="findCoPilotDiv" role="dialog"><!-- man -->
            Hae perämies<br/><!-- man -->
            <input type="text" id="searchCoPilotFirstName"></input><br/><!-- man -->
            <input type="text" id="searchCoPilotLastName"></input><br/><!-- man -->
            <button id="getCoPilot">Hae</button><br/><!-- man -->
            <select id="copilots"></select><br/><!-- man -->
            <button id="selectCoPilot">Aseta</button><br/><!-- man -->
        </div><!-- man -->
    </body>
</html>
