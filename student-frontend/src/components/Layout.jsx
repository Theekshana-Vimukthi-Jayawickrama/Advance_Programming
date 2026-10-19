import { Link, Outlet } from "react-router-dom";

export default function Layout() {
  return (
    <div className="app">
      <header className="header">
        <h1>Student Portal</h1>
        <nav className="nav">
          <Link to="/students">Students</Link>
          <Link to="/add">Add Student</Link>
        </nav>
      </header>
      <main className="main">
        <Outlet />
      </main>
    </div>
  );
}
