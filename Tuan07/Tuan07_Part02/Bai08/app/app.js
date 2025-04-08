const express = require('express');
const mysql = require('mysql2');
const app = express();
const port = 3000;

const db = mysql.createConnection({
  host: 'mysql', // tên service trong docker-compose
  user: 'user',
  password: 'password',
  database: 'testdb'
});

db.connect(err => {
  if (err) {
    console.error('❌ Error connecting to MySQL:', err.message);
    return;
  }
  console.log('✅ Connected to MySQL database!');
});

app.get('/', (req, res) => {
  db.query('SELECT NOW() AS now', (err, results) => {
    if (err) return res.status(500).send('Query error');
    res.send(`MySQL time: ${results[0].now}`);
  });
});

app.listen(port, () => {
  console.log(`🚀 Server is running at http://localhost:${port}`);
});