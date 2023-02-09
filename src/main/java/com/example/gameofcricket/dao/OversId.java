package com.example.gameofcricket.dao;

import jakarta.persistence.Id;

import lombok.EqualsAndHashCode;
import java.io.Serializable;

@EqualsAndHashCode
public class OversId implements Serializable
{

    private int matchId;
    private String teamName;

    private float overs;

    @Override
    public String toString() {
        return "OversId{" +
                "matchId=" + matchId +
                ", teamName='" + teamName + '\'' +
                ", overs=" + overs +
                '}';
    }
}
