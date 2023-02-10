package com.example.gameofcricket.dao;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class TeamId implements Serializable
{
    private int matchId;
    private String name;

}
