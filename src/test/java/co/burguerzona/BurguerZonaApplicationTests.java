package co.burguerzona;

import co.burguerzona.repository.PlatoRepository;
import co.burguerzona.repository.UsuarioRepository;
import co.burguerzona.repository.PedidoRepository;
import co.burguerzona.repository.FacturaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Pruebas unitarias de la aplicacion BurguerZona
 * Evidencia GA8-220501096-AA1-EV01
 */
@SpringBootTest
public class BurguerZonaApplicationTests {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    /** Verifica que el contexto de la aplicacion carga correctamente */
    @Test
    void contextLoads() {
        assertThat(platoRepository).isNotNull();
        assertThat(usuarioRepository).isNotNull();
        assertThat(pedidoRepository).isNotNull();
        assertThat(facturaRepository).isNotNull();
    }

    /** Verifica que se pueden listar los platos */
    @Test
    void listarPlatos() {
        assertThat(platoRepository.findAll()).isNotNull();
    }

    /** Verifica que se pueden listar los usuarios */
    @Test
    void listarUsuarios() {
        assertThat(usuarioRepository.findAll()).isNotNull();
    }

    /** Verifica que se pueden listar los pedidos */
    @Test
    void listarPedidos() {
        assertThat(pedidoRepository.findAll()).isNotNull();
    }

    /** Verifica que se pueden listar las facturas */
    @Test
    void listarFacturas() {
        assertThat(facturaRepository.findAll()).isNotNull();
    }
}