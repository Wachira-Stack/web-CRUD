package com.rungroup.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rungroup.web.Service.ClubService;
import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;

@Controller
public class ClubController {
    @SuppressWarnings("FieldMayBeFinal")
    private ClubService clubService;

    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }
    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club",club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") ClubDto clubDto){
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }
    /**
     * {
     * if(result.hasErrors()){
     * model.addAttribute("club", cluDto);
     * return "clubs-create";
     * }
     * clubService.saveClub(clubDto);
     * return "redirect:/clubs";
     * }
     */
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";

    }
    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable ("clubId") Long clubId, @ModelAttribute("club") ClubDto club){
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

    /**
     * {
     * if (result.hasErrors()) {
     * return "clubs-edit";
     * }
     * club.setId(clubId);
     * clubService.updateClub(club);
     * return "redirect:/clubs";
     * }
     */
    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId")Long clubId, Model model){
        ClubDto clubDto =clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId")Long clubId){
        clubService.delete(clubId);
        return "redirect:/clubs";
    }
}
