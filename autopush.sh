while true
do
    git add .
    git commit -m "Otomatik güncelleme $(date)"
    git push
    sleep 60
done

