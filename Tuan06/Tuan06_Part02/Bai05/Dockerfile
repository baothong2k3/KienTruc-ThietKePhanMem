# Giai đoạn 1: Build ứng dụng Go
FROM golang:1.24.2 AS builder

WORKDIR /app

# Sao chép go.mod (không cần go.sum vì nó không tồn tại)
COPY go.mod .  
RUN go mod tidy

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng
RUN go build -o app .

# Giai đoạn 2: Runtime
FROM alpine:latest
RUN apk --no-cache add ca-certificates

COPY --from=builder /app/app /app

EXPOSE 8080
CMD ["/app"]
