import React from 'react'
import HomeNav from '../Navbar/HomeNav'
import '../../style/Dashboard.css'
import { FaArrowRight } from "react-icons/fa";
import CostChangeLogo from '../../images/CostChangeIcon.png'
import ReturnsLogo from '../../images/ReturnsIcon.png'
import PurchaseOrderLogo from '../../images/PurchaseOrderIcon.png'
import InvoicesLogo from '../../images/InvoicesIcon.png'
import DealsLogo from '../../images/Dealicon.png'
import AlertLogo from '../../images/AlertIcon.png'
import ASNLogo from '../../images/ASNicon.png'
import Analytics from '../../images/Analytics.png'
import { useNavigate } from "react-router-dom";


function Dashboard()
{
    let navigate = useNavigate();
    return (
        <div class="Dashboard-container">
            <div>
                <HomeNav/>
            </div>
            <div class="Dashboard-Contents">
                <div class="OverviewContainer">
                    <div class="OverviewHeader">
                        <h2>Overview</h2>
                    </div>
                    <div class="OverviewContents">
                        <div class="Tile-container">
                            <div class="Tile">
                                <div class="Tile-title">
                                    {<img src={CostChangeLogo} alt='icon' class="Tile-icon"/>} &nbsp; Cost Change
                                </div>
                                <p>Item id-i-7882121-2544 - <b>Submitted</b></p>
                                <p>Item id-i-21910212-1262 - <b>Approved</b></p>
                                <p> &nbsp; </p>
                                {<FaArrowRight class="Tile-arrow"/>}
                            </div>
                            <div class="Tile">
                                <div class="Tile-title">
                                    {<img src={ReturnsLogo} alt='icon' class="Tile-icon"/>} &nbsp; Returns
                                </div>
                                <p>Return id-R81020 - <b>Initiated Return</b></p>
                                <p>Return id-R00355 - <b>Picked Up</b></p>
                                <p> &nbsp; </p>
                                {<FaArrowRight class="Tile-arrow"/>}
                            </div>
                        </div>

                        <div class="Tile-container">
                            <div class="Tile">
                                <div class="Tile-title">
                                    {<img src={InvoicesLogo} alt='icon' class="Tile-icon"/>} &nbsp; Invoices
                                </div>
                                <p>INV-12001359 - <b>Generated</b></p>
                                <p>INV-12001389 - <b>Sent to Customer</b></p>
                                <p>INV-99202129 - <b>Sent to Customer</b></p>
                                {<FaArrowRight class="Tile-arrow"/>}
                            </div>
                            <div class="Tile">
                                <div class="Tile-title">
                                    {<img src={PurchaseOrderLogo} alt='icon' class="Tile-icon"/>} &nbsp; Purchase Order
                                </div>
                                <p>PO-R-BNG-5681001021 - <b>Approved</b></p>
                                <p>PO-R-DEL-5483219422 - <b>Pending</b></p>
                                <p>PO-R-MUM-3178234413 - <b>Approved</b></p>
                                {<FaArrowRight class="Tile-arrow" onClick={()=>navigate(`/PurchaseOrderMain`)}/>}
                            </div>
                        </div>
                        
                        <div class="Deal-Container">
                            <div class="Deal-Tile">
                                <div class="Deal-Tile-title">
                                    {<img src={DealsLogo} alt='icon' class="Deal-Tile-icon"/>} &nbsp; Deal
                                </div>
                                <p>Pr-120031-1996 - <b>Easter Sale</b></p>
                                <p>Pr-819210-6271 - <b>Summer Offere</b></p>
                                <p>Pr-99022-7777 - <b>Big Billion Days Offer</b></p>
                                <p>Pr-780019-1996 - <b>May Day Sale</b></p>
                                <p>Pr-972812-1732 - <b>Pre Season Sale</b></p>
                                <p>Pr-819203-1652 - <b>Women's Day Sale</b></p>
                                {<FaArrowRight class="Deal-Tile-arrow"/>}
                            </div>
                        </div>

                        <div class="ASN-Container">
                        <div class="ASN-Tile">
                            <div class="ASN-Tile-title">
                                {<img src={ASNLogo} alt='icon' class="ASN-Tile-icon"/>} &nbsp; ASN
                            </div>
                            <p>ASN1245 - <b>Yet To Dispatch</b></p>
                            <p>ASN1244 - <b>Dispatch</b></p>
                            <p>ASN1083 - <b>Delivered</b></p>
                            <p>ASN0029 - <b>Dispatched</b></p>
                            <p>ASN8129 - <b>Delivered</b></p>
                            <p>ASN8129 - <b>Delivered</b></p>    
                            {<FaArrowRight class="ASN-Tile-arrow"/>}
                        </div>
                        </div>

                    </div>                   
                </div>

                <div class="Dashboard-Contents2">
                    <div class="Analytics-Container">
                        {<img src={Analytics} alt='icon' class="Analytics-icon"/>}
                    </div>
                    <div class="Alerts-Container">
                        <div class="Alerts-Tile">
                            <div class="Alerts-Tile-title">
                                {<img src={AlertLogo} alt='icon' class="Alerts-Tile-icon"/>} &nbsp; Alerts
                            </div>
                            <p>New Customer Order Incoming</p>
                            <p>New Deal Request Incoming</p>
                            <p>Raised Concern for Return Id# - <b>R12903</b></p>
                            <p>PO# - PO-R-BAN-0202310522 <b>Delivered</b></p>
                            <p>QC for Return ID # - R1902 - <b>Failed</b></p>
                            <p>PO# - PO-R-DEk-0202310522 <b>Failed</b></p>
                            {<FaArrowRight class="Alerts-Tile-arrow"/>}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Dashboard