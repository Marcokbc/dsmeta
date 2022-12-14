import logo from "../../assets/img/logo.svg"
import './style.css'
function Header() {
    return (
        <>
            <header>
                <div className="dsmeta-logo-container">
                    <img src={logo} alt="DSMeta" />
                    <h1>Sales System</h1>
                    <p>
                        Desenvolvido por
                        <a href="https://www.instagram.com/marcoantonio.dev">@marcoantonio.dev</a>
                    </p>
                </div>
            </header>
        </>
    )
}

export default Header