package com.max.premdata.mapping;

import com.max.premdata.dto.ScoreDetailDTO;
import com.max.premdata.entity.ScoreDetails;
import org.springframework.stereotype.Component;

@Component
public class ScoreDetailsMapper {

    public static ScoreDetails toScoreDetailsEntity(ScoreDetailDTO scoreDetailDTO){

        if (scoreDetailDTO == null) {
            return null;
        }

        ScoreDetails scoreDetails = new ScoreDetails();

        scoreDetails.setHome(scoreDetailDTO.getHome());
        scoreDetails.setAway(scoreDetailDTO.getAway());

        return scoreDetails;
    }
}
