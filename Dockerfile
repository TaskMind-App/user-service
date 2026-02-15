# שלב 1: בנייה (Build Stage)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# העתקת ה-pom.xml והורדת התלויות (זה חוסך זמן בבניות הבאות)
COPY pom.xml .
RUN mvn dependency:go-offline

# העתקת הקוד ומחיקת הטסטים לצורך הבנייה המהירה
COPY src ./src
RUN mvn clean package -DskipTests

# שלב 2: הרצה (Run Stage)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# העתקת רק את קובץ ה-JAR שנוצר מהשלב הקודם
COPY --from=build /app/target/*.jar app.jar

# הפורט שהסרוויס מאזין לו (8081 ל-User Service)
EXPOSE 8081

# פקודת ההרצה
ENTRYPOINT ["java", "-jar", "app.jar"]