package com.max.premdata.mapping;

import com.max.premdata.dto.ScoreDTO;
import com.max.premdata.entity.Score;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapping {

    public static Score toScoreEntity(ScoreDTO scoreDTO){

        if (scoreDTO == null) {
            return null;
        }

        Score score = new Score();

        score.setDuration(scoreDTO.getDuration());
        score.setFullTime(ScoreDetailsMapper.toScoreDetailsEntity(scoreDTO.getFullTime()));
        score.setHalfTime(ScoreDetailsMapper.toScoreDetailsEntity(scoreDTO.getHalfTime()));
        score.setWinner(scoreDTO.getWinner());

        return score;
    }


}
