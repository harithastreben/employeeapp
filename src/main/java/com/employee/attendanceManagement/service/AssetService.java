package com.employee.attendanceManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.attendanceManagement.dto.AssetRequest;
import com.employee.attendanceManagement.dto.AssetResponse;
import com.employee.attendanceManagement.entity.Asset;
import com.employee.attendanceManagement.exception.AssetNotFoundException;
import com.employee.attendanceManagement.mapper.AssetMapper;
import com.employee.attendanceManagement.repository.AssetRepository;


@Service
public class AssetService {

	@Autowired
	private AssetRepository assetRepo;

	@Autowired
	private AssetMapper assetMapper;

	public AssetResponse createAsset(AssetRequest assetRequest) {
		Asset asset = assetMapper.toEntity(assetRequest);
		assetRepo.save(asset);
		return assetMapper.toResponse(asset);
	}

	public List<AssetResponse> listAllAssets() {
		return assetMapper.toResponseDto(assetRepo.findByIsDeletedFalse());
	}

	public AssetResponse getAssetById(Long id) throws AssetNotFoundException {
		Optional<Asset> assetOptional = assetRepo.findById(id);
		if (!assetOptional.isPresent()) {
			throw new AssetNotFoundException("Asset not found with id: " + id);
		}
		Asset asset = assetOptional.get();
		return assetMapper.toResponse(asset);
	}

//
//
	public AssetResponse updateAsset(Long id, AssetRequest assetRequest) throws AssetNotFoundException {
		Optional<Asset> optionalAsset = assetRepo.findById(id);
		if (optionalAsset.isPresent()) {
			Asset existingAsset = optionalAsset.get();
			// Update only the fields that are allowed to be updated
			if (assetRequest.getName() != null) {
				existingAsset.setName(assetRequest.getName());
			}
			if (assetRequest.getCollectedDate() != null) {
				existingAsset.setCollectedDate(assetRequest.getCollectedDate());
			}
			if (assetRequest.getReturnDate() != null) {
				existingAsset.setReturnDate(assetRequest.getReturnDate());
			}
			if (assetRequest.getApproval() != null) {
				existingAsset.setApproval(assetRequest.getApproval());
			}

			Asset updatedAsset = assetRepo.save(existingAsset);
			return assetMapper.toResponse(updatedAsset);
		} else {
			throw new AssetNotFoundException("Asset not found with id: " + id);
		}
	}

	public void deleteAsset(Long id) throws AssetNotFoundException {
		Optional<Asset> optionalAsset = assetRepo.findById(id);
		if (optionalAsset.isPresent()) {
			Asset asset = optionalAsset.get();
			asset.setIsDeleted(true); // Set the isDeleted flag to true
			assetRepo.save(asset);
		} else {
			throw new AssetNotFoundException("Asset not found with id: " + id);
		}
	}

}
