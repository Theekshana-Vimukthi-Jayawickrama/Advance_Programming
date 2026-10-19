export function validate(form) {
  if (!form.name.trim()) {
    return "Please enter a name";
  }
  if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(form.email)) {
    return "Enter a valid email";
  }
  if (!form.course.trim()) {
    return "Please select a course";
  }
  return "";
}
