import async from "async";
import axios from "axios";

const Players = () => {

    async function getPlayers() {
        const players = await axios.get("http://localhost:8080/players")
        console.log(players.data)
    }

    return (
        <div>
            <h1>Players!</h1>
            <button onClick={getPlayers}>Players</button>
        </div>
    );
};

export default Players;