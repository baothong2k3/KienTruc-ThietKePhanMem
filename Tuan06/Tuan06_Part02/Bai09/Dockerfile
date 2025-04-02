# Bước 1: Sử dụng image Redis mới nhất
FROM redis:latest

# Bước 2: Cài đặt git để tải thư mục cấu hình từ GitHub
RUN apt-get update && apt-get install -y git

# Bước 3: Tạo thư mục đích để chứa file cấu hình redis.conf
RUN mkdir -p /usr/local/etc/redis

# Bước 4: Tải repository Redis từ GitHub
RUN git clone https://github.com/redis/redis.git /redis

# Bước 5: Sao chép file cấu hình redis.conf vào thư mục đích
RUN cp /redis/redis.conf /usr/local/etc/redis/redis.conf

# Bước 6: Chạy Redis với cấu hình tùy chỉnh
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]
