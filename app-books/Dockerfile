# docker build -t app-authors .

# docker build -t jimmyortega/app-books .
# docker push jimmyortega/app-books
FROM eclipse-temurin:21.0.7_6-jre-noble

RUN mkdir /app
WORKDIR /app

COPY  build/quarkus-app/lib/ ./lib
COPY  build/quarkus-app/quarkus  ./quarkus
COPY  build/quarkus-app/app/ ./app
COPY  build/quarkus-app/quarkus-run.jar app.jar


CMD ["java", "-jar", "app.jar"]