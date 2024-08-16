package com.max.premdata.mapping;

import com.max.premdata.dto.AreaDTO;
import com.max.premdata.entity.Area;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper {

    public static Area toAreaEntity(AreaDTO areaDTO) {
        if (areaDTO == null) {
            return null;
        }

        Area area = new Area();

        area.setId(areaDTO.getId());
        area.setName(areaDTO.getName());
        area.setCode(areaDTO.getCode());
        area.setFlag(areaDTO.getFlag());

        return area;
    }
}
