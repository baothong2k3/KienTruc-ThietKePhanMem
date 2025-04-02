# app.py
import os

# Lấy giá trị biến môi trường APP_ENV
app_env = os.getenv('APP_ENV', 'undefined')  # Nếu không có biến môi trường sẽ trả về 'undefined'

# In ra giá trị của biến môi trường
print(f'APP_ENV: {app_env}')