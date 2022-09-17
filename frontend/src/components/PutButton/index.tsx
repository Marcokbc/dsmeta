import icon from "../../assets/img/notification-icon.svg"
import axios from 'axios';
import './style.css'
import { BASE_URL } from "../../utils/requests";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

type Props = {
    saleId: number;
}

function handleClick(id : number){
    axios(`${BASE_URL}/sales/${id}/notification`)
    .then(response => {
        toast.info("SMS enviado com sucesso");
    });
}

function PutButton({saleId} : Props) {
    return(
        <>
            <div className="dsmeta-red-btn" onClick={() => {handleClick(saleId)}}>
                <img src={icon} alt="Alterar" />
            </div>
        </>
    )
  }
  
export default PutButton