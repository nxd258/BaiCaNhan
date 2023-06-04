package fit.hutech.nguyenxuanduc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongbanRepository;

    public List<PhongBan> getAllCategories(){
        return phongbanRepository.findAll();
    }
    public PhongBan getPhongBanById(String id){
        Optional<PhongBan> optionalPhongBan=phongbanRepository.findById(id);
        if(optionalPhongBan.isPresent()){
            return optionalPhongBan.get();
        }else{
            throw new RuntimeException("Category not found");
        }
    }
    public void addCategory(PhongBan category){
        phongbanRepository.save(category);
    }
    public void updateCategory(PhongBan category){
        phongbanRepository.save(category);
    }
    /*  public void deleteCategory(){
          categoryRepository.delete;
      }*/
    public PhongBan saveCategory(PhongBan category){
        return phongbanRepository.save(category);
    }
    public void deleteCategory(String id){
        phongbanRepository.deleteById(id);
    }
}
