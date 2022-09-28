import axios from "axios";
import {useEffect, useState} from "react";
import PlayerCard from "../components/PlayerCard/PlayerCard";
import TeamCard from "../components/TeamCard/TeamCard";
import Loader from "../components/Loader/Loader";

const Teams = () => {

    const [allTeams, setAllTeams] = useState(null)

    useEffect(() => {
        getAllTeams().then(data => {
            setAllTeams(data)
            console.log(allTeams)
        })
    }, [])

    async function getAllTeams() {
        return await axios.get("http://localhost:8080/teams").then(response => response.data)
    }

    const loadedRender = () => {
        return (
            <div>
                <div className="card-container">
                    {allTeams == null ? "" : allTeams.map((team, i) => <TeamCard team={team} key={i}/>)}
                </div>
            </div>
        )
    }

    return (
        <div>
            <h1>All Teams</h1>
            {allTeams == null ? <Loader/> : loadedRender()}
        </div>
    );
};

export default Teams;