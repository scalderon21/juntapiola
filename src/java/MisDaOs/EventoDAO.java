package MisDaOs;
import MisClases.Amigo;
import MisClases.Evento;
import java.util.List;

public interface EventoDAO {
    boolean agregarEvento(Evento evento);
    void eliminarEvento(String nombreEvento);
    String burcarEvento(String nombreEvento);
}

