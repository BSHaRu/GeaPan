package co.kr.gaepan.controller.pet;

import co.kr.gaepan.dto.pet.*;
import co.kr.gaepan.service.pet.PetBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequestMapping("/pet/*")
@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetBoardService petBoardService;

    @RequestMapping("/pet/petlist")
    public String main(PageRequestDTO pageRequestDTO , Model model) {

        PageResponseDTO pageResponseDTO = petBoardService.PetAll(pageRequestDTO,1);

        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "pet/petlist";

    }

    @RequestMapping("/pet/petdoglist")
    public String petdoglist(PageRequestDTO pageRequestDTO ,Model model) {
        PageResponseDTO pageResponseDTO = petBoardService.PetDog(pageRequestDTO, 1,1);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "pet/petdoglist";
    }

    @RequestMapping("/pet/petcatlist")
    public String petcatlist(PageRequestDTO pageRequestDTO ,Model model) {
        PageResponseDTO pageResponseDTO = petBoardService.PetCat(pageRequestDTO,2,1);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "pet/petcatlist";
    }

    @RequestMapping("/pet/petetclist")
    public String petetclist(PageRequestDTO pageRequestDTO ,Model model) {
        PageResponseDTO pageResponseDTO = petBoardService.PetEtc(pageRequestDTO,3,1);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "pet/petetclist";
    }




    @RequestMapping("/pet/details")
    public String blog_details(String no, Model model) {

        PetRegisterDTO petview = petBoardService.pet(no);

        model.addAttribute("petview", petview);

        return "pet/details";
    }

    @RequestMapping("/pet/register")
    public String register(Model model) {

        List<PetCateDTO> petcate = petBoardService.petcate();
        model.addAttribute("petcate", petcate);

        return "pet/register";

    }

    @PostMapping("/pet/register")
    public String insert(PetRegisterDTO dto) {

        petBoardService.insertPet(dto);

        return "redirect:petlist";
    }

    @GetMapping("/pet/searchpetlist")
    public String searchPets(@RequestParam String searchType,
                             @RequestParam String key,
                             Model model) {
        log.info("searchType : " + searchType);
        log.info("key : " + key);
        List<PetRegisterDTO> petList = petBoardService.searchPets(searchType, key);
        model.addAttribute("petList", petList);

        log.info("petList : " + petList);

        return "pet/searchpetlist";
    }


}
