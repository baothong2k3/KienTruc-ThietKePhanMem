FROM node:18

WORKDIR /usr/src/app

COPY app/package*.json ./
RUN npm install

COPY app .
COPY app/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

CMD ["/wait-for-it.sh", "mysql:3306", "--", "npm", "start"]