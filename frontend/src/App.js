import './App.css';
import {Link, Outlet} from "react-router-dom";
import Navbar from "./components/Navbar/Navbar";
import Sidebar from "./components/Sidebar/Sidebar";
import {useState} from "react";

function App() {

    const [sidebarActive, setSidebarActive] = useState(false)

    const toggleSidebar = () => {
        setSidebarActive(!sidebarActive)
        console.log(sidebarActive)
    }

    return (
        <div className="full-page">
            <Navbar sidebarToggle={toggleSidebar}/>
            <Sidebar active={sidebarActive} sidebarToggle={toggleSidebar}/>
            <div className="page-content">
                <Outlet/>
            </div>
        </div>
  );
}

export default App;
