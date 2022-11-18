import React from 'react';
import ReactDOM from 'react-dom/client';
import './css/index.css';
import Sakila from './Sakila';
import Actor from './Actor.js';
import Film from './Film.js';
import { BrowserRouter, Routes, Route } from "react-router-dom";


export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Sakila />}>
          <Route index element={<Sakila />} />
          <Route path="film" element={<Film />} />
          <Route path="actor" element={<Actor/>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );

}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Actor id={1}/>
  </React.StrictMode>
);


