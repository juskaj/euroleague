import React, {useEffect} from 'react';
import './TeamBackground.css'

const TeamBackground = ( { team } ) => {

    return (
        <div className="team-background" style={{backgroundColor: team.primaryColor}}>
            <div className="team-background-cover" style={{backgroundColor: team.primaryColor}}/>
            <img className="team-background-picture" src={team.teamPicture}/>
            <div className="team-page">
                <div className="container">
                    <div className="team-logo-container">
                        <img className="team-logo" src={team.logo}/>
                    </div>
                    <div className="team-name-text">{team.name}</div>
                </div>
            </div>
        </div>
    );
};

export default TeamBackground;