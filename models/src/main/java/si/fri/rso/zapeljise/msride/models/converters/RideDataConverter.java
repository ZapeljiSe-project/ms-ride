package si.fri.rso.zapeljise.msride.models.converters;

import si.fri.rso.zapeljise.msride.lib.RideData;
import si.fri.rso.zapeljise.msride.models.entities.RideDataEntity;

public class RideDataConverter {
    public static RideData toDto(RideDataEntity entity) {
        RideData dto = new RideData();
        dto.setActive(entity.getActive());
        dto.setId(entity.getId());
        dto.setFromTown(entity.getFromTown());
        dto.setToTown(entity.getToTown());
        dto.setDate(entity.getDate());
        dto.setTimeMinutes(entity.getTimeMinutes());
        dto.setTimeHours(entity.getTimeHours());
        dto.setPrice(entity.getPrice());
        dto.setDriver(entity.getDriver());
        dto.setNotes(entity.getNotes());
        dto.setSpace(entity.getSpace());
        dto.setCar(entity.getCar());
        dto.setInsurance(entity.getInsurance());
        dto.setPhone(entity.getPhone());
        dto.setPick(entity.getPick());
        dto.setUserId(entity.getUserId());
        return dto;
    }

    public static RideDataEntity toEntity(RideData dto) {
        RideDataEntity entity = new RideDataEntity();
        entity.setActive(dto.getActive());
        entity.setId(dto.getId());
        entity.setFromTown(dto.getFromTown());
        entity.setToTown(dto.getToTown());
        entity.setDate(dto.getDate());
        entity.setTimeMinutes(dto.getTimeMinutes());
        entity.setTimeHours(dto.getTimeHours());
        entity.setPrice(dto.getPrice());
        entity.setDriver(dto.getDriver());
        entity.setNotes(dto.getNotes());
        entity.setSpace(dto.getSpace());
        entity.setCar(dto.getCar());
        entity.setInsurance(dto.getInsurance());
        entity.setPhone(dto.getPhone());
        entity.setPick(dto.getPick());
        entity.setUserId(dto.getUserId());
        return entity;
    }
}