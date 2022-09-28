import React from 'react';
import {Link} from "react-router-dom";
import "./Sidebar.css"

const Sidebar = ( {active, sidebarToggle} ) => {
    return (
        <div className={active ? "side-bar-active" : "side-bar"}>
            <Link to="/players" onClick={sidebarToggle}>Players</Link>
            <Link to="/teams" onClick={sidebarToggle}>Teams</Link>
        </div>
    );
};

export default Sidebar;