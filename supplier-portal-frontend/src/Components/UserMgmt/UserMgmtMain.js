import React from 'react'
import logo from '../../images/KPMG-logo.jpg'
import '../../style/HomeNav.css'
import '../../style/UserMgmtMain.css'
import {FaUserAlt,FaInfoCircle, FaUser, FaUserCheck, FaBuilding, FaCross, FaUserEdit,FaHome} from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import { Card,CardContent,CardActions,Typography,Button } from '@mui/material';

function UserMgmtMain() {
    let navigate = useNavigate();
  return (

    <div class='UserMgmt-container'>
    <div class='HomeNav-container'>
        <div class='HomeNav-topline'>
            <div class='HomeNav-heading'>
                <p>Supplier Portal</p>
            </div>
            <div class='HomeNav-logo-box'>
                <img src={logo} alt='KPMG_logo' class='HomeNav-logo'/>
            </div>
            <div class='UserMgmt-component'>
                <div class='UserMgmt-component-content'>
                    <div class='UserMgmt-component-Admin'>
                        {<FaUserAlt className='HomeNav-Ricons'/>}
                        <a class='HomeNav-component-a'>Admin</a>
                    </div>
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
    <div class='usermgmt-heading'>
        <div class='usermgmt-component-Home'>
                 {<FaHome className='PurchaseOrderMain-Ricons-Home'/>}
             </div> 
        <div class='usermgmt'>
            <p>UserManagement</p>
        </div>
    </div>
    
     <div class='tiles'>
        <div class='tiles-row1'>
            <div class='Edit-user'>
                {<FaUserEdit className='tiles-Ricons'/>}
                <a class='tiles-component-a'>View/Edit User</a>
            </div>
            <div class='Create-user'>
                {<FaUserCheck className='tiles-Ricons'/>}
                <a class='tiles-component-a'>Create User</a>
            </div>
        </div>
        <div class='tiles-row2'>
            <div class='Remove-user'>
                {<FaUserAlt className='tiles-Ricons'/>}
                <a class='tiles-component-a'>Delete User</a>
            </div>
            <div class='Supplier-site'>
                {<FaBuilding className='tiles-Ricons'/>}
                <a class='tiles-component-a'>Supplier Site</a>
            </div>
        </div>
   </div> 

    </div>
    
  )
}

export default UserMgmtMain