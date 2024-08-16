package com.max.premdata.mapping;
import com.max.premdata.dto.TeamDTO;
import com.max.premdata.entity.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TeamMapper {

    public static Team toTeamEntity(TeamDTO teamDTO) {
        if (teamDTO == null) {
            return null;
        }

        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setShortName(teamDTO.getShortName());
        team.setTla(teamDTO.getTla());
        team.setCrest(teamDTO.getCrest());
        team.setAddress(teamDTO.getAddress());
        team.setWebsite(teamDTO.getWebsite());
        team.setFounded(teamDTO.getFounded());
        team.setClubColors(teamDTO.getClubColors());
        team.setVenue(teamDTO.getVenue());
        team.setLastUpdated(teamDTO.getLastUpdated());
        team.setStaff(teamDTO.getStaff());

        Area area = AreaMapper.toAreaEntity(teamDTO.getArea());
        Coach coach = CoachMapper.toCoachEntity(teamDTO.getCoach());

        List<Competition> competitions = teamDTO.getRunningCompetitions().stream()
                .map(CompetitionMapper::toCompetitionEntity)
                .toList();

        List<Player> players = teamDTO.getSquad().stream()
                        .map(playerDTO -> {
                            Player player = PlayerMapper.toPlayerEntity(playerDTO);
                            player.setTeam(team);
                            return player;
                        })
                                .toList();

//        for (Player player : players){
//            player.setTeam(team);
//        }

        team.setArea(area);
        team.setCoach(coach);
        team.setRunningCompetitions(competitions);
        team.setSquad(players);

        return team;
    }



}
