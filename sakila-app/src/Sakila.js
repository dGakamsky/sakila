import './css/Sakila.css';
import image from './images/test.jpg';
import React, { useEffect, useState } from 'react';

function Sakila(){

    return(
        <div className = "sakilaBackground">
            <div className = "sakilaTextcontainer">
                <p>
                    <h1>
                        <b>
                            <i>
                                Sakila Application
                            </i>
                        </b>
                    </h1>
                </p>
                <p>
                    This is some text for the application
                </p>
                <p>
                    Explaining the function of the application
                </p>
                <p>
                    Would you like to find what films the actor was in?
                </p>
                <button className="button" onClick={Api}> This is a button </button>
                <Api />
            </div>
        </div>
    );
}


//========================================================================

function Api(){
    const[ReturnData, StoreData] = useState("");

    useEffect(()=>{
      fetch("https://localhost:8080/filmsByActorLimited/1:5")
      .then(res => res.json())
      .then(response => {
          StoreData(response)
      })
      .catch((err) => console.error(err))
    },[])

    return (
        <div>
            {ReturnData.title}
        </div>
    );
}
export default Sakila;