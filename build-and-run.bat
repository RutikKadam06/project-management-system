@echo off
echo ========================================
echo Building Project Management System
echo ========================================
echo.

REM Check if Maven is available
where mvn >nul 2>&1
if %ERRORLEVEL% EQU 0 (
    echo Maven found. Building with Maven...
    call mvn clean package -DskipTests
    if %ERRORLEVEL% EQU 0 (
        echo.
        echo Build successful! Starting application...
        echo Access at: http://localhost:8080
        echo.
        java -jar target\project-management-system-1.0.0.jar
    ) else (
        echo Build failed!
        pause
    )
) else (
    echo Maven not found. Please install Maven or use an IDE to run the project.
    echo.
    echo Alternative: Import the project into IntelliJ IDEA or Eclipse and run ProjectManagementApplication.java
    pause
)
