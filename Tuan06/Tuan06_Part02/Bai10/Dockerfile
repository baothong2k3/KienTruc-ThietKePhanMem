# Sử dụng image PHP 8.2 với Apache
FROM php:8.2-apache

# Cài đặt các module PHP bổ sung (nếu cần)
RUN docker-php-ext-install mysqli pdo pdo_mysql

# Thiết lập thư mục làm việc
WORKDIR /var/www/html

# Mở cổng 80 cho Apache
EXPOSE 80

# Khởi động Apache khi container chạy
CMD ["apache2-foreground"]