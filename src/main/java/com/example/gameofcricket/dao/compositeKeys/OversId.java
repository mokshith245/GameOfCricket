package com.example.gameofcricket.dao.compositeKeys;

import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class OversId implements Serializable {
    private int matchId;
    private String teamName;
    private float overs;


}
