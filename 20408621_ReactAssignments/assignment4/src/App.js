import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import About from './Component/about';
import './App.css';
import "./index.css"
import { BrowserRouter as Router ,Route,Routes, NavLink } from 'react-router-dom';
import AddProduct from './Component/addproduct';
import Products from './Component/products';
import Display from './Component/display';

function App() {
  return (
    <Router>
      <nav style={{marginLeft:200,marginTop:100}}>
      <NavLink exact className="btn btn-primary" to="/" style={{marginLeft:'100px'}}>products</NavLink>
        <NavLink  className="btn btn-secondary navig" to="/about" style={{marginLeft:'200px'}}>about</NavLink>
      </nav>
       <div>  
      <Routes>
        <Route path='/' Component={Products} />
        <Route path='/about' Component={About} />
        <Route exact path='/addProduct' Component={AddProduct} />
        <Route exact path='/display/:name' Component={Display}/>
        </Routes>
        </div>
    </Router>
   
  );
}
export default App;
