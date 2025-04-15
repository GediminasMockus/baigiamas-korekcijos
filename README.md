# Korekcijų valdymo API 📚

## 🔍 Aprašymas
Šis projektas – REST API skirtas korekcijų sistemai valdyti, apimantis šalis, institucijas ir korekcijas. Sistema leidžia pridėti, redaguoti, peržiūrėti ir ištrinti duomenis apie šalis, institucijas ir jų korekcijas. Be to, įgyvendintas išplėstinis filtravimas pagal įvairius parametrus, pvz., institucijos pavadinimą ar korekcijos tipą. Projektas paremtas šiuolaikinėmis praktikomis – naudojami DTO, validacija, Swagger dokumentacija, išimčių valdymas ir testavimas Postman aplinkoje.

## ⚙️ Technologijos
- Java 17+
- Spring Boot
- MySQL
- Spring Data JPA
- Spring Validation
- Swagger (OpenAPI)
- Lombok
- Postman

## 🚀 Kaip paleisti projektą

1. **Kopijuokite repozitoriją:**
```bash
git clone https://github.com/GediminasMockus/baigiamas-korekcijos.git
```

2. **Sukurkite duomenų bazę (pvz. MySQL):**
```sql
CREATE DATABASE korekcijos CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. **Pridėkite duomenų bazės nustatymus į `application.yml`:**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/korekciju_schema
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  server:
    port: 8080
```

4. **Paleiskite su IntelliJ arba terminale komanda:**
```bash
./mvnw spring-boot:run
```

## 📬 API endpoint'ai
- `GET /api/countries` – gauti visų šalių sąrašą
- `POST /api/countries` – pridėti šalį
- `GET /api/institutions?name=Estonia road inspection` – filtruoti institucijas pagal pavadinimą
- `POST /api/institutions` – pridėti naują instituciją
- `GET /api/corrections?type=REPAIR` – filtruoti korekcijas pagal tipą
- `DELETE /api/corrections/{id}` – ištrinti korekciją
- `PUT /api/corrections/{id}` – atnaujinti korekciją
- 
-
🧪 **Visi endpoint'ai dokumentuoti Swagger'e:**
👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

## ✅ Baigiamojo darbo reikalavimai
- [x] 3 susijusios lentelės: `Country`, `Institution`, `Correction` su reliaciniais ryšiais
- [x] Naudojami DTO objektai ir konverteriai, kurie apsaugo nuo tiesioginės duomenų bazės manipuliacijos
- [x] CRUD funkcionalumas įgyvendintas visiems pagrindiniams resursams
- [x] Filtravimas realizuotas naudojant `@RequestParam`, pvz. filtravimas pagal pavadinimą ar tipą
- [x] Swagger naudojamas dokumentacijai, o Postman kolekcija paruošta testavimui
- [x] Projektas laikomas Git repozitorijoje su tvarkinga commit istorija, README ir šakomis

---

## 👨‍🏫 Autorius
**Gediminas Mockus**  
Grupė: JAVAUA7

El. paštas: slaptas@gmail.com
