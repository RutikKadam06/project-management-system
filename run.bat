@echo off
echo ========================================
echo Project Management System
echo ========================================
echo.
echo Starting application...
echo.
echo Make sure MySQL is running!
echo Default database: pms_db
echo Default port: 8080
echo.
echo Access the application at: http://localhost:8080
echo.
echo Press Ctrl+C to stop the application
echo.
cd /d "%~dp0"
if exist "mvnw.cmd" (
    call mvnw.cmd spring-boot:run
) else (
    mvn spring-boot:run
)
pause
