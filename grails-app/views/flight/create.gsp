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
                    $('#getPilot').click(function(){<!-- man -->
                        var URL="${createLink(controller:'flight',action:'getPilots')}";<!-- man -->

                        $.ajax({<!-- man -->
                            url:URL,<!-- man -->
                            data: {firstName:$("#searchPilotFirstName").value, lastName:$("#searchPilotLastName").value},<!-- man -->
                            success: function(resp){
                                console.log(resp);<!-- man -->
                                resp.forEach(function(pilot){<!-- man -->
                                    console.log("Pilot: " + pilot);<!-- man -->
                                    console.log("Pilot JSON " + JSON.stringify(pilot));<!-- man -->
                                    $('#pilots').append($("<option></option>").attr("value",pilot.firstName + " " +pilot.lastName).text(pilot.firstName + " " +pilot.lastName));<!-- man -->
                                    $('#pilots').trigger("chosen:updated");<!-- man -->
                                });
                            }
                        });
                    });
                });
        </script><!-- man -->
        <script type="text/javascript"><!-- man -->
            $(document).ready(function(){<!-- man -->
                $('#getAirplane').click(function(){<!-- man -->
                    var URL="${createLink(controller:'flight',action:'getAirplanes')}";<!-- man -->
                    $("#planes").innerHtml = ''<!-- man -->

                    $.ajax({<!-- man -->
                        url:URL,<!-- man -->
                        data: {serialNumber:$("#searchPlaneSN").value},<!-- man -->
                        success: function(resp){<!-- man -->
                            console.log(resp);<!-- man -->

                            resp.forEach(function(plane){<!-- man -->
                                console.log("Plane: " + plane);<!-- man -->
                                console.log("Plane JSON " + JSON.stringify(plane));<!-- man -->
                                $('#planes').append($("<option></option>").attr("value",plane.serialNumber).text(plane.serialNumber));<!-- man -->
                                $('#planes').trigger("chosen:updated");<!-- man -->
                            });
                        }
                    });
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
                    <f:all bean="flight"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
        <div id="get-plane"><!-- man -->
            <input type="text" id="searchPlaneSN"></input><!-- man -->
            <button id="getAirplane">Hae</button><!-- man -->
            <select id="planes"/><!-- man -->
        </div><!-- man -->
        <div id="get-pilot"><!-- man -->
            <input type="text" id="searchPilotFirstName"></input><!-- man -->
            <input type="text" id="searchPilotLastName"></input><!-- man -->
            <button id="getPilot">Hae</button><!-- man -->
            <select id="pilots"/><!-- man -->
        </div><!-- man -->
        <div id="get-copilot"><!-- man -->
            <input type="text" id="searchPilotFirstName"></input><!-- man -->
            <input type="text" id="searchPilotLastName"></input><!-- man -->
            <button id="getPilot">Hae</button><!-- man -->
            <select id="copilots"/><!-- man -->
        </div><!-- man -->
    </body>
</html>
