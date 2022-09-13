import icon from "../../assets/img/trash-svgrepo-com.svg"
import axios from 'axios';
import './style.css'
import { BASE_URL } from "../../utils/requests";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useEffect } from "react";

type Props = {
    saleId: number;
}

function handleClick(id : number){
    axios.delete(`${BASE_URL}/sales/${id}`)
    .then(response => {
        toast.info("Venda Excluida com sucesso!");
    });
}

function DeleteButton({saleId} : Props) {
    return(
        <>
            <div className="dsmeta-red-btn" onClick={() => {handleClick(saleId)}}>
                <img src={icon} alt="Deletar" />
            </div>
        </>
    )
  }
  
export default DeleteButton