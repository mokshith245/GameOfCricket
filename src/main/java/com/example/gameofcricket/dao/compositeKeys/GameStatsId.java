package com.example.gameofcricket.dao.compositeKeys;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class GameStatsId implements Serializable {
    private String teamName;
    private int matchId;
}
