import StudentCard from '../StudentCard.jsx'

function StudentList({ students }) {
  if (students.length === 0) {
    return <p className="empty-state">No students match your search.</p>
  }

  return (
    <section className="student-list" aria-label="Student directory">
      {students.map((student) => (
        <StudentCard
          key={student.id}
          name={student.name}
          course={student.course}
          active={student.active}
        />
      ))}
    </section>
  )
}

export default StudentList
