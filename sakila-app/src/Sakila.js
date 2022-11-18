import './css/Sakila.css';
import React, { useEffect, useState } from 'react';
import Actor from './Actor.js';
import { Outlet, Link } from "react-router-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";


class Sakila extends React.Component{
    constructor(props){
    super(props);
    }

    intro(){
        return(
        <div> 
        <h1>
            <b>
                <i>
                    Sakila Actor Search
                </i>
            </b>
        </h1>
        <p>
        Please select the actor you would like to view
        </p>
        </div>   
        );
    }

    searchForm(){
        return(
            <div className = "searchForm">
                <GetActors/>
                
            </div>
        );
    }


    render(){
    return(
        <div className = "sakilaBackgroundList">
            <div className = "sakilaTextcontainer">
                {this.intro()}
                {this.searchForm()}
            </div>
        </div>
    );
    }



}    

//==================== API FUNCTIONS OUTSIDE CLASS ========================================

function GetActors(){
            const[ReturnData, StoreData] = useState([]);       
            const headers = {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept': 'application/json'
            }
        
            const GetApi = async ()=> {
              const result = await fetch(`https://sakila-1668596751992.azurewebsites.net/home/allActors`, {headers});
              const response = await result.json();
              if (!result.ok) {
                const error = (response && response.message) || result.statusText;
                console.error(error)}
              StoreData(response);
            }
            useEffect(()=>{
                GetApi();
            },[])
            console.log(ReturnData);
        
            return (
                ReturnData.map((actor) => (
                <ol key = { actor.actorId }>
                    <Link to={"./Actor"} state={{id:actor.actorId}} >
                        {actor.actorFirstName} {actor.actorLastName}
                    </Link>

                    {/* {actor.actorFirstName} {actor.actorLastName} */}
                </ol>
                ))
            );
            }


export default Sakila;