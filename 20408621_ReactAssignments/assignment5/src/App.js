
import './App.css';
import { BrowserRouter as Router,Routes,Route, NavLink } from 'react-router-dom';
import Products from './Component/products';
import About from './Component/about';
function App() {
  return (
    <div className="App">
     <Router>
     <nav style={{marginTop:100}}>
      <NavLink exact className="btn btn-primary" to="/" >products</NavLink>
        <NavLink  className="btn btn-secondary navig" to="/about" style={{marginLeft:'20px'}}>about</NavLink>
      </nav>
      <Routes>
        <Route exact path='/' Component={Products}/>
        <Route exact path='/about' Component={About} />
      </Routes>
     </Router>
    </div>
  );
}

export default App;
