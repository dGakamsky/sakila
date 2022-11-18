import './css/Sakila.css';
import image from './images/default_name._V142442227_UY289_CR46,0,196,289_.jpg';
import React, { useEffect, useState } from 'react';

class Film extends React.Component{
    constructor(props){
        super(props);
        }
    
        intro(){
            const id = this.props.id;
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
            const id = this.props.id;
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
            const id = this.props.id;
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
                    {actor.actorFirstName} {actor.actorLastName}
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