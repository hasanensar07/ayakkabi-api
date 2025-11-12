@echo off
cd /d "D:\Spring Dersleri\ayakkabi-api"
git add .
git commit -m "Otomatik: %date% %time%"
git push origin main
pause
