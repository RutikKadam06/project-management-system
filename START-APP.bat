@echo off
echo ========================================
echo Project Management System - MongoDB
echo ========================================
echo.
echo Checking MongoDB...
netstat -ano | findstr :27017 >nul
if errorlevel 1 (
    echo ERROR: MongoDB is not running on port 27017
    echo Please start MongoDB first!
    pause
    exit /b 1
)
echo MongoDB: Running ✓
echo.
echo Checking port 8080...
netstat -ano | findstr :8080 >nul
if not errorlevel 1 (
    echo WARNING: Port 8080 is in use
    echo Attempting to free port...
    for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8080') do (
        taskkill /F /PID %%a >nul 2>&1
    )
    timeout /t 2 >nul
)
echo Port 8080: Available ✓
echo.
echo Starting application...
echo Access at: http://localhost:8080
echo Press Ctrl+C to stop
echo.
"C:\Program Files\Maven\apache-maven-3.9.12\bin\mvn.cmd" spring-boot:run
pause
