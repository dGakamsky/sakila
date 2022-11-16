import './css/Sakila.css';
import image from './images/default_name._V142442227_UY289_CR46,0,196,289_.jpg';
import React, { useEffect, useState } from 'react';

class Sakila extends React.Component{
    constructor(props){
    super(props);
    this.state={
        firstName:"",
        lastName:"",
        id: 0
    };
    }

    intro(){
        return(
        <div> 
        <h1>
            <b>
                <i>
                    Search Form Page
                </i>
            </b>
        </h1>
        <p>
        This is the text for the application where the actors name will go
        </p>
        </div>   
        );
    }

    searchForm(){
        return(
            <div className = "searchForm">
                 <form>
                    <label>Enter Actor first name:
                    <input
                    type="text" 
                    value={this.firstName}
                    onChange={(e) => this.firstName(e.target.value)
                    }
                    />
                    </label>
                </form>
                <form>
                    <label>Enter Actor last name:
                    <input
                    type="text" 
                    value={this.firstName}
                    onChange={(e) => this.lastName(e.target.value)
                    }
                    />
                    </label>
                </form>
                <button className="button" onClick={Api}> Search by name </button>
                <form>
                    <label>Enter Actor id:
                    <input
                    type="text" 
                    value={this.firstName}
                    onChange={(e) => this.id(e.target.value)
                    }
                    />
                    </label>
                </form>
                <button className="button" onClick={Api}> Search by ID </button>
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
                        This actor has no noteworthy accomplishments and is generally unremarkable
                        </div>
                    </td>
                </tr>
                </table>
            </div>

        );
    }

    linkedActors(){
        return (
            <div className = "linkedActors">
                This is where linked actors will be
                <li>
                    linked actor 1
                </li>
                <li>
                    linked actor 2
                </li>
                <li>
                    linked actor 3
                </li>
                <li>
                    linked actor 4
                </li>
                <li>
                    linked actor 5
                </li>

            </div>
        );
    }

    linkedMovies(){
        return(
            <div className = "linkedMovies">
                <Api/>

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

    getApi(){
        return (<Api/>);
    }

    render(){
    return(
        <div className = "sakilaBackground">
            <div className = "sakilaTextcontainer">
                {this.intro()}
                {this.searchForm()}
                {this.actorInfo()}
                {this.links()}
 
                <p>
                    Explaining the function of the application
                </p>
                <p>
                    Would you like to find what films the actor was in?
                </p>
                <button className="button" onClick={Api}> TESTING: link to actor </button>
                <button className="button" onClick={Api}> TESTING: link to film </button>
            </div>
        </div>
    );
    }
}


//========================================================================

function Api(){
    const[ReturnData, StoreData] = useState([]);

    const headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Accept': 'application/json'
    }

    const GetApi = async ()=> {
      const result = await fetch(`https://sakila-1668596751992.azurewebsites.net/home/filmsByActorLimited/1:5`, {headers});
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
        ReturnData.map((film) => (
            <div>
                {film.title}
            </div>
        ))
    );
    }

export default Sakila;