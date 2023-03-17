
import Controladores.ListaController;
import Modelos.ClientesModel;
import Modelos.ClientesModel2;
import Vistas.Medico1;
import Vistas.Medico2;
import Vistas.Menu;
import Vistas.SeleccionListas;
import Vistas.frmListas;

public class main {

    public static void main(String[] args) {
        Menu Interfaz = new Menu();
        frmListas VistaLista = new frmListas(Interfaz,true);
        SeleccionListas VistaSeleccion = new SeleccionListas(Interfaz,true);
        Medico1 MedicoGOD1 = new Medico1(Interfaz, true);
        Medico2 MedicoGOD2 = new Medico2(Interfaz, true);
        ClientesModel ModeloClientes = new ClientesModel();
        ClientesModel2 ModeloClientes2 = new ClientesModel2();
        

        ListaController ControladorLista = new ListaController(Interfaz, VistaLista, VistaSeleccion, MedicoGOD1, MedicoGOD2, 
        ModeloClientes, ModeloClientes2);
    }
    
}
