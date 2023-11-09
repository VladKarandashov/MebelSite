#!/bin/bash
echo "Начинаю выполнение скрипта запуска"
sudo chmod +x mvnw

echo "Подтягиваю изменения из Git"
git pull

echo "Собираем сборку"
./mvnw clean install
sleep 3
echo "Убиваем все приложения"
tmux kill-server
sleep 3
tmux ls
sleep 3

echo "Запускаем приложение"
# Запускаем новую сессию tmux в фоновом режиме
tmux new-session -d -s mebel-site './mvnw spring-boot:run > "$(date +'%Y-%m-%d%H-%M-%S').log"'
# Отображаем список сессий tmux
sleep 3
tmux list-sessions
tmux ls