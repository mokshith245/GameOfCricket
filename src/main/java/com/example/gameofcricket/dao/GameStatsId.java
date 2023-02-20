package com.example.gameofcricket.dao;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class GameStatsId implements Serializable
{
    private String teamName;
    private int matchId;
}
