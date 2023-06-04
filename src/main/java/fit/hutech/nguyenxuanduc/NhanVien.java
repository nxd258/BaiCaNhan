package fit.hutech.nguyenxuanduc;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column
    private String ma;
    @Column
    private  String ten;
    @Column
    private  String noi;
    @Column
    private String phai;
    @Column
    private int luong;
    @ManyToOne
    private  PhongBan phongban;
}


