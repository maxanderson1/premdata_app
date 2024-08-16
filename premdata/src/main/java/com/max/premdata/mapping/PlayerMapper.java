package com.max.premdata.mapping;

import com.max.premdata.dto.PlayerDTO;
import com.max.premdata.entity.*;
import org.springframework.stereotype.Component;


@Component
public class PlayerMapper {

    public static Player toPlayerEntity(PlayerDTO playerDTO) {
        if (playerDTO == null) {
            return null;
        }

        Player player = new Player();

        player.setId(playerDTO.getId());
        player.setName(playerDTO.getName());
        player.setNationality(playerDTO.getNationality());
        player.setDateOfBirth(playerDTO.getDateOfBirth());
        player.setPosition(playerDTO.getPosition());




        return player;
    }

}
