export const API = "/api/students";

export async function fetchStudents() {
  const response = await fetch(API);
  if (!response.ok) {
    throw new Error("Could not load students");
  }
  return response.json();
}

export async function fetchStudent(id) {
  const response = await fetch(`${API}/${id}`);
  if (!response.ok) {
    throw new Error("Student not found");
  }
  return response.json();
}

export async function createStudent(form) {
  const response = await fetch(API, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(form),
  });
  if (!response.ok) {
    throw new Error("Could not save student");
  }
  return response.json();
}

export async function updateStudent(id, form) {
  const response = await fetch(`${API}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(form),
  });
  if (!response.ok) {
    throw new Error("Update failed");
  }
  return response.json();
}

export async function deleteStudent(id) {
  const response = await fetch(`${API}/${id}`, { method: "DELETE" });
  if (!response.ok) {
    throw new Error("Failed to delete student");
  }
}
