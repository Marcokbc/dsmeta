import Header from "./components/Header"
import NotificationButton from "./components/NotificationButton"
import SalesCard from "./components/SalesCard"
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";
import CreateCard from "./components/CreateCard";

function App() {
  return (
    <Router>
      <ToastContainer />
        <Header />
        <main>
          <section id="sales">
            <div className="dsmeta-container">
                  <Routes>
                    <Route exact path="/" element={<SalesCard />} />
                  </Routes>
            </div>
          </section>
          <section>
            <div>
              <Routes>
                <Route exact path="/create" element={<CreateCard />}></Route>
              </Routes>
            </div>
          </section>
        </main>
    </Router>
  )
}

export default App
