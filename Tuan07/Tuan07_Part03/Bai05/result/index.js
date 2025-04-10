const express = require("express");
const { Pool } = require("pg");
const app = express();
const port = 80;

const pool = new Pool({
  host: "db",
  user: "postgres",
  password: "postgres",
  database: "votes"
});

app.get("/", async (req, res) => {
  const result = await pool.query(`
    SELECT vote, COUNT(*) as count
    FROM votes
    GROUP BY vote
  `);
  let html = "<h1>Vote Results</h1><ul>";
  result.rows.forEach(row => {
    html += `<li>${row.vote}: ${row.count}</li>`;
  });
  html += "</ul>";
  res.send(html);
});

app.listen(port, () => {
  console.log(`Result app running on port ${port}`);
});