import { useCallback, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { deleteStudent, fetchStudents } from "../api/students";

export default function StudentList() {
  const [students, setStudents] = useState([]);
  const [search, setSearch] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const filtered = students.filter((student) => {
    const q = search.trim().toLowerCase();
    if (!q) {
      return true;
    }
    return (
      student.name?.toLowerCase().includes(q) ||
      student.course?.toLowerCase().includes(q)
    );
  });

  const load = useCallback(async () => {
    setLoading(true);
    setError("");
    try {
      const data = await fetchStudents();
      setStudents(data);
    } catch (e) {
      setError(e.message || "Server unavailable. Retry.");
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    load();
  }, [load]);

  async function handleDelete(student) {
    if (!window.confirm(`Delete ${student.name}?`)) {
      return;
    }
    try {
      await deleteStudent(student.id);
      await load();
    } catch (e) {
      setError(e.message || "Failed to delete");
    }
  }

  if (loading) {
    return <p className="status">Loading students…</p>;
  }

  if (error) {
    return (
      <div className="card">
        <p className="message error">{error}</p>
        <button type="button" onClick={load}>Retry</button>
      </div>
    );
  }

  if (!students.length) {
    return (
      <div className="card">
        <p className="status">No students yet.</p>
        <Link className="button-link" to="/add">+ Add Student</Link>
      </div>
    );
  }

  return (
    <div className="card">
      <div className="toolbar">
        <h2>Students</h2>
        <Link className="button-link" to="/add">+ Add Student</Link>
      </div>
      <label className="search">
        Search by name or course
        <input
          type="search"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          placeholder="e.g. Nimal or CIS"
        />
      </label>
      {!filtered.length && search.trim() && (
        <p className="status">No students match your search.</p>
      )}
      {filtered.length > 0 && (
        <table className="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {filtered.map((student) => (
              <tr key={student.id}>
                <td className="mono">{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td className="actions">
                  <Link to={`/students/${student.id}/edit`}>Edit</Link>
                  <button type="button" onClick={() => handleDelete(student)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
