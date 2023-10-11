import React from 'react'
import '../../style/ChangePasswordConf.css'
import image from '../../images/Login-Logo.png'

function ChangePassword() 
{
  return (
        <div class='cp-container'>
            <div class='cp-logo-box'>
                <img src={image} alt='KPMG_logo'/>
            </div>
            <div class='cp-form-box'>
                <form class='cp-form'>
                    <div class='cp-msg'>
                        Password has been reset Successfully.
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

export default ChangePassword