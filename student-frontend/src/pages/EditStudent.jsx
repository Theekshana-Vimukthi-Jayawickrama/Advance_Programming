import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { fetchStudent, updateStudent } from "../api/students";
import StudentForm from "../components/StudentForm";

export default function EditStudent() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [initialForm, setInitialForm] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function load() {
      try {
        const student = await fetchStudent(id);
        setInitialForm({
          name: student.name || "",
          email: student.email || "",
          course: student.course || "",
        });
      } catch (e) {
        setError(e.message || "Could not load student");
      } finally {
        setLoading(false);
      }
    }
    load();
  }, [id]);

  async function handleUpdate(form) {
    await updateStudent(id, form);
    navigate("/students");
  }

  if (loading) {
    return <p className="status">Loading student…</p>;
  }

  if (error) {
    return <p className="message error">{error}</p>;
  }

  return (
    <div>
      <h2>Edit Student</h2>
      <StudentForm
        key={id}
        initialForm={initialForm}
        submitLabel="Update Student"
        onSubmit={handleUpdate}
      />
    </div>
  );
}
