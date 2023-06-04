package fit.hutech.nguyenxuanduc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository repo;

    public List<NhanVien> GetAll(){

        return repo.findAll();
    }
    public void  add(NhanVien newProduct){
        repo.save(newProduct);
    }
    public NhanVien getNhanVienById(int id){
        Optional<NhanVien> optional=repo.findById(id);
        return optional.orElse(null);
    }

    public void updateNhanVien(NhanVien nhanvien){
        repo.save(nhanvien);
    }
    public void deleteProduct(int id){
        repo.deleteById(id);
    }

}
