import './TeamCard.css'
import {Link} from "react-router-dom";

const TeamCard = ({ team }) => {
    return (
        <Link to={"/teams/"+team.id} className="card">
            <img src={team.logo}/>
            <div className="overlay" style={{backgroundColor: team.primaryColor}}>
                <div className="text">{team.name}</div>
            </div>
        </Link>
    );
};

export default TeamCard;