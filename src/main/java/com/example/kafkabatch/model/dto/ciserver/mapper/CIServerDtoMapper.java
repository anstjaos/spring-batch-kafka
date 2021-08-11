package com.example.kafkabatch.model.dto.ciserver.mapper;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.entity.CIServerEntity;
import org.springframework.util.StringUtils;

public class CIServerDtoMapper {

    public static CIServerDto convert(CIServerEntity ciServerEntity) {
        Boolean isIpExist = ciServerEntity.getIp() != null && StringUtils.hasText(ciServerEntity.getIp().trim());
        Boolean isVipExist = ciServerEntity.getVip() != null && StringUtils.hasText(ciServerEntity.getVip().trim());

        return CIServerDto.builder()
                .hostname(ciServerEntity.getHostname())
                .ip(ciServerEntity.getIp())
                .vip(ciServerEntity.getVip())
                .isPublicIp(isIpExist && ciServerEntity.getIsPublicIp())
                .isPublicVip(isVipExist && ciServerEntity.getIsPublicVip())
                .isPrivateIp(isIpExist && !ciServerEntity.getIsPublicIp())
                .isPrivateVip(isVipExist && !ciServerEntity.getIsPublicVip())
                .build();
    }
}
