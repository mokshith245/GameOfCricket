package com.example.gameofcricket.dao.compositeKeys;



import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class PlayerId implements Serializable
{
    private String teamName;
    private String name;
    private int matchId;
}
