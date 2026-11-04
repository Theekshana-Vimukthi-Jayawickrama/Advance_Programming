import { useState } from 'react'
import Navbar from './components/Navbar.jsx'
import SearchBox from './components/SearchBox.jsx'
import Status from './Status.jsx'
import StudentList from './components/StudentList.jsx'
import './App.css'

const university = 'SUSL'

const students = [
  { id: 1, name: 'Nimal', course: 'CIS', active: true },
  { id: 2, name: 'Amali', course: 'IS', active: false },
  { id: 3, name: 'Kavindu', course: 'SE', active: true },
]

function App() {
  const [count, setCount] = useState(0)
  const [isLoggedIn, setIsLoggedIn] = useState(true)
  const [searchQuery, setSearchQuery] = useState('')
  const [selectedCourse, setSelectedCourse] = useState('All')

  const courses = [...new Set(students.map((student) => student.course))]

  const filteredStudents = students.filter((student) => {
    const matchesSearch = student.name
      .toLowerCase()
      .includes(searchQuery.trim().toLowerCase())
    const matchesCourse =
      selectedCourse === 'All' || student.course === selectedCourse
    return matchesSearch && matchesCourse
  })

  const hasResults = filteredStudents.length > 0

  function greet() {
    alert('Welcome, student!')
  }

  return (
    <div className="app">
      <Navbar university={university} />

      <main className="dashboard">
        <h1 className="heading">{university} Students</h1>
        <p className="subtitle">Welcome to React!</p>

        <Status isLoggedIn={isLoggedIn} />

        <div className="toolbar">
          <button type="button" className="btn btn-secondary" onClick={greet}>
            Greet
          </button>
          <button
            type="button"
            className="btn btn-secondary"
            onClick={() => setIsLoggedIn((value) => !value)}
          >
            {isLoggedIn ? 'Sign out' : 'Sign in'}
          </button>
          <button
            type="button"
            className="btn btn-accent"
            onClick={() => setCount((value) => value + 1)}
          >
            Present: {count}
          </button>
        </div>

        <SearchBox
          value={searchQuery}
          onChange={setSearchQuery}
          course={selectedCourse}
          onCourseChange={setSelectedCourse}
          courses={courses}
        />

        {hasResults && (
          <p className="results-note">
            Showing {filteredStudents.length} student
            {filteredStudents.length === 1 ? '' : 's'}
          </p>
        )}

        <StudentList students={filteredStudents} />
      </main>
    </div>
  )
}

export default App
