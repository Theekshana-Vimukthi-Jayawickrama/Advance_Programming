function Navbar({ university }) {
  return (
    <header className="navbar">
      <div className="navbar-brand">
        <span className="navbar-logo" aria-hidden="true">
          {university}
        </span>
        <span className="navbar-title">Student Portal</span>
      </div>
      <p className="navbar-tagline">Search, filter, and manage student records</p>
    </header>
  )
}

export default Navbar
