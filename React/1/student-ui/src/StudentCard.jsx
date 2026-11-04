function StudentCard({ name, course, active }) {
  return (
    <section className="student-card">
      <h2>{name}</h2>
      <p>Course: {course}</p>
      <p className={active ? 'badge badge-active' : 'badge badge-inactive'}>
        {active ? 'Active' : 'Inactive'}
      </p>
    </section>
  )
}

export default StudentCard
