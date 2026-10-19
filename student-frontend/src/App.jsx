import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Layout from "./components/Layout";
import AddStudent from "./pages/AddStudent";
import EditStudent from "./pages/EditStudent";
import StudentList from "./pages/StudentList";
import "./App.css";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Navigate to="/students" replace />} />
          <Route path="students" element={<StudentList />} />
          <Route path="add" element={<AddStudent />} />
          <Route path="students/:id/edit" element={<EditStudent />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
