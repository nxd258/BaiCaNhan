package fit.hutech.nguyenxuanduc;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/nhanviens")
@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public  String index(Model model){
        model.addAttribute("nhanviens",nhanVienService.GetAll());
        return "nhanviens/index";
    }
    @GetMapping("/create")

    public String create(Model model) {
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("phongbans",phongBanService.getAllCategories());
        return "nhanviens/create";

    }
    @PostMapping("/create")
    public  String create(@Valid NhanVien newNhanVien,/*@RequestParam MultipartFile imageProduct,*/ BindingResult result, Model model){
        if(result.hasErrors())
        {
           // model.addAttribute("nhanvien", newNhanVien);
            model.addAttribute("phongbans",phongBanService.getAllCategories());
            return "nhanviens/create";
        }
        nhanVienService.add(newNhanVien);
        return"redirect:/nhanviens";
    }

    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable("id") int id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienById(id);
        if(editNhanVien != null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("phongbans",phongBanService.getAllCategories());
            return "nhanviens/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("nhanvien")NhanVien updateProduct, BindingResult bindingResult, Model model ){

        nhanVienService.updateNhanVien(updateProduct);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value="id") int id){
        nhanVienService.deleteProduct(id);
        return "redirect:/nhanviens";
    }
}
