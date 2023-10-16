
import React from 'react'
import image from '../../images/Login-Logo.png'

function SiteUpdateCnfrm(){
    return(
        <div class='cp-container'>
            <div class='cp-logo-box'>
                <img src={image} alt='KPMG_logo'/>
            </div>
            <div class='cp-form-box'>
                <form class='cp-form'>
                    <div class='cp-msg'>
                        Supplier Site details have been updated Successfully.
                    </div>
                    <br/><br/><br/>
                    <div>
                        <button class='cp-btn'>Continue</button>
                    </div>
                </form>
            </div>
        </div>
    )
}
export default SiteUpdateCnfrm