package com.max.premdata.fbData;

import com.max.premdata.entity.*;
import com.max.premdata.job.PullDataJob;
import com.max.premdata.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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

//    @Autowired
//    FilterDAO filterDAO;

    @Autowired
    SeasonDAO seasonDAO;

    @Autowired
    StandingDAO standingDAO;

    @Autowired
    TableEntryDAO tableEntryDAO;

//    @Autowired
//    StandingsResponseDAO standingsResponseDAO;

    private static final Logger logger = LoggerFactory.getLogger(CompareSavedAndPulledData.class);


    public Area checkAreaExists(Area area){

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




    public List<Player> checkPlayerExists(List<Player> players) {

        return players.stream().map(player -> {

            Optional<Player> playerOptional = playerDAO.findById(player.getId());

            if (playerOptional.isPresent()) {
                Player existingPlayer = playerOptional.get();
                updateExistingPlayerValues(existingPlayer, player);
                return existingPlayer;
            } else return player;

        }).collect(Collectors.toList());

    }

    public void updateExistingPlayerValues(Player existingPlayer, Player player){

        existingPlayer.setName(player.getName());
        existingPlayer.setNationality(player.getNationality());
        existingPlayer.setDateOfBirth(player.getDateOfBirth());
        existingPlayer.setPosition(player.getPosition());
    }

    public void checkTeamExists(Team team){

        Optional<Team> teamOptional = teamDAO.findById(team.getId());

        if(teamOptional.isPresent()){
            Team existingTeam = teamOptional.get();
            updateExistingTeamValues(existingTeam, team);
            teamDAO.save(existingTeam);
        } else {

            team.setArea(checkAreaExists(team.getArea()));
            team.setRunningCompetitions(checkCompetitionExists(team.getRunningCompetitions()));
            teamDAO.save(team);
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
        existingTeam.setSquad(checkPlayerExists(pulledTeam.getSquad()));
    }



//    public Filter checkFilterExists(Filter filter){
//
//        Optional<Filter> filterOptional = filterDAO.findById(filter.getId());
//
//        if(filterOptional.isPresent()){
//            Filter existingFilter = filterOptional.get();
//            updateExistingFilterValues(existingFilter, filter);
//            return existingFilter;
//        } else return filter;
//    }
//
//    private void updateExistingFilterValues(Filter existingFilter, Filter pulledFilter){
//        existingFilter.setSeason(pulledFilter.getSeason());
//
//    }


//    public Season checkSeasonExists(Season season){
//
//        Optional<Season> seasonOptional = seasonDAO.findById(season.getId());
//
//        if(seasonOptional.isPresent()){
//            Season existingSeason = seasonOptional.get();
//            updateExistingSeasonValues(existingSeason, season);
//            return existingSeason;
//        } else return season;
//    }

//    private void updateExistingSeasonValues(Season existingSeason, Season pulledSeason){
//
//        existingSeason.setStartDate(pulledSeason.getStartDate());
//        existingSeason.setEndDate(pulledSeason.getEndDate());
//        existingSeason.setCurrentMatchday(pulledSeason.getCurrentMatchday());
//        existingSeason.setWinner(pulledSeason.getWinner());
//    }


    public List<Standing> checkStandingExists(List<Standing> standings){

        return standings.stream().map(standing -> {

            Optional<Standing> standingOptional = standingDAO.findById(standing.getId());

            if(standingOptional.isPresent()){
                Standing existingStanding = standingOptional.get();
                updateExistingSeasonValues(existingStanding, standing);
                return existingStanding;
            } else return standing;

        }).collect(Collectors.toList());


    }

    private void updateExistingSeasonValues(Standing existingStanding, Standing pulledStanding){

        existingStanding.setType(pulledStanding.getType());
        existingStanding.setStage(pulledStanding.getStage());
        existingStanding.setGroupName(pulledStanding.getGroupName());

        existingStanding.setTable(checkTableEntryExists(pulledStanding.getTable()));
    }


    public List<TableEntry> checkTableEntryExists(List<TableEntry> tableEntries) {

        return tableEntries.stream().map(tableEntry -> {

            Optional<TableEntry> tableEntryOptional = tableEntryDAO.findById(tableEntry.getId());

            if (tableEntryOptional.isPresent()) {
                TableEntry existingTableEntry = tableEntryOptional.get();
                updateExistingTableEntryValues(existingTableEntry, tableEntry);
                return existingTableEntry;
            } else return tableEntry;

        }).collect(Collectors.toList());

    }

    public void updateExistingTableEntryValues(TableEntry existingTableEntry, TableEntry tableEntry){

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

    public Competition checkStandingsCompetitionExists(Competition competition) {

            Optional<Competition> competitionOptional = competitionDAO.findById(competition.getId());

            if (competitionOptional.isPresent()) {
                Competition existingCompetition = competitionOptional.get();
                updateExistingStandingsCompValues(existingCompetition, competition);
                return existingCompetition;
            } else return competition;


    }

    public void updateExistingStandingsCompValues(Competition existingCompetition, Competition competition){

        existingCompetition.setCode(competition.getCode());
        existingCompetition.setEmblem(competition.getEmblem());
        existingCompetition.setName(competition.getName());
        existingCompetition.setType(competition.getType());

    }


//    public void checkStandingsResponseExists(StandingsResponse standingsResponse){
//
////        Optional<StandingsResponse> standingsResponseOptional = standingsResponseDAO.findById(standingsResponse.getId());
////
////        if(standingsResponseOptional.isPresent()){
////            StandingsResponse existingStandingsResponse = standingsResponseOptional.get();
////            updateExistingStandingsResponseValues(existingStandingsResponse, standingsResponse);
////            standingsResponseDAO.save(existingStandingsResponse);
////        } else standingsResponseDAO.save(standingsResponse);
//
//
//        Area area = checkAreaExists(standingsResponse.getArea());
//        Competition competition = checkStandingsCompetitionExists(standingsResponse.getCompetition());
//        Filter filter = checkFilterExists(standingsResponse.getFilters());
//        Season season = checkSeasonExists(standingsResponse.getSeason());
//        List<Standing> standings = checkStandingExists(standingsResponse.getStandings());
//
//        areaDAO.save(area);
//        competitionDAO.save(competition);
//        filterDAO.save(filter);
//        seasonDAO.save(season);
//
//        for(Standing standing : standings){
//            standingDAO.save(standing);
//        }
//    }
//
//    private void updateExistingStandingsResponseValues(StandingsResponse existingStandingsResponse, StandingsResponse pulledStandingsResponse){
//
//        existingStandingsResponse.setArea(checkAreaExists(pulledStandingsResponse.getArea()));
//        existingStandingsResponse.setCompetition(checkStandingsCompetitionExists(pulledStandingsResponse.getCompetition()));
//        existingStandingsResponse.setFilters(checkFilterExists(pulledStandingsResponse.getFilters()));
//        existingStandingsResponse.setSeason(checkSeasonExists(pulledStandingsResponse.getSeason()));
//        existingStandingsResponse.setStandings(checkStandingExists(pulledStandingsResponse.getStandings()));
//
//    }


    public void checkSeasonExists(Season season) {

        Optional<Season> seasonOptional = seasonDAO.findById(season.getId());

        if(seasonOptional.isPresent()){
            Season existingSeason = seasonOptional.get();
            updateExistingSeasonValues(existingSeason, season);
            logger.info("saving existing");
            seasonDAO.save(existingSeason);
        } else {
            logger.info("saving");

            for (Standing standing : season.getStandings()) {
                standing.setSeason(season); // Set the season reference in each standing

                for(TableEntry tableEntry : standing.getTable()){
                    tableEntry.setStanding(standing);
                }
            }

            season.setCompetition(checkStandingsCompetitionExists(season.getCompetition()));

            //season.getStandings().addAll(season.getStandings());
            seasonDAO.save(season);
        }
    }

    private void updateExistingSeasonValues(Season existingSeason, Season pulledSeason){

        existingSeason.setStartDate(pulledSeason.getStartDate());
        existingSeason.setEndDate(pulledSeason.getEndDate());
        existingSeason.setCurrentMatchday(pulledSeason.getCurrentMatchday());
        existingSeason.setWinner(pulledSeason.getWinner());

        existingSeason.setCompetition(checkStandingsCompetitionExists(existingSeason.getCompetition()));

        //existingSeason.getStandings().clear();

        existingSeason.setStandings(checkStandingExists(existingSeason.getStandings()));

        //mapStandings(existingSeason, pulledSeason.getStandings());


    }

    private static void mapStandings(Season existingSeason, List<Standing> standingList) {
        // Set the new standings
        for (Standing standing : standingList) {
            standing.setSeason(existingSeason); // Set the season reference in each standing

            for(TableEntry tableEntry : standing.getTable()){
                tableEntry.setStanding(standing);
            }
        }
        existingSeason.getStandings().addAll(standingList);
    }
}
