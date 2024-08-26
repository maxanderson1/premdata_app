package com.max.premdata.mapping;

import com.max.premdata.dto.AreaDTO;
import com.max.premdata.entity.Area;
import com.max.premdata.fbData.CompareSavedAndPulledData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper {

    private static final Logger logger = LoggerFactory.getLogger(AreaMapper.class);


    public static Area toAreaEntity(AreaDTO areaDTO) {
        if (areaDTO == null) {
            return null;
        }

        Area area = new Area();

        area.setId(areaDTO.getId());
        logger.info("area id in mapper: " + area.getId());
        area.setName(areaDTO.getName());
        area.setCode(areaDTO.getCode());
        area.setFlag(areaDTO.getFlag());

        return area;
    }
}
