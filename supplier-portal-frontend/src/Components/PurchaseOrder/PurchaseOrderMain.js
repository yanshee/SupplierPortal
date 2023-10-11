import React, { useState,useEffect } from 'react'
import logo from '../../images/KPMG-logo.jpg'
import '../../style/PurchaseOrderMain.css'
import {FaUserAlt,FaInfoCircle, FaBell, FaSearch, FaDownload, FaFilter, FaSort} from "react-icons/fa";
import { FaHome} from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import OrderSummary from './OrderSummary';
const cors = require('cors');



const PurchaseOrderMain=()=>{

    let navigate = useNavigate();
    const [currentData, setcurrentData] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(`http://localhost:8080/purchaseorder/display/po`)
            const newData = await response.json()
            setcurrentData(newData)
        };

        fetchData();
    }, [])

    if (currentData) {
        console.log(currentData)
    }
    else{
        alert("Something went wrong!!")
    }

    function tdclick(event){
        const pathCompute='/OrderSummary'
        if(currentData!=null){
        navigate(pathCompute,{ state: {id: currentData!= null ? currentData.poId : 0}});
    }};

//     function ExporttoExcel(){
//         const [data, setData] = React.useState([])

//   React.useEffect(() => {
//     const fetchData = () =>{
//      axios.get('http://localhost:8080/purchaseorder/export/excel').then(r => setData(r.data) )
//     }
//     fetchData()
//   }, [])
//   }
    return (

    <div class='PurchaseOrderMain-container'>
        <div class='PurchaseOrderMain-header'>
            <div class='PurchaseOrderMain-topline'>
                <div class='PurchaseOrderMain-heading'>
                    <p>Supplier Portal</p>
                </div>
                <div class='PurchaseOrderMain-logo-box'>
                    <img src={logo} alt='KPMG_logo' class='PurchaseOrderMain-logo'/>
                </div>
                <div class='PurchaseOrderMain-component'>
                    <div class='PurchaseOrderMain-component-content'>
                        <div class='PurchaseOrderMain-component-Logout'>
                            {<FaUserAlt className='PurchaseOrderMain-Ricons'/>}
                            <a class='PurchaseOrderMain-component-a'>User</a>
                        </div>
                        <div class='PurchaseOrderMain-component-About'>
                            {<FaInfoCircle className='PurchaseOrderMain-Ricons'/>}
                            <a class='PurchaseOrderMain-component-a'>About</a>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class='PurchaseOrderMain-menu'>
                <div class='PurchaseOrderMain-menu-content'>
                    <li> 
                        <a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>Dashboard</a>
                    </li>
                    <li>
                        <select class='PurchaseOrderMain-menu-content-dropdown'>
                            <option selected><a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>Purchase Order</a></option>
                            <option><a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>Retailer Returns</a></option>
                            <option><a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>ASN</a></option>
                        </select>
                    </li>
                    <li>
                        <select class='PurchaseOrderMain-menu-content-dropdown'>
                            <option selected><a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>Item Listing</a></option>
                            <option><a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>Cost Change</a></option>
                        </select>
                    </li>
                    <li>
                        <select class='PurchaseOrderMain-menu-content-dropdown'>
                            <option selected><a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>Customer Orders</a></option>
                            <option><a href="#" class='PurchaseOrderMain-content-dropdown-a'>Customer Returns</a></option>
                        </select>
                    </li>
                    <li>
                        <a href="#" class='PurchaseOrderMain-menu-content-dropdown-a'>Invoices</a>
                    </li>
                    <li>
                        <a href="#" class='PurchaseOrderMain-content-dropdown-a'>Deals</a>
                    </li>
                    <li>
                        <a href="#" class='PurchaseOrderMain-content-dropdown-a'>Analytics</a>
                    </li>
                </div>   
            </div>
        </div>

    <div class='PurchaseOrderMain-description'>
        <div class='PurchaseOrderMain-description-content'>
             <div class='PurchaseOrderMain-component-Home'>
                 {<FaHome className='PurchaseOrderMain-Ricons-Home'/>}
             </div> 
             <div class='PurchaseOrderMain-component-heading'>
                 <p>Purchase Orders</p>
            </div>
            <div class='PurchaseOrderMain-notification'>
                <div class='PurchaseOrderMain-notification-alerts'>
                     <a class='PurchaseOrderMain-notification-a'>Order Alerts</a>
                     {<FaBell className='PurchaseOrderMain-Ricons'/>}
                </div>
             </div>       
        </div>
     <div class='PurchaseOrderMain-searchbar'>
        <div class='PurchaseOrderMain-searchbar-container'>
                <input placeholder="Search here"/>
                {<FaSearch className='PurchaseOrderMain-Ricons-search'/>}
        </div>
    </div>
        <div class='PurchaseOrderMain-Operations'>
                <div class='PurchaseOrderMain-Download'>
                    <a class='PurchaseOrderMain-Operations-content-a'>Download</a>
                    {<FaDownload className='PurchaseOrderMain-Ricons-down'/>}
                </div>
                <div class='PurchaseOrderMain-FilterBy'>
                    <a class='PurchaseOrderMain-Operations-content-a'>FilterBy</a>
                    {<FaFilter className='PurchaseOrderMain-Ricons-fil'/>}
                </div>
                <div class='PurchaseOrderMain-SortBy'>
                    <a class='PurchaseOrderMain-Operations-content-a'>SortBy</a>
                    {<FaSort className='PurchaseOrderMain-Ricons-sort'/>}
                </div>
            </div>
     </div>

<div className="outer-wrapper">
{currentData ? (

  <div className="table-wrapper">
    <table className="table">

      <thead>
        <tr>

          <th>Select</th>
          <th>Purchase Order</th>
          <th>Location</th>
          <th>Creation date</th>
          <th>PO qty</th>
          <th>Total items</th>

        </tr>
      </thead>

      <tbody>
        {currentData.map((individualExcelData, index) => (

          <tr onClick={() => tdclick()}>
            <td>{"check "}</td>
            <td>{individualExcelData.poId}</td>
            <td>{individualExcelData.location}</td>
            <td>{individualExcelData.creationDate}</td>
            <td>{individualExcelData.shipByDate}</td>
            <td>{individualExcelData.estimatedDeliveryDate}</td>

          </tr>

        ))}

      </tbody>
    </table>

     <div >
    </div>

    <br />
  </div>

) : (

  <div style={{

    border: "1px solid black",
    padding: "1em",
    margin: "1em",
    backgroundColor: "black",
    color: 'white',
    textAlign: 'center'

  }}>No data found</div>

)} 
    </div>
    </div>
        
      )
}
export default PurchaseOrderMain