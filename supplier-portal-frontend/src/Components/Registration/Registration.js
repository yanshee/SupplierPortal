import React, { useState } from "react";
import "../../style/Registration.css";
import image from "../../images/Login-Logo.png";
import { FaEnvelope, FaUserAlt, FaPhone, FaMobileAlt } from "react-icons/fa";
import axios from "axios";

function Registration() {

  const REGISTER_API_BASEURL = "http://localhost:8080/api/auth/signup";
  function getRegisterd() {
    axios({
      method: "post",
      url: REGISTER_API_BASEURL,
      // headers: {
      //     Authorization: `Bearer ${bearerToken}`,
      // },
      data: {
        supplierName: "monika",
        email: "monika@gmail.com1212",
        landline: "1234562",
        mobile: "3957371221",
        role: ["", "user"],
      },
    })
      .then(function (response) {
        console.log("response", JSON.stringify(response.data));
      })
      .catch(function (error) {
        console.log("error", error);
        alert("Invalid Credentials");
      });
  }

  const [Data, setData] = useState({

    supplierName: '',
    email: '',
    landline:'',
    mobile:'',
    role: ['',"user"]

  });

 
  const handleChange = (event) => {
    const { name, value } = event.target;

    setData((prevData) => ({
      ...prevData,

      [name]: value,

    }));

  };

    const handleSubmit=(event)=>{
    event.preventDefault();

  };

  console.log(Data);

  return (
    <div class="reg-container">
      <div class="reg-logo-box">
        <img src={image} alt="KPMG_logo" />
      </div>
      
      <div class="reg-form-box">
        <form class="reg-form">
          <h3>New Registration</h3>

          <div class="reg-inputfields">
            {<FaUserAlt className="Ricons" />}
            <input
              type="text"
              name="supplierName"
              value={Data.supplierName}
              placeholder="Supplier Name"
              onChange={handleChange}
            />
            <br />
          </div>

          <div class="reg-inputfields">
            {<FaEnvelope className="Ricons" />}
            <input
              type="email"
              name="email"
              value={Data.email}
              placeholder="Email ID"
              onChange={handleChange}
            />
            <br />
          </div>

          <div class="reg-inputfields">
            {<FaPhone className="Ricons" />}
            <input
              type="text"
              name="landline"
              value={Data.landline}
              placeholder="Landline Number"
              onChange={handleChange}
            />
            <br />
          </div>

          <div class="reg-inputfields">
            {<FaMobileAlt className="Ricons" />}
            <input
              type="text"
              name="mobile"
              value={Data.mobile}
              onChange={handleChange}
              placeholder="Phone Number"
            />
            <br />
          </div>

          <div>
            <input type="checkbox" class="reg-chkbox" />

            <lable>
              I agree to the{" "}
              <a href="./Registration" class="smallLinks">
                terms and conditions
              </a>
            </lable>
            <br />
          </div>

          <button class="reg-btn" onSubmit={getRegisterd}>
            Next{" "}
          </button>

          <div class="reg-links">
            Already have an account ?{" "}
            <a href="/" class="smallLinks">
              Click here
            </a>
            <br />
          </div>
        </form>
      </div>
    </div>
  );
}
export default Registration;
