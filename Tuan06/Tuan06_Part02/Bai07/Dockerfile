# Bước 1: Sử dụng image Python chính thức
FROM python:3.9-slim

# Bước 2: Thiết lập thư mục làm việc trong container
WORKDIR /app

# Bước 3: Sao chép tệp app.py vào container
COPY app.py .

# Bước 4: Thiết lập biến môi trường APP_ENV
ENV APP_ENV=development

# Bước 5: Thực thi ứng dụng Python
CMD ["python", "app.py"]