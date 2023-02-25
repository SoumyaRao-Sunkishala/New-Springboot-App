import logo from './logo.svg';
import './App.css';
import { HomePage } from './Component/HomePage';
import { Footer } from './Component/Footer';
import { MainRoutes } from './Component/MainRoutes';
import Login from './Component/Login';

function App() {
  return (
    <div className="App">
        {/* <HomePage/> */}
        {/* <Footer/> */}
        <MainRoutes/>
        {/* <Login/> */}
    </div>
  );
}

export default App;
