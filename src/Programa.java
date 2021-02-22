import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Programa {

    private Integer opcionDelMenu;
    private String entradaDelMenu;
    private List<Empleado> listaEmpleados = new ArrayList<Empleado>();

    public Programa() {
    }

    public Integer getOpcionDelMenu() {
        return opcionDelMenu;
    }

    public void setOpcionDelMenu(Integer opcionDelMenu) {
        this.opcionDelMenu = opcionDelMenu;
    }

    public String getEntradaDelMenu() {
        return entradaDelMenu;
    }

    public void setEntradaDelMenu(String entradaDelMenu) {
        this.entradaDelMenu = entradaDelMenu;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    protected void ejecutarPrograma(){

        System.out.println("\n");

        System.out.println("**********************************************");
        System.out.println("*******Administración de Empleados************");
        System.out.println("**********************************************");

        System.out.println("1 - Agregar Empleados");
        System.out.println("2 - Eliminar Empleados");
        System.out.println("3 - Actualizar Empleados");
        System.out.println("4 - Mostrar todos los Empleados");
        System.out.println("5 - Salir");

        System.out.println("*******[ Digite el valor   ]************");

        Scanner teclado = new Scanner(System.in);
        entradaDelMenu = teclado. nextLine();

    }

    protected boolean validarEntradaTeclado(){

        boolean varVerificacion = false;


        if( entradaDelMenu.length() > 1 ) {
            System.out.println("Digite un solo Número, correspondiente al tipo de Menú");
            varVerificacion = false;
        }else if (!entradaDelMenu.matches("[0-9]+")) {
            System.out.println("La entrada corresponde a un Digito Númerico 1 - 2 - 3 - 4 - 5");
            varVerificacion = false;
        }else if (Integer.parseInt(entradaDelMenu) > 5) {
            System.out.println("El número digitado no corresponde a ninguna opción del Menú");
            varVerificacion = false;
        }else {
            varVerificacion = true;
        }
        return varVerificacion;
    }


    protected boolean addEmpleado( Empleado empleado) {

        boolean varConfirmacion = false;
        boolean valIngresar = false;
        Empleado clonEmpleado = empleado;

        Iterator<Empleado> iter2 = listaEmpleados.iterator();
        if (!listaEmpleados.isEmpty()){
            while (iter2.hasNext()) {
                if (empleado.getId().toString().equals(iter2.next().getId().toString())) {
                    System.out.println("El Id Empleado ya existe. NO SE PUEDE AGREGAR EL REGISTRO");
                    valIngresar = true;
                }
            }
        }else{
            valIngresar = false;
        }

        if (!valIngresar) {
            listaEmpleados.add(clonEmpleado);
            varConfirmacion = true;
        } else {
            varConfirmacion = false;
        }

        return varConfirmacion;
    }

    protected void imprimirTodosLosEmpleados(){

        if (!listaEmpleados.isEmpty()) {
            Iterator<Empleado> iter = listaEmpleados.iterator();
            for (int i = 0; i < listaEmpleados.size(); i++) {
                System.out.println("\n");
                System.out.print("Id = " + listaEmpleados.get(i).getId().toString() + "  ");
                System.out.print("Nombre = " + listaEmpleados.get(i).getNombre().toString() + "  ");
                System.out.print("Apellido = " + listaEmpleados.get(i).getApellido().toString() + "  ");
                System.out.print("Salario = " + listaEmpleados.get(i).getSalario().toString() + "  ");
            }
        }else{
            System.out.println("La lista esta vacia. No hay Empleados Almancenados.");

        }
    }

    protected void removeEmpleado( Integer idEmpleado) {

        boolean varConfirmacion = false;

        Iterator<Empleado> iter2 = listaEmpleados.iterator();
        if (!listaEmpleados.isEmpty()){
            for (int i = 0; i < listaEmpleados.size(); i++) {
                if (idEmpleado.toString().equals(listaEmpleados.get(i).getId().toString())) {
                    listaEmpleados.remove(i);
                    System.out.println("Se Eliminó el empleado con el Id " + idEmpleado);
                    varConfirmacion = true;
                    break;
                }
            }
        }
    }

    protected boolean updateEmpleado( Integer idEmpleado ) {

        boolean varConfirmacion = false;
        String txtId, txtNombre, txtApellido, txtSalario;

        Iterator<Empleado> iter2 = listaEmpleados.iterator();
        if (!listaEmpleados.isEmpty()){
            while (iter2.hasNext()) {
                if (idEmpleado.toString().equals(iter2.next().getId().toString())) {
                    System.out.println("Ingrese los valores del Empleado en el siguiente Orden:");
                    System.out.println("1 - Id");
                    System.out.println("2 - Nombre");
                    System.out.println("3 - Apellido");
                    System.out.println("4 - Salario");
                    Scanner teclado10 = new Scanner(System.in);
                    txtId = teclado10. nextLine();
                    Scanner teclado11 = new Scanner(System.in);
                    txtNombre = teclado11. nextLine();
                    Scanner teclado12 = new Scanner(System.in);
                    txtApellido = teclado12. nextLine();
                    Scanner teclado13 = new Scanner(System.in);
                    txtSalario = teclado13. nextLine();

                    Empleado clonEmpleado = new Empleado(  Integer.parseInt(txtId), txtNombre, txtApellido, Integer.parseInt(txtSalario) );

                    listaEmpleados.set(idEmpleado, clonEmpleado );
                    System.out.println("Se actualizó el empleado con el Id " + idEmpleado);
                    varConfirmacion = true;
                }
            }
        }

        return varConfirmacion;
    }


}
