
import com.neoinfo.modulos.auth.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author carlosmo
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
