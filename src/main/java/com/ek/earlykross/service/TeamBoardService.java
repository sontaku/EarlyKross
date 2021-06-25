package com.ek.earlykross.service;

import com.ek.earlykross.entity.TeamBoard;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.TeamBoardDTO;

public interface TeamBoardService {

    Long register(TeamBoardDTO dto);

    PageResultDTO<TeamBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    TeamBoardDTO get(Long mId);

    void modify(TeamBoardDTO dto);

    void removeWithReplies(Long mId);


    default TeamBoard dtoToEntity(TeamBoardDTO dto) {
        TeamBoard entity = TeamBoard.builder()
            .nId(dto.getNId())
            .title(dto.getTitle())
            .authorId(dto.getAuthorId())
            .update(dto.getUpdate())
            .count(dto.getCount())
            .replyCount(dto.getReplyCount())
            .build();
        return entity;
    }

    default TeamBoardDTO dtoToEntity(TeamBoard entity) {
        TeamBoardDTO dto = TeamBoardDTO.builder()
            .nId(entity.getNId())
            .title(entity.getTitle())
            .authorId(entity.getAuthorId())
            .update(entity.getUpdate())
            .count(entity.getCount())
            .replyCount(entity.getReplyCount())
            .build();
        return dto;
    }
}
