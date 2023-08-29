import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './App.css';
import { BrowserRouter as Router,Routes, Route} from 'react-router-dom';
import About from './data/data';
import Products from './data/products';
import './myindex.css'
function App() {
  return (
    <Router>
        <ul>
          <li>
            <a href="/about">About</a>
            </li>
            <li>
            <a href="/products">Products</a>
          </li>
            </ul>
    <Routes>
            <Route exact path="/about" element={< About />}></Route>
            <Route exact path="/products" element={< Products />}></Route>
    </Routes>
</Router>
  );
}

export default App;
