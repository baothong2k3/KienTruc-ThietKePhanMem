# Sử dụng Node.js Alpine để build ứng dụng
FROM node:18-alpine AS build

WORKDIR /app

# Sao chép package.json và cài đặt dependencies
COPY package.json package-lock.json ./
RUN npm install

# Sao chép toàn bộ mã nguồn và build ứng dụng
COPY . .
RUN npm run build

# Sử dụng một image nhẹ để chạy ứng dụng
FROM node:18-alpine

WORKDIR /app

# Sao chép build từ bước trước
COPY --from=build /app/build ./build

# Cài đặt server để chạy React (serve)
RUN npm install -g serve

# Expose cổng 3000
EXPOSE 3000

# Chạy ứng dụng
CMD ["serve", "-s", "build", "-l", "3000"]