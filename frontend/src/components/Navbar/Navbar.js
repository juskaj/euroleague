import React from 'react';
import {MdMenu} from "react-icons/md";
import './Navbar.css'

const Navbar = ( {sidebarToggle} ) => {
    return (
        <div className="nav-bar">
            <MdMenu onClick={sidebarToggle} className="menu-btn"/>
            <span>Euroleague</span>
        </div>
    );
};

export default Navbar;