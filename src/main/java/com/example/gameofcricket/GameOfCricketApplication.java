package com.example.gameofcricket;

import com.example.gameofcricket.dao.repositories.*;
import com.example.gameofcricket.elasticSearchRepository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = JpaRepository.class))
@EnableElasticsearchRepositories(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ElasticsearchRepository.class))
public class GameOfCricketApplication {
    public static PlayerStatsPerMatchRepository playerStatsPerMatchRepository;
    public static TeamRepository teamRepository;
    public static PlayerRepository playerRepository;
    public static UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    public static GameStatsRepository gameStatsRepository;
    public static PlayerRepo playerRepo;
    public static TeamRepo teamRepo;
    public static GameStatsRepo gameStatsRepo;
    public static PlayerStatsPerMatchRepo playerStatsPerMatchRepo;
    public static UpdateScoreAfterEveryBallRepo updateScoreAfterEveryBallRepo;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GameOfCricketApplication.class, args);
        playerRepository = context.getBean(PlayerRepository.class);
        updateScoreAfterEveryBallRepository = context.getBean(UpdateScoreAfterEveryBallRepository.class);
        teamRepository = context.getBean(TeamRepository.class);
        gameStatsRepository = context.getBean(GameStatsRepository.class);
        playerStatsPerMatchRepository = context.getBean(PlayerStatsPerMatchRepository.class);
        playerRepo = context.getBean(PlayerRepo.class);
        teamRepo=context.getBean(TeamRepo.class);
        gameStatsRepo=context.getBean(GameStatsRepo.class);
        playerStatsPerMatchRepo=context.getBean(PlayerStatsPerMatchRepo.class);
        updateScoreAfterEveryBallRepo=context.getBean(UpdateScoreAfterEveryBallRepo.class);

    }
}
