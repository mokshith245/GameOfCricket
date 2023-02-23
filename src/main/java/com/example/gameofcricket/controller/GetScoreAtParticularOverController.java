package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.service.ScoreAtParticularTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class GetScoreAtParticularOverController
{
    @Autowired
    private ScoreAtParticularTimeService scoreAtParticularTimeService;
    @RequestMapping("/getScore/{id}/{name}/{over}")
    public List<ScoreAtParticularOver> getScore(@PathVariable int id, @PathVariable String name, @PathVariable float over)
    {
        return scoreAtParticularTimeService.getScoreAtOver(id,name,over);
    }

}
