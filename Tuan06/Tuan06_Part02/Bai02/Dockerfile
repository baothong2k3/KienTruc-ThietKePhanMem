FROM python:3.9

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép các tệp vào container
COPY . .

# Cài đặt dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Expose cổng 5000
EXPOSE 5000

# Chạy ứng dụng
CMD ["python", "app.py"]