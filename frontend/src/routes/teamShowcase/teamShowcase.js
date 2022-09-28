import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";
import './teamShowcase.css'
import TeamBackground from "../../components/TeamBackground/TeamBackground";

const TeamShowcase = () => {
    const [team, setTeam] = useState(null)
    let { id } = useParams()

    async function getTeam () {
        return (await axios.get("http://localhost:8080/teams/" + id)).data
    }

    useEffect(() => {
        getTeam().then(data => {
            setTeam(data)
        })
    }, [])

    const renderMore = () => {
        return (
            <div>
                <TeamBackground team={team}/>
            </div>
        )
    }

    return (
        <div>
            {team == null ? "" : renderMore()}
        </div>
    );
};

export default TeamShowcase;