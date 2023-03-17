package Controladores;

import Modelos.Clientes;
import Modelos.ClientesModel;
import Modelos.ClientesModel2;
import Vistas.Medico1;
import Vistas.Medico2;
import Vistas.Menu;
import Vistas.SeleccionListas;
import Vistas.frmListas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class ListaController implements ActionListener{
Menu Interfaz;
frmListas VistaLista;
SeleccionListas VistaSeleccion;
Medico1 MedicoGOD1;
Medico2 MedicoGOD2;
ClientesModel ModeloClientes;
ClientesModel2 ModeloClientes2;

    public ListaController(Menu Interfaz, frmListas VistaLista,SeleccionListas VistaSeleccion, Medico1 MedicoGOD1, Medico2 MedicoGOD2,
            ClientesModel ModeloClientes, ClientesModel2 ModeloClientes2) {
        
        this.Interfaz = Interfaz;
        this.VistaLista = VistaLista;
        this.VistaSeleccion = VistaSeleccion;
        this.MedicoGOD1 = MedicoGOD1;
        this.MedicoGOD2 = MedicoGOD2;
        this.ModeloClientes = ModeloClientes;
        this.ModeloClientes2 = ModeloClientes2;
        
        //MENU
        this.Interfaz.btnIngresar.addActionListener(this);
        this.Interfaz.btnVer.addActionListener(this);
        
        //SELECCIÓN
        this.VistaSeleccion.btnMedico1.addActionListener(this);
        this.VistaSeleccion.btnMedico2.addActionListener(this);
        
        //PONER A LA ESCUCHA LOS BOTONES
        this.MedicoGOD1.btnAtenderCliente1.addActionListener(this);
        this.MedicoGOD1.btnAtenderTodos1.addActionListener(this);
        
        this.MedicoGOD2.btnAtenderCliente2.addActionListener(this);
        this.MedicoGOD2.btnAtenderTodos2.addActionListener(this);
        
        
        //INGRESAR 
        this.VistaLista.btnIngresarMedico1.addActionListener(this);
        this.VistaLista.btnIngresarMedico2.addActionListener(this);
        //LEVANTAR LA VISTA LISTAs
        this.Interfaz.setLocationRelativeTo(null);
        this.Interfaz.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==this.Interfaz.btnIngresar)
        {
        this.VistaLista.setLocationRelativeTo(null);
        this.VistaLista.setVisible(true);  
        } 
         
        if(e.getSource()==this.Interfaz.btnVer)
        {
        this.VistaSeleccion.setLocationRelativeTo(null);
        this.VistaSeleccion.setVisible(true);  
        }
         /////
        if(e.getSource()==this.VistaSeleccion.btnMedico1)
        {
        this.MedicoGOD1.setLocationRelativeTo(null);
        this.MedicoGOD1.setVisible(true);  
        } 
          if(e.getSource()==this.VistaSeleccion.btnMedico2)
        {
        this.MedicoGOD2.setLocationRelativeTo(null);
        this.MedicoGOD2.setVisible(true);  
        }
        ///////
        if(e.getSource()==this.VistaLista.btnIngresarMedico1)
        {
            this.ModeloClientes.EncolarCliente(this.VistaLista.txtApellidos.getText(), 
                    this.VistaLista.txtNombres.getText());

            Queue<Clientes> listaLocal = this.ModeloClientes.ListarClientes();
                String Cadena = "";
                for(Clientes MiListaClientes: listaLocal)
                {
                    Cadena = Cadena + MiListaClientes.getApellidos()+" "+MiListaClientes.getNombre()+"\n";
                    this.MedicoGOD1.txtListaClientes1.setText(Cadena);
                }
        }   
        ///////
         if(e.getSource()==this.VistaLista.btnIngresarMedico2)
        {
            this.ModeloClientes2.EncolarCliente2(this.VistaLista.txtApellidos.getText(), 
                    this.VistaLista.txtNombres.getText());

            Queue<Clientes> listaLocal = this.ModeloClientes2.ListarClientes2();
                String Cadena = "";
                for(Clientes MiListaClientes: listaLocal)
                {
                    Cadena = Cadena + MiListaClientes.getApellidos()+" "+MiListaClientes.getNombre()+"\n";
                    this.MedicoGOD2.txtListaClientes2.setText(Cadena);
                }
        } 
    }
}
