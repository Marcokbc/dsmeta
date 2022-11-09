import './style.css';
import { useEffect, useState } from 'react';

function CreateCard() {
    return (
        <>
           <form>
                <label>
                    Name:
                    <input type="text" name="name" />
                </label>
                <input type="submit" value="Submit" />
            </form>
        </>
    )
}
export default CreateCard