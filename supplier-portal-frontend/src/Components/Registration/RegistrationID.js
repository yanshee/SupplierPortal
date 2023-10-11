import React, { useState } from 'react'
import '../../style/RegistrationID.css'
import image from '../../images/Login-Logo.png'

function RegistrationID()
{
    return ( 
        <div class='regID-container'>
            <div class='regID-logo-box'>
                <img src={image} alt='KPMG_logo'/>
            </div>
            <div class='regID-form-box'>
                <form class='regID-form'>
                    <div class='regID-msg'>
                        A Registration ID has been sent to your email.
                    </div>
                    <br/><br/><br/>
                    <div>
                        <button class='regID-btn'>Continue</button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default RegistrationID;