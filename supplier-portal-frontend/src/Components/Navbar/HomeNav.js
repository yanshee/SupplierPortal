import React from 'react'
import logo from '../../images/KPMG-logo.jpg'
import '../../style/HomeNav.css'
import {FaUserAlt,FaInfoCircle} from "react-icons/fa";
import { useNavigate } from "react-router-dom";

function HomeNav() {
    let navigate = useNavigate();
  return (
    <div class='HomeNav-container'>
        <div class='HomeNav-topline'>
            <div class='HomeNav-heading'>
                <p>Supplier Portal</p>
            </div>
            <div class='HomeNav-logo-box'>
                <img src={logo} alt='KPMG_logo' class='HomeNav-logo'/>
            </div>
            <div class='HomeNav-component'>
                <div class='HomeNav-component-content'>
                    <div class='HomeNav-component-Logout'>
                        {<FaUserAlt className='HomeNav-Ricons'/>}
                        <a class='HomeNav-component-a'>User</a>
                    </div>
                    <div class='HomeNav-component-About'>
                        {<FaInfoCircle className='HomeNav-Ricons'/>}
                        <a class='HomeNav-component-a'>About</a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class='HomeNav-menu'>
            <div class='HomeNav-menu-content'>
                <li> 
                    <a href="#" class='HomeNav-menu-content-dropdown-a'>Dashboard</a>
                </li>
                <li>
                    <select class='HomeNav-menu-content-dropdown'>
                        <option selected><a href="#" class='HomeNav-menu-content-dropdown-a' onClick={()=>navigate(`/PurchaseOrderMain`)}>Purchase Order </a></option>
                        <option><a href="#" class='HomeNav-menu-content-dropdown-a'>Retailer Returns</a></option>
                        <option><a href="#" class='HomeNav-menu-content-dropdown-a'>ASN</a></option>
                    </select>
                </li>
                <li>
                    <select class='HomeNav-menu-content-dropdown'>
                        <option selected><a href="#" class='HomeNav-menu-content-dropdown-a'>Item Listing</a></option>
                        <option><a href="#" class='HomeNav-menu-content-dropdown-a'>Cost Change</a></option>
                    </select>
                </li>
                <li>
                    <select class='HomeNav-menu-content-dropdown'>
                        <option selected><a href="#" class='HomeNav-menu-content-dropdown-a'>Customer Orders</a></option>
                        <option><a href="#" class='HomeNav-menu-content-dropdown-a'>Customer Returns</a></option>
                    </select>
                </li>
                <li>
                    <a href="#" class='HomeNav-menu-content-dropdown-a'>Invoices</a>
                </li>
                <li>
                    <a href="#" class='HomeNav-menu-content-dropdown-a'>Deals</a>
                </li>
                <li>
                    <a href="#" class='HomeNav-menu-content-dropdown-a'>Analytics</a>
                </li>
            </div>
        </div>
    </div>
  )
}

export default HomeNav