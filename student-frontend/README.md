# Student Portal (React + Vite)

Frontend for the Spring Boot `student-api` backend (React Lecture Part 2 style: routing, forms, `fetch`).

## Run

1. Start backend (port **8080**) from `../student-api` with MongoDB configured.
2. Install and run frontend:

```bash
npm install
npm run dev
```

3. Open **http://localhost:5173**

API calls go to `/api/students` and Vite proxies them to `http://localhost:8080/students`.

## Pages

| Route | Purpose |
|-------|---------|
| `/students` | List, edit, delete |
| `/add` | Create student |
| `/students/:id/edit` | Update student |
