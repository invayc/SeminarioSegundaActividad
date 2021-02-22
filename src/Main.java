import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main( String[] args ) {

        boolean verificacion = true;
        Programa ejecucionPrograma = new Programa();

        do {
            //List<Empleado> listaEmpleados = new ArrayList<Empleado>();
            ejecucionPrograma.ejecutarPrograma();
            if (ejecucionPrograma.validarEntradaTeclado()) {
                ejecucionPrograma.setOpcionDelMenu(Integer.parseInt(ejecucionPrograma.getEntradaDelMenu()));

                switch (ejecucionPrograma.getOpcionDelMenu()) {

                    case 1:
                        String txtId, txtNombre, txtApellido, txtSalario;
                        System.out.println("Ingreso al Menú <<< Agregar Empleado Nuevo >> ");
                        System.out.println("Ingrese los valores del Empleado en el siguiente Orden:");
                        System.out.println("1 - Id");
                        System.out.println("2 - Nombre");
                        System.out.println("3 - Apellido");
                        System.out.println("4 - Salario");
                        Empleado nuevoEmpleado = new Empleado();
                        Scanner teclado1 = new Scanner(System.in);
                        txtId = teclado1. nextLine();
                        Scanner teclado2 = new Scanner(System.in);
                        txtNombre = teclado2. nextLine();
                        Scanner teclado3 = new Scanner(System.in);
                        txtApellido = teclado3. nextLine();
                        Scanner teclado4 = new Scanner(System.in);
                        txtSalario = teclado4. nextLine();

                        nuevoEmpleado.setId( Integer.parseInt( txtId ));
                        nuevoEmpleado.setNombre(txtNombre);
                        nuevoEmpleado.setApellido(txtApellido);
                        nuevoEmpleado.setSalario( Integer.parseInt( txtSalario ) );
                        ejecucionPrograma.addEmpleado(nuevoEmpleado);
                        break;

                    case 2:
                        System.out.println("Ingreso al Menú <<< Eliminar Empleado >> Digite el Id a Eliminar. ");
                        Scanner teclado6 = new Scanner(System.in);
                        txtId = teclado6. nextLine();
                        if (!txtId.matches("[0-9]+")){
                            System.out.println("Debe ser un Digito Númerico.!");
                        }else {
                            ejecucionPrograma.removeEmpleado( Integer.parseInt(txtId) );
                        }
                        break;

                    case 3:
                        System.out.println("Ingreso al Menú <<< Actualizar Empleado >>Digite el Id a Actualizar. ");
                        Scanner teclado7 = new Scanner(System.in);
                        txtId = teclado7. nextLine();
                        if (!txtId.matches("[0-9]+")){
                            System.out.println("Debe ser un Digito Númerico.!");
                        }else {
                            ejecucionPrograma.updateEmpleado( Integer.parseInt(txtId) );
                        }
                        break;

                    case 4:
                        System.out.println("Ingreso al Menú <<< Mostrar todos los Empleados >> ");
                        ejecucionPrograma.imprimirTodosLosEmpleados();
                        break;

                    case 5:
                        System.out.println("Fin del Programa ");
                        verificacion = false;
                        System.exit(0);
                        break;

                }
            }
        } while ( verificacion );

    }
}

