import React from 'react'
import '../../style/ForgotPassword.css'
import image from '../../images/Login-Logo.png'
import {FaEnvelope} from "react-icons/fa";

function ForgetPassword()
{
    return (
            <div class='fp-container'>
                <div class='fp-logo-box'>
                    <img src={image} alt='KPMG_logo'/>
                </div>
                <div class='fp-form-box'>
                    <form class='fp-form'>
                        <h3>Supplier Portal</h3>
                        
                        <div class='fp-inputfields'>
                            {<FaEnvelope className='Ricons'/>}
                            <input type='text' placeholder='Enter Supplier ID'/>
                        </div>
                        
                        <button class='fp-btn-OTP'>Get OTP</button>
                        <br/><br/>

                        <div class='fp-inputfields'>
                            <input type='text' placeholder='Enter OTP'/>
                        </div>

                        <button class='fp-btn' href='./ChangePassword'>Verify</button>

                        <div class='fp-links'>
                            New User ? <a href='./Registration' class='fp-smallLinks'>Click here</a><br/>
                            <a href='' class='smallLinks'>Continue Registration</a>

                        </div>
                    </form>
                </div>
            </div>     
    )
}

export default ForgetPassword;