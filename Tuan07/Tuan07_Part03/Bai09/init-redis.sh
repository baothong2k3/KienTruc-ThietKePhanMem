#!/bin/bash

CONFIG_FILE=/var/www/html/config/config.php

# Đợi đến khi config.php được tạo
echo "⏳ Chờ config.php được tạo..."
while [ ! -f "$CONFIG_FILE" ]; do
  sleep 2
done

# Thêm cấu hình Redis nếu chưa có
if ! grep -q "memcache.locking" "$CONFIG_FILE"; then
  echo "🔧 Thêm Redis config vào config.php"
  sed -i "/);/i \
  'memcache.local' => '\\OC\\Memcache\\APCu',\n  'memcache.locking' => '\\OC\\Memcache\\Redis',\n  'redis' => array(\n    'host' => 'redis',\n    'port' => 6379,\n  )," "$CONFIG_FILE"
else
  echo "✅ Redis config đã tồn tại"
fi