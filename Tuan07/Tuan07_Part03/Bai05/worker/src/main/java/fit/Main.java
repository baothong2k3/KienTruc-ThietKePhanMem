package fit;

import redis.clients.jedis.Jedis;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Kết nối Redis
        Jedis jedis = new Jedis("redis", 6379);

        // Kết nối PostgreSQL với retry logic
        Connection db = null;
        for (int i = 0; i < 10; i++) {
            try {
                db = DriverManager.getConnection(
                        "jdbc:postgresql://db/votes", "postgres", "postgres");
                System.out.println("Connected to PostgreSQL!");
                break;
            } catch (SQLException e) {
                System.out.println("PostgreSQL not ready, retrying in 2s...");
                Thread.sleep(2000);
            }
        }

        if (db == null) {
            throw new RuntimeException("Failed to connect to PostgreSQL after 10 attempts");
        }

        // Tạo bảng nếu chưa tồn tại
        try (Statement stmt = db.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS votes (id SERIAL PRIMARY KEY, vote TEXT)");
        }

        // Vòng lặp xử lý vote từ Redis
        while (true) {
            String vote = jedis.lpop("votes");
            if (vote != null) {
                try (PreparedStatement stmt = db.prepareStatement("INSERT INTO votes(vote) VALUES (?)")) {
                    stmt.setString(1, vote);
                    stmt.executeUpdate();
                }
            }
            Thread.sleep(100);
        }
    }
}
