package com.max.premdata.fbData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.max.premdata.controller.TeamController;
import com.max.premdata.dto.MatchResponseDTO;
import com.max.premdata.dto.StandingsResponseDTO;
import com.max.premdata.dto.TeamDTO;
import com.max.premdata.dto.TopScorersDTO;
import com.max.premdata.entity.Property;
import com.max.premdata.repository.PropertyDAO;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FootballDataAPIService {

    private final WebClient webClient;

    private String authToken;

    private static final Logger logger = LoggerFactory.getLogger(FootballDataAPIService.class);


    @Autowired
    public FootballDataAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Autowired
    PropertyDAO propertyDAO;

    @PostConstruct
    private void init(){
        Property authTokenProperty = this.propertyDAO.findByKey("X-Auth-Token");
        this.authToken = authTokenProperty.getValue();

        System.out.println("auth token here "+authToken);
    }


    public Mono<TeamDTO> getTeamExternalData(String teamId) {
        waitSixSeconds();

        return this.webClient.get()
                .uri("http://api.football-data.org/v4/teams/" + teamId)
                .header("X-Auth-Token", this.authToken)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(this::convertToTeam);
    }

    private Mono<TeamDTO> convertToTeam(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TeamDTO team = objectMapper.readValue(json, TeamDTO.class);
            System.out.println("team here: " + team.getVenue());

            return Mono.just(team);
        } catch (Exception e) {
            return Mono.error(new RuntimeException("Failed to convert JSON to Team", e));
        }
    }


    public Mono<StandingsResponseDTO> getStandingsExternalData(String season) {
        waitSixSeconds();

        return this.webClient.get()
                .uri("http://api.football-data.org/v4/competitions/PL/standings?season=" + season)
                .header("X-Auth-Token", this.authToken)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(this::convertToStandingsResponse);
    }


    private Mono<StandingsResponseDTO> convertToStandingsResponse(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            StandingsResponseDTO standingsResponse = objectMapper.readValue(json, StandingsResponseDTO.class);

            return Mono.just(standingsResponse);
        } catch (Exception e) {
            return Mono.error(new RuntimeException("Failed to convert JSON to StandingsResponse", e));
        }
    }


    public Mono<MatchResponseDTO> getMatchExternalData(int matchweek) {

        waitSixSeconds();

        return this.webClient.get()
                .uri("http://api.football-data.org/v4/competitions/2021/matches?matchday=" + matchweek)
                .header("X-Auth-Token", this.authToken)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(this::convertToMatchResponseDTO);
    }

    private Mono<MatchResponseDTO> convertToMatchResponseDTO(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MatchResponseDTO matchResponseDTO = objectMapper.readValue(json, MatchResponseDTO.class);

            return Mono.just(matchResponseDTO);
        } catch (Exception e) {
            return Mono.error(new RuntimeException("Failed to convert JSON to Match", e));
        }
    }


    public Mono<TopScorersDTO> getPLTopScorers() {

        waitSixSeconds();

        return this.webClient.get()
                .uri("http://api.football-data.org/v4/competitions/2021/scorers?limit=20")
                .header("X-Auth-Token", this.authToken)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(this::convertToTopScorersDTO);
    }

    private Mono<TopScorersDTO> convertToTopScorersDTO(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TopScorersDTO topScorersDTO = objectMapper.readValue(json, TopScorersDTO.class);
            return Mono.just(topScorersDTO);
        } catch (Exception e) {
            return Mono.error(new RuntimeException("Failed to convert JSON to top scorers", e));
        }
    }


    public void waitSixSeconds(){

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
