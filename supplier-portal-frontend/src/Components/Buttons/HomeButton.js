import React from 'react'
import '../../style/HomeButton.css'
import { FaHome } from "react-icons/fa";

function HomeButton() {
  return (
    <button class="HomeButton">
        <FaHome class="HomeButton-icon"/>
    </button>
  )
}

export default HomeButton