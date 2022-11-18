import React from 'react';
import ReactDOM from 'react-dom/client';
import './css/index.css';
import Sakila from './Sakila';
import Actor from './Actor';
import Film from './Film';
import Home from './App'
import { BrowserRouter, Routes, Route } from "react-router-dom";


export default function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path="/" element={<Actor id={1}/>}>
          <Route index element={<Sakila/>} />
          <Route path="/Film" element={<Film />} />
          <Route path="/Actor" element={<Actor/>} />
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


