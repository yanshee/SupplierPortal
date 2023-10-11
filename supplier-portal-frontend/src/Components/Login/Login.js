import React, { useState } from 'react'
import '../../style/Login.css'
import image from '../../images/Login-Logo.png'
import { FaEnvelope, FaLock } from "react-icons/fa";
import axios from 'axios';
import { get } from "react-hook-form";
import { useNavigate } from "react-router-dom";

const Login=()=>{
    let navigate = useNavigate();
    const pathCompute = `/ChangePassword`
    const [supplierName, setsupplierName] = useState()
    const [password, setpassword] = useState()
    
    function getLoggedin(e){
        e.preventDefault();
        axios({
            method: 'post',
            url: "http://localhost:8080/api/auth/signin",
            data:Data,
        })
        .then(function (response){
            e.preventDefault();
            //console.log("response", JSON.stringify(response.data))
           navigate(pathCompute,{ state: { name: Data.supplierName}});
            // window.location.href='/ChangePassword'
        })
        .catch(function (error){
            console.log("error", error)
            alert("Invalid")
        })

    }

    const [Data,setData]=useState({
        "supplierName": '',
        "password": ''
    });

    const handleChange=(event)=>{
        const{name,value}=event.target;
        setData((prevData)=>({
            ...prevData,
            [name]:value,
        
        }));
    };

    const handleSubmit=(event)=>{
        event.preventDefault();
      };
    
  console.log(Data);
    
    return (
            <div class='login-container'>
                <div class='login-logo-box'>
                    <img src={image} alt='KPMG_logo'/>
                </div>
                <div class='login-form-box'>
                    <form class ='login-form'>

                        <h3>Supplier Portal</h3>
                        
                        <div class='login-inputfields'>
                            {<FaEnvelope className='Ricons'/>}
                            <input type='text'  name="supplierName" value={Data.supplierName} onChange={handleChange} placeholder='Enter Supplier ID' required/><br/>
                        </div>
                        
                        <div class='login-inputfields'>
                            {<FaLock className='Ricons'/>}
                            <input type='password' name="password" value={Data.password} onChange={handleChange} placeholder='Enter Password' required/><br/>
                        </div>

                        <a href='./ForgotPassword' id='login-forgotpass'>Forgot Password ?</a><br/>
                        
                        <button class='login-btn' onClick={getLoggedin}>Login</button>
                        
                        <div class='login-links'>
                            New User ? <a href='./Registration' class='login-smallLinks'>Click here</a><br/>
                            <a href='./ForgotPassword' class='login-smallLinks'>Continue Registration</a>
                        </div>
                    </form>
                </div>
            </div>
    )
};

export default Login;