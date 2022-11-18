import React from 'react';
import ReactDOM from 'react-dom/client';
import './css/index.css';
import Sakila from './Sakila';
import Actor from './Actor.js';
import Film from './Film';
import Home from './App'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Outlet, Link } from "react-router-dom";




export default function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route exact path="Film" element={<Film />} />
          <Route exact path="Actor" element={<Actor />} />
          {/* <Route exact path={`Actor/${id}`} element={<Actor id={id}/>} /> */}
          <Route exact path="/" element={<Sakila/>}>
        </Route>
      </Routes>
    </BrowserRouter>
  );

}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App/>
  </React.StrictMode>
);


