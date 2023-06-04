package fit.hutech.nguyenxuanduc;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phongban")
public class PhongBan {
    @Id
    private  String id;
    @Column(name="maphong")
    @NotEmpty(message = "Title must not empty")
    private String maphong;
    @Column
    private  String tenphong;
    @OneToMany(mappedBy = "phongban",cascade = CascadeType.ALL)
    private List<NhanVien> nhanvien;

}
