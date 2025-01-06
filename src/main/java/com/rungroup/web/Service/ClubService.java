package com.rungroup.web.Service;
import java.util.List;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);
    ClubDto findClubById(Long clubId);
    void updateClub(ClubDto club);
    void delete(Long clubId);

}
