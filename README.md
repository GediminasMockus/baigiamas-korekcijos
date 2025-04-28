# Korekcijų valdymo API 📚

## 🔍 Aprašymas
Šis projektas – REST API skirtas korekcijų sistemai valdyti, apimantis šalis, institucijas ir korekcijas. Sistema leidžia pridėti, redaguoti, peržiūrėti ir ištrinti duomenis apie šalis, institucijas ir jų korekcijas. Be to, įgyvendintas filtravimas pagal kitus parametrus, pvz., institucijos galiojimo laika ar korekcijos tipą. Projektas paremtas šiuolaikinėmis praktikomis – naudojami DTO, validacija, Swagger dokumentacija, išimčių valdymas ir testavimas Postman aplinkoje.

## ⚙️ Technologijos
- Java 21
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
CREATE DATABASE korekciju_schema CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
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

## Country

- GET /api/countries – Gauti visų šalių sąrašą

- POST /api/countries – Pridėti naują šalį

- GET /api/countries/{id} – Gauti šalį pagal ID

- PUT /api/countries/{id} – Atnaujinti šalį

- DELETE /api/countries/{id} – Ištrinti šalį (jei nėra susietų institucijų)


## Institution 

- GET /api/institutions – Gauti visų institucijų sąrašą

- GET /api/institutions?countryId={countryId} – Filtruoti institucijas pagal salies ID

- POST /api/institutions – Pridėti naują instituciją

- GET /api/institutions/{id} – Gauti instituciją pagal ID

- PUT /api/institutions/{id} – Atnaujinti instituciją

- DELETE /api/institutions/{id} – Ištrinti instituciją (jei nėra susietų korekcijų)


## Correction 

- GET /api/corrections – Gauti visas korekcijas

- GET /api/corrections?type={tipas} – Filtruoti korekcijas pagal tipą

- GET /api/corrections?expirationBefore={yyyy-MM-dd} – Filtruoti korekcijas pagal galiojimo laiką

- GET /api/corrections/filter?countryId={id} – Filtruoti korekcijas pagal šalį

- GET /api/corrections/{id} – Gauti korekciją pagal ID

- POST /api/corrections – Pridėti naują korekciją

- PUT /api/corrections/{id} – Atnaujinti korekciją

- DELETE /api/corrections/{id} – Ištrinti korekciją

## 🧪 Testavimas
- 🧪 **Visi endpoint'ai dokumentuoti Swagger'e:**
👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)
- 🧪 Postman kolekcija:
Importuoti automatiškai iš Swagger arba naudoti rankinį testavimą.

## 🛡️ Išimčių valdymas

- 🛡️404 – Nerastas resursas (EntityNotFoundException)

- 🛡️400 – Netinkami parametrai (IllegalArgumentException, blogas datos formatas)

- 🛡️405 – Nepalaikomas metodas (HttpRequestMethodNotSupportedException)

- 🛡️500 – Sistemos klaida (Exception)

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
