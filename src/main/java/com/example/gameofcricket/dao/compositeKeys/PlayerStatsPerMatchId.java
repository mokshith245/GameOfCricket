package com.example.gameofcricket.dao.compositeKeys;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class PlayerStatsPerMatchId implements Serializable {
    private int matchId;
    private int playerId;
}
