import React,{useState,useEffect} from 'react'
import logo from '../../images/KPMG-logo.jpg'
import '../../style/OrderSummary.css'
import {FaUserAlt,FaInfoCircle, FaBell, FaSearch, FaFilter, FaSort, FaFileExport, FaArrowAltCircleUp, FaArrowCircleDown, FaArrowCircleUp} from "react-icons/fa";
import { FaHome,FaArrowAltCircleLeft} from "react-icons/fa";
import { useNavigate} from "react-router-dom";



function OrderSummary(props){
    let navigate = useNavigate();
    const [currentData, setcurrentData] = useState(null);
    const [currentData2, setcurrentData2] = useState(null);
    const [currentData3, setcurrentData3] = useState(null);
    const [currentData4, setcurrentData4] = useState(null);
    const [currentData5, setcurrentData5] = useState(null);
    const[toggle,setToggle]=useState(true)
    const[toggle1,setToggle1]=useState(true)
    const[toggle2,setToggle2]=useState(true)
  
    const urls = [`http://localhost:8080/purchaseorder/searchpo/PO 6394 9876`, "http://localhost:8080/purchaseorder/display/items",
                  "http://localhost:8080/display/asndetails","http://localhost:8080/display/asnnumber",
                  "http://localhost:8080/display/asninfo"];

    const getData = async () => {
      const [result1, result2,result3,result4,result5] = await Promise.all(
        urls.map((url) => fetch(url).then((res) => res.json()))
     );
      setcurrentData(result1);
      setcurrentData2(result2);
      setcurrentData3(result3);
      setcurrentData4(result4);
      setcurrentData5(result5);

      
    };
    useEffect(() => {
        getData();
        // const fetchData = async () => {
        //     const response = await fetch(`http://localhost:8080/purchaseorder/searchpo/{poId}`)
        //     const newData = await response.json()
        //     setcurrentData(newData)
        // };
        // fetchData();

    }, [])
    const handleClick = () => {
      setToggle(!toggle);
    }
    const handleClick1 = () => {
      setToggle1(!toggle1);
    }
    const handleClick2 = () => {
      setToggle2(!toggle2);
    }
    
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
             <div class='Back-button'>
                 {<FaArrowAltCircleLeft className='PurchaseOrderMain-Ricons-Back' />}
                 <a class='PurchaseOrderMain-Back-a'>Back</a>
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
                    <a class='PurchaseOrderMain-Operations-content-a'>Export All</a>
                    {<FaFileExport className='PurchaseOrderMain-Ricons-down'/>}
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
     <div class='Po-summary'>
                    <p>PO Summary</p>
     </div>
     <div class='PO-wrapper'>
        <div class='left-wrapper'>
            <div class='item'>
                <p>P.O Number :</p>
                <p></p>
            </div>
            <div class='item'>
                <p>Creation Date :</p>
                <p></p>
            </div> 
            <div class='item'>
                <p>Ship By Date :</p>
                <p></p>
            </div>
            <div class='item'>
                <p>Estimated Delivery Date :</p>
                <p></p>
            </div>     
        </div>

        <div class='mid-wrapper'>
            <div class='item'>
                <p>Total Items :</p>
                <p></p>
            </div>
            <div class='item'>
                <p>Supplier Site :</p>
                <p></p>
            </div> 
            <div class='item'>
                <p>Lead Time :</p>
                <p></p>
            </div>     
        </div>

        <div class='right-wrapper'>
            <div class='item'>
                <p>Total Qty :</p>
                <p></p>
            </div>
            <div class='item'>
                <p>Total Cost :</p>
                <p></p>
            </div> 
            <div class='item'>
                <p>Cost% :</p>
                <p></p>
            </div>   
        </div>

     </div>

     <div class='Item-Details'>
                    <p>Item Details</p>
                    {<FaArrowAltCircleUp className='OrderSummary-Ricons-Uparraow' onClick={handleClick} />}
     </div>
    
{toggle ?
<div className="outer-wrapper">
    {currentData2 ? (
  <div className="table-wrapper">
    <table className="table">

      <thead>
        <tr>
          <th>item id</th>
          <th>item name</th>
          <th>ordered qty</th>
          <th>shipped qty</th>
          <th>delivered qty</th>
          <th>estimated cost</th>
        </tr>
      </thead>
    <tbody>

        {currentData2.map((individualExcelData, index) => (
          <tr>
            <td>{individualExcelData.itemId}</td>
            <td>{individualExcelData.itemName}</td>
            <td>{individualExcelData.orderQty}</td>
            <td>{individualExcelData.shipQty}</td>
            <td>{individualExcelData.deliverQty}</td>
            <td>{individualExcelData.estCost}</td>
          </tr>
        ))}
      </tbody>

    </table>
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

  }}>No File is uploaded yet!</div>

)}
</div>
:
<></>
}
     <div class='ASN-Details'>
                    <p>ASN Details</p>
                    {<FaArrowAltCircleUp className='OrderSummary-Ricons-Uparraow'/>}
     </div>
     <div class='ASN-Details-table'>
        <div class='ASN'>
            <p>ASN Count</p>
            <p>A box needed</p>
        </div>
        <div class='ASN' >
            <p>ASN Details</p>
            <p>A box needed</p>
        </div>
        <div class='ASN' >
            <p>Conatiner Count</p>
            <p>A box needed</p>
        </div>
        <div class='ASN' >
            <p>Conatiner Details</p>
            <p>A box needed</p>
        </div>
     </div>
     <div class='ASN-Number1'>
                    <p>ASN #2248</p>
                     {<FaArrowCircleDown className='ASN-Number-Ricons-Downarraow'/>}
     </div>
     <div class='ASN-Number2'>
                    <p>ASN #1245</p>
                    {<FaArrowAltCircleUp className='OrderSummary-Ricons-Uparraow' onClick={handleClick1}/>}
     </div>

   {toggle1 ?  
     <div className="outer-wrapper">
          {currentData4 ? (

            <div className="table-wrapper">
              <table className="table">

                <thead>
                  <tr>
                    <th>Creation Date</th>
                    <th>DC Number</th>
                    <th>Total Items</th>
                    <th>Total Shipping Qty</th>
                    <th>Shipping Date</th>
                    <th>ETA</th>
                    <th>Location</th>
                  </tr>
                </thead>
                
                <tbody>

                  {currentData4.map((individualExcelData, index) => (
                    <tr>
                      <td>{individualExcelData.creationDate}</td>
                      <td>{individualExcelData.dcNumber}</td>
                      <td>{individualExcelData.totalItems}</td>
                      <td>{individualExcelData.shippingQty}</td>
                      <td>{individualExcelData.shippingDate}</td>
                      <td>{individualExcelData.eta}</td>
                      <td>{individualExcelData.location}</td>
                    </tr>
                  ))}

                </tbody>
              </table>
              <div >
              </div>
              <br />
            </div>
          ) : (
            <div>No File is uploaded yet!</div>
          )}
        </div>
        :<></>
}


     <div class='ASN-Info'>
                    <p>ASN Info</p>
                    {<FaArrowAltCircleUp className='OrderSummary-Ricons-Uparraow' onClick={handleClick2}/>}
     </div>
     {toggle2 ?
     <div className="outer-wrapper">
          {currentData5 ? (

            <div className="table-wrapper">
              <table className="table">

                <thead>
                  <tr>
                    <th>Item id</th>
                    <th>Items</th>
                    <th>P.O. Qty</th>
                    <th>Shipped Qty</th>
                    <th>Delivered Qty</th>
                  </tr>
                </thead>
                
                <tbody>

                  {currentData5.map((individualExcelData, index) => (
                    <tr>
                      <td>{individualExcelData.itemId}</td>
                      <td>{individualExcelData.items}</td>
                      <td>{individualExcelData.poQty}</td>
                      <td>{individualExcelData.shippedQty}</td>
                      <td>{individualExcelData.deliveredQty}</td>
                    </tr>
                  ))}

                </tbody>
              </table>
              <div >
              </div>
              <br />
            </div>

          ) : (

            <div>No File is uploaded yet!</div>
          )}
        </div>
      :<></>
          }   

    </div>
    )
  } 

   export default OrderSummary;