import icon from "../../assets/img/pen-svgrepo-com.svg"
import axios from 'axios';
import './style.css'
import { BASE_URL } from "../../utils/requests";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useState } from "react";

type Props = {
    saleId: number;
}

function PutButton({saleId} : Props) {
    return(
        <>
            <div className="dsmeta-red-btn">
                <img src={icon} alt="Alterar" />
            </div>
        </>
    )
  }
  
export default PutButton