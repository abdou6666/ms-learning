FROM node:18-alpine as build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .


EXPOSE 4200


EXPOSE 80


CMD ["npm", "run", "start"]





