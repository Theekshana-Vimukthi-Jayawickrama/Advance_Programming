function SearchBox({ value, onChange, course, onCourseChange, courses }) {
  return (
    <div className="search-box">
      <label className="field">
        <span>Search students</span>
        <input
          type="search"
          placeholder="Type a name..."
          value={value}
          onChange={(event) => onChange(event.target.value)}
        />
      </label>
      <label className="field">
        <span>Course</span>
        <select value={course} onChange={(event) => onCourseChange(event.target.value)}>
          <option value="All">All courses</option>
          {courses.map((item) => (
            <option key={item} value={item}>
              {item}
            </option>
          ))}
        </select>
      </label>
    </div>
  )
}

export default SearchBox
