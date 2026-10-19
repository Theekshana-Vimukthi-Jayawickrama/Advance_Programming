import { createStudent } from "../api/students";
import StudentForm from "../components/StudentForm";

export default function AddStudent() {
  async function handleCreate(form) {
    await createStudent(form);
  }

  return (
    <div>
      <h2>Add Student</h2>
      <StudentForm submitLabel="Save Student" onSubmit={handleCreate} />
    </div>
  );
}
