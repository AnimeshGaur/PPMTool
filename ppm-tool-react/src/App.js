import React from 'react';
import './App.css';
import Dashboard from './Component/Dashboard';
import Header from './Component/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Route} from "react-router-dom"; 
import AddProject from './Component/Project/AddProject';


function App() {
  return (
    <Router>
    <div className="App">
    <Header />
    <Route exact path = "/dashboard" component = {Dashboard} />
    <Route exact path = "/addProject" component = {AddProject} />
    </div>
    </Router>
  );
}

export default App;
