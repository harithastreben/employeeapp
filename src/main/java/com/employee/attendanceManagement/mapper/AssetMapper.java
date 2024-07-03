package com.employee.attendanceManagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.employee.attendanceManagement.dto.AssetRequest;
import com.employee.attendanceManagement.dto.AssetResponse;
import com.employee.attendanceManagement.entity.Asset;

@Mapper(componentModel="Spring")
public interface AssetMapper {

	Asset toEntity(AssetRequest assetRequest);

	AssetResponse toResponse(Asset asset);

	List<AssetResponse> toResponseDto(List<Asset> byIsDeletedFalse);

}
