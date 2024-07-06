package fa.training.controller;

import fa.training.entity.Content;
import fa.training.entity.User;
import fa.training.repository.ContentRepository;
import fa.training.service.ContentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/viewC")
@RequiredArgsConstructor
@SessionAttributes("userLogin")
public class ViewC {

    private final ContentRepository contentRepository;
    private final ContentService contentService;

    @ModelAttribute("userLogin")
    public User getUserLogin() {
        return new User();
    }

    @GetMapping(params = {"page"})
    @Transactional
    public String getContentPage(@RequestParam(defaultValue = "0") int page,
                                 Model model,@ModelAttribute("userLogin")User userLogin) {
        int sizePage = 3;
        Pageable pageable = PageRequest.of(page, sizePage);
        Page<Content> contentPage = contentRepository.findAll(pageable);
        model.addAttribute("contents", contentPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", contentPage.getTotalPages());
        model.addAttribute("userLogin",userLogin);
        return "ViewContent";
    }

    @GetMapping
    @Transactional
    public String showContentPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "3") int size,
                                  Model model, @ModelAttribute("userLogin") User userLogin) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Content> contents = contentService.findAll(pageable);
        model.addAttribute("contents", contents.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", contents.getTotalPages());
        return "ViewContent";
    }
}
