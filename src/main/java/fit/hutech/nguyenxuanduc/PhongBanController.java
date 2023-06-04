package fit.hutech.nguyenxuanduc;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phongbans")
public class PhongBanController {
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllCategories(Model model){
        List<PhongBan> categories=phongBanService.getAllCategories();
        model.addAttribute("phongban",categories);
        return "phongbans/index";
    }
    @GetMapping("/add")
    public String addPhongBanForm(Model model){
        model.addAttribute("phongban",new PhongBan());
        // model.addAttribute("categories",categoryService.getAllCategories());
        return "phongbans/add";
    }
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") PhongBan phongban, BindingResult result, Model model){
        if(result.hasErrors()){
            // model.addAttribute("phongban",categoryService.getAllCategories());
            return "phongbans/add";
        }
        phongBanService.addCategory(phongban);
        return "redirect:/phongbans";
    }
//    @GetMapping("/edit/{id}")
//    public String editBookForm(@PathVariable("id") long id, Model model){
//        PhongBan editCategory=categoryService.getCategoryById(id);
//        if(editCategory != null){
//            model.addAttribute("category", editCategory);
//            //model.addAttribute("categories", categoryService.getAllCategories());
//            return "category/edit";
//        }else {
//            return "not-found";
//        }
//    }
//    @PostMapping("/edit")
//    public String editCategory(@Valid @ModelAttribute("category")Category updateCategory, BindingResult bindingResult, Model model ){
//        if (bindingResult.hasErrors()){
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "category/edit";
//        }
//        categoryService.getAllCategories().stream()
//                .filter(category -> category.getId()==updateCategory.getId())
//                .findFirst()
//                .ifPresent(category -> {categoryService.updateCategory(updateCategory);});
//        return "redirect:/books";
//    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") String id){
        phongBanService.deleteCategory(id);
        return "redirect:/categories";
    }
}
