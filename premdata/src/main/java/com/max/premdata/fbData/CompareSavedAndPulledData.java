package com.max.premdata.fbData;

import com.max.premdata.entity.*;
import com.max.premdata.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CompareSavedAndPulledData {

    @Autowired
    AreaDAO areaDAO;

    @Autowired
    CoachDAO coachDAO;

    @Autowired
    CompetitionDAO competitionDAO;

    @Autowired
    PlayerDAO playerDAO;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    SeasonDAO seasonDAO;

    @Autowired
    StandingDAO standingDAO;

    @Autowired
    TableEntryDAO tableEntryDAO;

    @Autowired
    MatchDAO matchDAO;

    @Autowired
    ScoreDAO scoreDAO;

    @Autowired
    ScoreDetailsDAO scoreDetailsDAO;

    @Autowired
    RefereeDAO refereeDAO;

    @Autowired
    ScorerDAO scorerDAO;


    private static final Logger logger = LoggerFactory.getLogger(CompareSavedAndPulledData.class);


    public Area checkAreaExists(Area area){

        logger.info("area in checkareaexists: " + area.getId());

        Optional<Area> areaOptional = areaDAO.findById(area.getId());

        if(areaOptional.isPresent()){
            Area existingArea = areaOptional.get();
            updateExistingAreaValues(existingArea, area);

            return existingArea;
        }
        else return area;
    }

    private void updateExistingAreaValues(Area existingArea, Area pulledArea){
        existingArea.setName(pulledArea.getName());
        existingArea.setCode(pulledArea.getCode());
        existingArea.setFlag(pulledArea.getFlag());
    }


    public Coach checkCoachExists(Coach coach){

        Optional<Coach> coachOptional = coachDAO.findById(coach.getId());

        if(coachOptional.isPresent()){
            Coach existingCoach = coachOptional.get();
            updateExistingCoachValues(existingCoach, coach);

            return existingCoach;
        } else return coach;
    }

    private void updateExistingCoachValues(Coach existingCoach, Coach pulledCoach){
        existingCoach.setFirstName(pulledCoach.getFirstName());
        existingCoach.setName(pulledCoach.getName());
        existingCoach.setNationality(pulledCoach.getNationality());
        existingCoach.setLastName(pulledCoach.getLastName());
        existingCoach.setDateOfBirth(pulledCoach.getDateOfBirth());
    }


    public List<Competition> checkCompetitionExists(List<Competition> competitions) {

        return competitions.stream().map(competition -> {

            Optional<Competition> competitionOptional = competitionDAO.findById(competition.getId());

            if (competitionOptional.isPresent()) {
                Competition existingCompetition = competitionOptional.get();
                updateExistingCompValues(existingCompetition, competition);
                return existingCompetition;
            } else return competition;

        }).collect(Collectors.toList());
    }

    public void updateExistingCompValues(Competition existingCompetition, Competition competition){
        existingCompetition.setCode(competition.getCode());
        existingCompetition.setEmblem(competition.getEmblem());
        existingCompetition.setName(competition.getName());
        existingCompetition.setType(competition.getType());
    }


    public List<Player> checkPlayerListExists(List<Player> players) {
        return players.stream().map(this::checkPlayerExists).collect(Collectors.toList());
    }

    public void updateExistingPlayerValues(Player existingPlayer, Player player){
        existingPlayer.setName(player.getName());
        existingPlayer.setNationality(player.getNationality());
        existingPlayer.setDateOfBirth(player.getDateOfBirth());
        existingPlayer.setPosition(player.getPosition());
    }

    public Player checkPlayerExists(Player player){
        Optional<Player> playerOptional = playerDAO.findById(player.getId());

        if (playerOptional.isPresent()) {
            Player existingPlayer = playerOptional.get();
            updateExistingPlayerValues(existingPlayer, player);
            return existingPlayer;
        } else return player;
    }


    public void saveNewOrExistingTeam(Team team){
        teamDAO.save(checkTeamExists(team));
    }

    public Team checkTeamExists(Team team){
        Optional<Team> teamOptional = teamDAO.findById(team.getId());

        if(teamOptional.isPresent()){
            Team existingTeam = teamOptional.get();
            updateExistingTeamValues(existingTeam, team);
            return existingTeam;
        } else {
            team.setArea(checkAreaExists(team.getArea()));
            team.setRunningCompetitions(checkCompetitionExists(team.getRunningCompetitions()));
            return team;
        }
    }

    private void updateExistingTeamValues(Team existingTeam, Team pulledTeam){

        existingTeam.setName(pulledTeam.getName());
        existingTeam.setShortName(pulledTeam.getShortName());
        existingTeam.setTla(pulledTeam.getTla());
        existingTeam.setCrest(pulledTeam.getCrest());
        existingTeam.setAddress(pulledTeam.getAddress());
        existingTeam.setWebsite(pulledTeam.getWebsite());
        existingTeam.setFounded(pulledTeam.getFounded());
        existingTeam.setClubColors(pulledTeam.getClubColors());
        existingTeam.setVenue(pulledTeam.getVenue());
        existingTeam.setLastUpdated(pulledTeam.getLastUpdated());
        existingTeam.setStaff(pulledTeam.getStaff());

        existingTeam.setArea(checkAreaExists(pulledTeam.getArea()));
        existingTeam.setCoach(checkCoachExists(pulledTeam.getCoach()));
        existingTeam.setRunningCompetitions(checkCompetitionExists(pulledTeam.getRunningCompetitions()));
        existingTeam.setSquad(checkPlayerListExists(pulledTeam.getSquad()));
    }

    public Team checkTeamBasicExists(Team teamBasic){

        Optional<Team> teamOptional = teamDAO.findById(teamBasic.getId());
        return teamOptional.orElse(teamBasic);
    }


    public List<Standing> checkStandingExists(List<Standing> standings, List<Standing> pulledStandings){

        return standings.stream().map(standing -> {

            logger.info("checking standing exsists, id: " + standing.getId());

            Optional<Standing> standingOptional = standingDAO.findById(standing.getId());

            if(standingOptional.isPresent()){

                logger.info("standing does exist: " + standing.getId());

                Standing existingStanding = standingOptional.get();
                updateExistingStandingValues(existingStanding, standing);
                return existingStanding;
            } else return standing;

        }).collect(Collectors.toList());
    }

    private void updateExistingStandingValues(Standing existingStanding, Standing pulledStanding){
        existingStanding.setType(pulledStanding.getType());
        existingStanding.setStage(pulledStanding.getStage());
        existingStanding.setGroupName(pulledStanding.getGroupName());
        existingStanding.setTable(checkTableEntryExists(existingStanding.getTable()));
    }


    public List<TableEntry> checkTableEntryExists(List<TableEntry> tableEntries) {

        return tableEntries.stream().map(tableEntry -> {
            logger.info("checking table entry exists");

            Optional<TableEntry> tableEntryOptional = tableEntryDAO.findById(tableEntry.getId());

            if (tableEntryOptional.isPresent()) {

                logger.info("table entry exists, id; " + tableEntry.getId());

                TableEntry existingTableEntry = tableEntryOptional.get();
                updateExistingTableEntryValues(existingTableEntry, tableEntry);
                return existingTableEntry;
            } else return tableEntry;

        }).collect(Collectors.toList());
    }

    public void updateExistingTableEntryValues(TableEntry existingTableEntry, TableEntry tableEntry){

        logger.info("updating values: " + tableEntry.getGoalsFor());
        existingTableEntry.setPosition(tableEntry.getPosition());
        existingTableEntry.setPlayedGames(tableEntry.getPlayedGames());
        existingTableEntry.setForm(tableEntry.getForm());
        existingTableEntry.setWon(tableEntry.getWon());
        existingTableEntry.setDraw(tableEntry.getDraw());
        existingTableEntry.setLost(tableEntry.getLost());
        existingTableEntry.setPoints(tableEntry.getPoints());
        existingTableEntry.setGoalsFor(tableEntry.getGoalsFor());
        existingTableEntry.setGoalsAgainst(tableEntry.getGoalsAgainst());
        existingTableEntry.setGoalDifference(tableEntry.getGoalDifference());
    }


    public Competition checkSingleCompetitionExists(Competition competition) {

            Optional<Competition> competitionOptional = competitionDAO.findById(competition.getId());

            if (competitionOptional.isPresent()) {
                Competition existingCompetition = competitionOptional.get();
                updateExistingSingleCompetitionValues(existingCompetition, competition);
                return existingCompetition;
            } else return competition;
    }

    public void updateExistingSingleCompetitionValues(Competition existingCompetition, Competition competition){
        existingCompetition.setCode(competition.getCode());
        existingCompetition.setEmblem(competition.getEmblem());
        existingCompetition.setName(competition.getName());
        existingCompetition.setType(competition.getType());
    }


    public void saveNewOrExistingSeason(Season season) {
        seasonDAO.save(checkSeasonExists(season));
    }

    public Season checkSeasonExists(Season season){

        Optional<Season> seasonOptional = seasonDAO.findById(season.getId());

        if(seasonOptional.isPresent()){
            Season existingSeason = seasonOptional.get();
            updateExistingSeasonValues(existingSeason, season);
            logger.info("saving existing");
            return existingSeason;
        } else {
            logger.info("saving");

            for (Standing standing : season.getStandings()) {
                standing.setSeason(season);

                for(TableEntry tableEntry : standing.getTable()){
                    tableEntry.setStanding(standing);
                }
            }

            season.setCompetition(checkSingleCompetitionExists(season.getCompetition()));
            return season;
        }
    }

    private void updateExistingSeasonValues(Season existingSeason, Season pulledSeason){

        existingSeason.setStartDate(pulledSeason.getStartDate());
        existingSeason.setEndDate(pulledSeason.getEndDate());
        existingSeason.setCurrentMatchday(pulledSeason.getCurrentMatchday());
        existingSeason.setWinner(pulledSeason.getWinner());

        existingSeason.setCompetition(checkSingleCompetitionExists(existingSeason.getCompetition()));

        existingSeason.getStandings().clear();

        for(Standing s : pulledSeason.getStandings()){
            s.setSeason(existingSeason);

            for(TableEntry tableEntry : s.getTable()){
                tableEntry.setStanding(s);
            }
        }

        existingSeason.setStandings(pulledSeason.getStandings());
    }

    private static void mapStandings(Season existingSeason, List<Standing> standingList) {
        for (Standing standing : standingList) {
            standing.setSeason(existingSeason);

            for(TableEntry tableEntry : standing.getTable()){
                tableEntry.setStanding(standing);
            }
        }
        existingSeason.getStandings().addAll(standingList);
    }


    public void checkMatchExists(Match match) {

        Optional<Match> optionalMatch = matchDAO.findById(match.getId());

        if(optionalMatch.isEmpty()){

            List<Referee> referees = new ArrayList<>();

                for(Referee referee : match.getReferees()){
                    referees.add(checkRefereeExists(referee));
                }

                match.setReferees(referees);

            matchDAO.save(match);
        } else {
            Match existingMatch = optionalMatch.get();

            existingMatch.setScore(match.getScore());
            matchDAO.save(existingMatch);
        }
    }

    private void updateExistingMatchValues(Match existingMatch, Match pulledMatch){

        existingMatch.setAreaId(pulledMatch.getAreaId());
        existingMatch.setMatchday(pulledMatch.getMatchday());
        existingMatch.setStatus(pulledMatch.getStatus());
        existingMatch.setUtcDate(pulledMatch.getUtcDate());
        existingMatch.setScore(checkScoreExists(pulledMatch.getScore()));
        existingMatch.setStage(pulledMatch.getStage());
        existingMatch.setLastUpdated(pulledMatch.getLastUpdated());
    }


    public Score checkScoreExists(Score score){

        Optional<Score> scoreOptional = scoreDAO.findById(score.getId());

        if(scoreOptional.isPresent()){
            Score existingScore = scoreOptional.get();
            updateExistingScoreValues(existingScore, score);
            return existingScore;
        } else {
            return score;
        }
    }

    private void updateExistingScoreValues(Score existingScore, Score pulledScore){

        existingScore.setWinner(pulledScore.getWinner());
        existingScore.setDuration(pulledScore.getDuration());
        existingScore.setHalfTime(checkScoreDetailsExists(pulledScore.getHalfTime()));
        existingScore.setFullTime(checkScoreDetailsExists(pulledScore.getFullTime()));
    }


    public ScoreDetails checkScoreDetailsExists(ScoreDetails scoreDetails){

        Optional<ScoreDetails> scoreDetailsOptional = scoreDetailsDAO.findById(scoreDetails.getId());
        return scoreDetailsOptional.orElse(scoreDetails);
    }


    public Referee checkRefereeExists(Referee referee){

        Optional<Referee> refereeOptional = refereeDAO.findById(referee.getId());

        if(refereeOptional.isPresent()){
            Referee existingReferee = refereeOptional.get();
            return existingReferee;

        } else {
            return referee;
        }
    }


    public void checkAndPersistTopScorer(Scorer scorer){

        Optional<Scorer> existingScorerOptional = scorerDAO.findByPlayerId(scorer.getPlayer().getId());

        if (existingScorerOptional.isPresent()){
            Scorer existingScorer = existingScorerOptional.get();
            existingScorer.setGoals(scorer.getGoals());
            existingScorer.setPlayedMatches(scorer.getPlayedMatches());
            existingScorer.setAssists(scorer.getAssists());
            existingScorer.setPenalties(scorer.getPenalties());
            existingScorer.setPlayerName(scorer.getPlayerName());
            existingScorer.setTeamName(scorer.getTeamName());

            scorerDAO.save(existingScorer);

        } else {
            Season season = seasonDAO.getReferenceById(scorer.getSeason().getId());
            Competition competition = competitionDAO.getReferenceById(scorer.getCompetition().getId());
            Player player = checkPlayerExists(scorer.getPlayer());
            Team team = teamDAO.getReferenceById(scorer.getTeamId());

            scorer.setSeason(season);
            scorer.setCompetition(competition);
            scorer.setPlayer(playerDAO.save(player));
            scorer.setTeamId(team.getId());

            scorerDAO.save(scorer);
        }
    }


}
