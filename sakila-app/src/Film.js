import './css/Sakila.css';
import image from './images/default_name._V142442227_UY289_CR46,0,196,289_.jpg';
import React, { useEffect, useState } from 'react';
import { Outlet, Link } from "react-router-dom";
import Actor from './Actor.js';
import { BrowserRouter, Routes, Route } from "react-router-dom";

class Film extends React.Component{
    constructor(props){
        super(props);
        this.state ={ id:1};
        }
    
        intro(){
            const id = this.state.id;
            return(
            <div> 
            <h1>
                <b>
                    <i>
                        <GetFilmTitle id={id}/>
                    </i>
                </b>
            </h1>

            </div>   
            );
        }
    
        actorInfo(){
            const id = this.state.id;
            return (
                <div>
                    <table className = "actorInfo">
                    <tr>
                        <td>
                            <div className='actorInfoImage'>
                                 <img src = {image}></img>
                            </div>
                        </td>
                        <td>
                            <div className='actorInfoText' >
                            <GetFilmDescription id={id}/>
                            </div>
                        </td>
                    </tr>
                    </table>
                </div>
    
            );
        }
    
        linkedActors(){
            const id = this.state.id;
            return (
                <div className = "linkedActors">
                    <GetActorsByFilm id={id} limit={10}/>
                </div>
            );
        }
    
    
        links(){
            return (
                <table className = "links">
                <td>
                <p>
                    The Actors that star in this movie:
                </p>
                {this.linkedActors()}
                </td>
                </table>
            );
        }
    
    
        render(){
        return(
            <div className = "sakilaBackground">
                <div className = "sakilaTextcontainer">
                    {this.intro()}
                    {this.actorInfo()}
                    {this.links()}
                </div>
            </div>
        );
        }
    
    
}


//========================================================================

function GetActorsByFilm(input){

        const[Id, StoreId] = useState(input.id);
        const[Actors, StoreActors] = useState(input.limit);
        const[ReturnData, StoreData] = useState([]);
        console.log(`https://sakila-1668596751992.azurewebsites.net/home/actorsByActorLimited/${Id}:${Actors}`);
    
        const headers = {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Accept': 'application/json'
        }
    
        const GetApi = async ()=> {
          const result = await fetch(`https://sakila-1668596751992.azurewebsites.net/home/actorsByActorLimited/${Id}:${Actors}`, {headers});
          const response = await result.json();
          console.log(response);
          if (!result.ok) {
            const error = (response && response.message) || result.statusText;
            console.error(error)}
          StoreData(response);
        }
        useEffect(()=>{
            GetApi();
        },[])
    
        return (
            ReturnData.map((actor) => (
                <ol key = { actor.actorId }>
                    <Link to={"./Actor"} id={actor.actorId} >
                        {actor.actorFirstName} {actor.actorLastName}
                    </Link>
                </ol>
            ))
        );
        }

function GetFilmDescription(input){
            const[id, StoreId] = useState(input.id)
            const[ReturnData, StoreData] = useState([]);    
            console.log(`https://sakila-1668596751992.azurewebsites.net/home/allFilms/${id}`)   
            const headers = {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept': 'application/json'
            }
            
            const GetApi = async ()=> {
                const result = await fetch(`https://sakila-1668596751992.azurewebsites.net/home/allFilms/${id}`, {headers});
                const response = await result.json();
                if (!result.ok) {
                const error = (response && response.message) || result.statusText;
                console.error(error)}
                StoreData(response);
            }
                useEffect(()=>{
                    GetApi();
                },[])
            
            return (
                    <div>
                    {ReturnData.description} 
                    </div>
    
            );
            }

function GetFilmTitle(input){
                const[id, StoreId] = useState(input.id)
                const[ReturnData, StoreData] = useState([]);    
                console.log(`https://sakila-1668596751992.azurewebsites.net/home/allFilms/${id}`)   
                const headers = {
                    'Content-Type': 'application/x-www-form-urlencoded',
                    'Accept': 'application/json'
                }
                
                const GetApi = async ()=> {
                    const result = await fetch(`https://sakila-1668596751992.azurewebsites.net/home/allFilms/${id}`, {headers});
                    const response = await result.json();
                    if (!result.ok) {
                    const error = (response && response.message) || result.statusText;
                    console.error(error)}
                    StoreData(response);
                }
                    useEffect(()=>{
                        GetApi();
                    },[])
                
                return (
                        <div>
                        {ReturnData.title} 
                        </div>
        
                );
                }

export default Film;