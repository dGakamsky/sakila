import './css/Sakila.css';
import image from './images/default_name._V142442227_UY289_CR46,0,196,289_.jpg';
import React, { useEffect, useState } from 'react';

class Actor extends React.Component{
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
                        <GetActor id={id}/>
                    </i>
                </b>
            </h1>
            </div>   
            );
        }
    
        actorInfo(){
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
                            This actor has no noteworthy accomplishments and is generally unremarkable. <br></br>
                            Once they do something worthwhile then maybe people will update this page? who knows. 
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
                    <GetActorsByActor id={id} limit={5}/>
                </div>
            );
        }
    
        linkedMovies(){
            const id = this.props.id;
            return(
                <div className = "linkedMovies">
                    <GetMoviesByActor id={id} limit={5}/>
                </div>
            );
        }
    
        links(){
            return (
                <table className = "links">
                <td>
                {this.linkedActors()}
                </td>
                <td>
                {this.linkedMovies()}
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

function GetMoviesByActor(input){

    const[Id, StoreId] = useState(input.id);
    const[Movies, StoreMovies] = useState(input.limit);
    const[ReturnData, StoreData] = useState([]);
    console.log(`https://sakila-1668596751992.azurewebsites.net/home/filmsByActorLimited/${Id}:${Movies}`);

    const headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Accept': 'application/json'
    }

    const GetApi = async ()=> {
      const result = await fetch(`https://sakila-1668596751992.azurewebsites.net/home/filmsByActorLimited/${Id}:${Movies}`, {headers});
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
        ReturnData.map((film) => (
            <ol key = { film.filmId }>
                {film.title}
            </ol>
        ))
    );
    }

function GetActorsByActor(input){

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

function GetActor(input){
        const[id, StoreId] = useState(input.id)
        const[ReturnData, StoreData] = useState([]);    
        console.log(`https://sakila-1668596751992.azurewebsites.net/home/allActors/${id}`)   
        const headers = {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Accept': 'application/json'
        }
        
        const GetApi = async ()=> {
            const result = await fetch(`https://sakila-1668596751992.azurewebsites.net/home/allActors/${id}`, {headers});
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
                {ReturnData.actorFirstName} {ReturnData.actorLastName}
                </div>

        );
        }



export default Actor;