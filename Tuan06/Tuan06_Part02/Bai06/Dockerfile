# Stage 1: Build ứng dụng
FROM node:18 AS build-stage

# Đặt thư mục làm việc
WORKDIR /app

# Copy package.json và package-lock.json để cài đặt dependencies trước
COPY package*.json ./

# Cài đặt dependencies
RUN npm install

# Copy toàn bộ source code
COPY . .

# Stage 2: Chạy ứng dụng
FROM node:18-alpine AS production-stage

# Đặt thư mục làm việc
WORKDIR /app

# Copy code từ stage build
COPY --from=build-stage /app /app

# Cài đặt chỉ các dependencies cần thiết cho production
RUN npm ci --only=production

# Mở cổng
EXPOSE 3000

# Chạy ứng dụng
CMD ["node", "server.js"]