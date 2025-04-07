# Sử dụng image chính thức của NGINX làm base
FROM nginx:latest

# Xóa file mặc định (optional)
RUN rm -rf /usr/share/nginx/html/*

# Copy các file HTML/CSS/JS từ thư mục local vào thư mục nginx phục vụ web
COPY ./html /usr/share/nginx/html

# Mở port 80
EXPOSE 80