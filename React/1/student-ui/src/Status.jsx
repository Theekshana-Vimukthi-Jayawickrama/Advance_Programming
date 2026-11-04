function Status({ isLoggedIn }) {
  if (isLoggedIn) {
    return <h2 className="status-message welcome">Welcome, Student!</h2>
  }

  return <h2 className="status-message sign-in">Please sign in.</h2>
}

export default Status
