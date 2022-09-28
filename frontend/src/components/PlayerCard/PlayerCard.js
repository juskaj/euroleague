import React from 'react';

function PlayerCard({ player }) {
    return (
        <div>
            <p>{player.name}</p>
            <p>{player.surname}</p>
        </div>
    );
}

export default PlayerCard;