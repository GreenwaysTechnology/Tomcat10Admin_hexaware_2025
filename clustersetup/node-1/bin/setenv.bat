@echo off

set CATALINA_OPTS=%CATALINA_OPTS% -Dcom.sun.management.jmxremote
set CATALINA_OPTS=%CATALINA_OPTS% -Dcom.sun.management.jmxremote.port=9000
set CATALINA_OPTS=%CATALINA_OPTS% -Dcom.sun.management.jmxremote.authenticate=false
set CATALINA_OPTS=%CATALINA_OPTS% -Dcom.sun.management.jmxremote.ssl=false
