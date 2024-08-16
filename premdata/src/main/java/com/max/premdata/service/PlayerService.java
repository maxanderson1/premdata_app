package com.max.premdata.service;
import com.max.premdata.entity.Player;
import com.max.premdata.entity.Team;
import com.max.premdata.repository.PlayerDAO;
import com.max.premdata.repository.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    PlayerDAO playerDAO;

    @Autowired
    TeamDAO teamDAO;

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


//    public List<Player> getSquad(Long teamId){
//
//        List<Player> squad = new ArrayList<>();
//
//        Optional<Team> optionalTeam = teamDAO.findById(teamId);
//
//        if(optionalTeam.isPresent()){
//            Team team = optionalTeam.get();
//            squad = team.getSquad();
//        }
//        return squad;
//    }
}
