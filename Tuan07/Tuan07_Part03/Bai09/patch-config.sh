#!/bin/bash

CONTAINER_NAME=nextcloud-app
CONFIG_PATH=/var/www/html/config/config.php

echo "⚙️ Đang chèn cấu hình vào $CONFIG_PATH trong container $CONTAINER_NAME ..."

docker exec -it $CONTAINER_NAME bash -c "
  sed -i \"s|'trusted_domains' =>.*|  'trusted_domains' => array (0 => 'localhost', 1 => '127.0.0.1'),|\" $CONFIG_PATH ||
  echo \"  'trusted_domains' => array (0 => 'localhost', 1 => '127.0.0.1'),\" >> $CONFIG_PATH
"

docker exec -it $CONTAINER_NAME bash -c "
  grep -q 'overwrite.cli.url' $CONFIG_PATH ||
  echo \"  'overwrite.cli.url' => 'http://localhost:8080',\" >> $CONFIG_PATH
"

docker exec -it $CONTAINER_NAME bash -c "
  grep -q 'default_phone_region' $CONFIG_PATH || echo \"  'default_phone_region' => 'VN',\" >> $CONFIG_PATH
  grep -q 'maintenance_window_start' $CONFIG_PATH || echo \"  'maintenance_window_start' => 2,\" >> $CONFIG_PATH
"

echo "✅ Cấu hình đã được cập nhật."