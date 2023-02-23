package com.example.gameofcricket.dao;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class PlayerStatsId implements Serializable
{
    private String playerName;
    private String teamName;

}
