# JavaSwingDemo

Event-driven Java Swing demos from the lecture **Java Event-Driven Programming — Swing, Layout Managers & a Real Login GUI**, plus an animated dark/gold showcase UI.

## Setup

1. Install **JDK 21+** (`java -version`)
2. Open the folder in **IntelliJ IDEA** or VS Code (Extension Pack for Java)
3. Maven will download **FlatLaf** (modern Swing Look & Feel plugin) automatically

### IntelliJ tips

- Enable **Swing UI Designer** if you use `.form` files (optional for these demos)
- Run configurations: right-click any `*App` / `*Login` class → Run

## Run

```bash
mvn -q compile exec:java
```

Or run a specific class:

```bash
mvn -q compile exec:java -Dexec.mainClass=org.example.StudentLogin
mvn -q compile exec:java -Dexec.mainClass=org.example.FirstButton
mvn -q compile exec:java -Dexec.mainClass=org.example.GoldenPortalApp
```

## Files

| Class | What it shows |
|--------|----------------|
| `FirstButton` | Slide 10 — one window, one button, one click |
| `StudentLogin` | Final project — BorderLayout + GridLayout login (`student` / `demo123`) |
| `GoldenPortalApp` | Animated Discover → Design portal (FlatLaf + Timer rings) |

## Credentials (lecture login)

- Username: `student`
- Password: `demo123`
