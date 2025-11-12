#!/bin/bash
cd "/d/Spring Dersleri/ayakkabi-api"
git add .
git commit -m "Otomatik güncelleme $(date)"
git push origin main
