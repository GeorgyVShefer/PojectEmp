# Используем официальный образ Maven для сборки приложения
FROM maven:3.5.2-openjdk-17 AS build

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл pom.xml и зависимости для кэширования
COPY ../ProjectBootCRUD/pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код приложения
COPY ../ProjectBootCRUD/src ./src

# Сборка приложения
RUN mvn clean package -DskipTests

# Используем официальный образ OpenJDK для запуска приложения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем jar файл из предыдущего шага
COPY --from=build /app/target/SpringBoot_03-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
