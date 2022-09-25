import './style.css'
import NotificationButton from '../NotificationButton'
import DatePicker from "react-datepicker";
import { useEffect, useState } from 'react';
import "react-datepicker/dist/react-datepicker.css";
import { Sale } from '../../models/Sale';
import axios from 'axios';
import { BASE_URL } from '../../utils/requests';
import DeleteButton from '../DeleteButton';
import { toast } from 'react-toastify';
import PutButton from '../PutButton';
import ModalPut from '../ModalPut';

function SalesCard() {
    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date();

    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [sales, setSales] = useState<Sale[]>([]);

    useEffect(() => {
        const dmin = minDate.toISOString().slice(0, 10);
        const dmax = maxDate.toISOString().slice(0, 10);

        axios.get(`${BASE_URL}/sales?minDate=${dmin}&maxDate=${dmax}`)
            .then(response => {
                setSales(response.data.content);
            });
    }, [minDate, maxDate, sales])
    // console.log(sales);




    return (
        <>
            <div className="dsmeta-card">
                <h2 className="dsmeta-sales-title">Vendas</h2>
                <div>
                    <div className="dsmeta-form-control-container">
                        <DatePicker
                            selected={minDate}
                            onChange={(date: Date) => setMinDate(date)}
                            className="dsmeta-form-control"
                            dateFormat="dd/MM/yyyy"
                        />
                    </div>
                    <div className="dsmeta-form-control-container">
                        <DatePicker
                            selected={maxDate}
                            onChange={(date: Date) => setMaxDate(date)}
                            className="dsmeta-form-control"
                            dateFormat="dd/MM/yyyy"
                        />
                    </div>
                </div>

                <div>
                    <table className="dsmeta-sales-table">
                        <thead>
                            <tr>
                                <th className="show992">ID</th>
                                <th className="show576">Data</th>
                                <th>Vendedor</th>
                                <th className="show992">Visitas</th>
                                <th className="show992">Vendas</th>
                                <th>Total</th>
                                <th>Notificar</th>
                                <th>Deletar</th>
                                <th>Alterar</th>
                            </tr>
                        </thead>
                        <tbody>
                            {sales.map(sale => {
                                return (
                                    <tr key={sale.id}>
                                        <td className="show992">#{sale.id}</td>
                                        <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                                        <td>{sale.seller.name}</td>
                                        <td className="show992">{sale.visited}</td>
                                        <td className="show992">{sale.deals}</td>
                                        <td>R$ {sale.amount}</td>
                                        <td>
                                            <div className="dsmeta-red-btn-container">
                                                <NotificationButton saleId={sale.id} />
                                            </div>
                                        </td>
                                        <td>
                                            <div className='dsmeta-red-btn-container' >
                                                <DeleteButton saleId={sale.id} />
                                            </div>
                                        </td>
                                        <td>
                                            <div className='dsmeta-red-btn-container' onClick={() => {setIsModalVisible(true)}}>
                                                <PutButton saleId={sale.id}/>
                                            </div>
                                        </td>
                                    </tr>
                                )
                            })}
                        </tbody>

                    </table>
                </div>

            </div>
        </>
    )
}

export default SalesCard