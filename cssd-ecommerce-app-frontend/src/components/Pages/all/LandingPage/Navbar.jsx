import React, { useState } from 'react'
import logo from '../../../../images/logo.png';
import { Link } from 'react-scroll';
import './LandingPage.css'


export const Navbar = () => {

    const [nav, setnav] = useState(false);

    const changeBackground = () => {
        if (window.scrollY >= 50) {
            setnav(true);
        } else {
            setnav(false);
        }
    }
    window.addEventListener('scroll', changeBackground);

    return (
        <nav className={nav ? "nav active" : "nav"}>
            <Link to='main' className='logo'>
                <img src={logo} smooth={true} duration={1000} alt='' />
            </Link>
            <input className='menu-btn' type="checkbox" id='menu-btn' />
            <label className='menu-icon' for='menu-btn'>
                <span className='nav-icon'></span>
            </label>
            <ul className='menu'>

                <li><a href='/login' smooth={true} duration={1000}>Login</a></li>
            </ul>
        </nav>
    )
}
