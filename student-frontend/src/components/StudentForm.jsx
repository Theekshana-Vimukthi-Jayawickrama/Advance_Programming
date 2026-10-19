import { useState } from "react";
import { Link } from "react-router-dom";
import { validate } from "../utils/validate";

const emptyForm = { name: "", email: "", course: "" };

export default function StudentForm({
  initialForm = emptyForm,
  submitLabel,
  onSubmit,
}) {
  const [form, setForm] = useState(initialForm);
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");
  const [submitting, setSubmitting] = useState(false);

  function change(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  async function handleSubmit(e) {
    e.preventDefault();
    const message = validate(form);
    if (message) {
      setError(message);
      setSuccess("");
      return;
    }
    setError("");
    setSubmitting(true);
    try {
      await onSubmit(form);
      setSuccess("Student saved successfully.");
      setForm(emptyForm);
    } catch (err) {
      setSuccess("");
      setError(err.message || "Request failed");
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <form className="card form" onSubmit={handleSubmit}>
      <label>
        Full name
        <input
          name="name"
          value={form.name}
          onChange={change}
          placeholder="Nimal Perera"
        />
      </label>
      <label>
        Email
        <input
          name="email"
          type="email"
          value={form.email}
          onChange={change}
          placeholder="nimal@campus.lk"
        />
      </label>
      <label>
        Course
        <input
          name="course"
          value={form.course}
          onChange={change}
          placeholder="CIS"
        />
      </label>
      {error && <p className="message error" role="alert">{error}</p>}
      {success && (
        <div className="success-block">
          <p className="message success">{success}</p>
          <Link className="button-link" to="/students">View students</Link>
        </div>
      )}
      <button type="submit" disabled={submitting}>
        {submitting ? "Saving…" : submitLabel}
      </button>
    </form>
  );
}
