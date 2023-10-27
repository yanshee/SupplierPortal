import React from 'react'
import '../../style/UMViewUser.css'
import HomeNav from '../Navbar/HomeNav'
import HomeButton from '../Buttons/HomeButton'
import { FaPlusCircle,FaFileExport,FaSearch } from 'react-icons/fa'

function UMRemoveUser()
{
    return (
    <div>
        <div>
            <HomeNav/>
        </div>
        <div class='usermgmt-heading'>
            <HomeButton/>
            <div class='usermgmt'>
                <p>User Management</p>
            </div>
        </div>
        <div class="UMViewUser-container">
            <div class='UMViewUser-Title'>
                <p>Remove User</p>
            </div>
            <div class="UMViewUser-EditViewContianer">
                <div class="ExistingUsers-container">
                    <p class="ViewSitesContianer-title">Select an Existing User</p>
                    <div class="ExistingUsersOptions">
                        <ul>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Sujay</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Syed</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Greshma</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Arunesh</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Yanshee</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Krishan</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Gokul</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Monika</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Harshna</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Vipul</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ExistingUsersOptions-container">Swastik</label>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="ModuleAccess-container">
                    <p class="ViewSitesContianer-title">Module Access</p>
                    <div class="ModuleOptions">
                        <ul>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">ASN</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">P.O</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">Invoices</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">Item Listing</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">Returns</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">Deal</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">Analytics</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">Customer Orders</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="ModuleOptions-container">Alerts</label>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="SiteAccess-container">
                    <p class="ViewSitesContianer-title">Site Access</p>
                    <div class="SiteAccessOptions">
                        <ul>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Mumbai</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">kolkata</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Delhi</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Bangalore</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Kochi</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Chennai</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Hyderabad</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Pune</label>
                            </li>
                            <li>
                                <input type="checkbox"></input>
                                <label class="SiteAccessOptions-container">Nashik</label>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="ViewExistingSites-Buttons">
                <button>Remove User</button>
            </div>
        </div>
        
        
    </div>
    )
}

export default UMRemoveUser