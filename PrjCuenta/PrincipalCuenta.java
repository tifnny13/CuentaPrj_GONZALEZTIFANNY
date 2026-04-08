import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrincipalCuenta{
  private int cantidadCuentas = 0;
  private Cuenta [] cuentas = new Cuenta[10];
  private int posicionCuentaActual = -1; //Coloque el -1, porque al inicio no esta seleccionado en ninguna cuenta.
  private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
  public static void main(String[] args) throws java.io.IOException{
    PrincipalCuenta c = new PrincipalCuenta();
    int opcion;
    
    do {
      c.mostrarMenu();
      opcion = Integer.parseInt(c.in.readLine());
      c.ejecutarAccion(opcion);
    } while (opcion != 10);
  }
  
  public void crearCuenta (String nombre, double saldo){
    if (cantidadCuentas < cuentas.length) {
      cuentas[cantidadCuentas] = new Cuenta (nombre, saldo);
      cantidadCuentas ++;
    }
  }
  
  public void crearCuenta (double saldo){
    if (cantidadCuentas < cuentas.length) {
      cuentas[cantidadCuentas] = new Cuenta (saldo);
      cantidadCuentas ++;
    }
  }
  
  public void crearNuevaCuenta() throws java.io.IOException {
    int opcion;
    String nombre;
    double saldo;
    
    System.out.println("1. Crear cuenta con nombre cuenta habiente y saldo");
    System.out.println("2. Crear cuenta solo con el saldo");
    opcion = Integer.parseInt(in.readLine());
    System.out.println();
    if (opcion == 1){
      System.out.print("Ingrese el nombre del cuenta habiente: ");
      nombre = in.readLine();
      System.out.print("Ingrese el saldo: ");
      saldo = Double.parseDouble(in.readLine());
      crearCuenta(nombre, saldo);
      System.out.println("Cuenta creada correctamente");
    }
    else
    {
    if (opcion == 2){
      System.out.print("Ingrese el saldo: ");
      saldo = Double.parseDouble(in.readLine());
      crearCuenta(saldo);
      System.out.println("Cuenta creada exitosamente");
    }
    else
    {
      System.out.println("Opción no válida");
    }
    }
  }

  public void mostrarMenu (){
    System.out.println("1. Crear cuenta");
    System.out.println("2. Listar cuentas");
    System.out.println("3. Seleccionar cuenta actual");
    System.out.println("4. Depositar");
    System.out.println("5. Retirar");
    System.out.println("6. Cantidad de cuentas creadas");
    System.out.println("7. Asignar nombre del cuenta habiente");
    System.out.println("8. Consultar saldo");
    System.out.println("9. Consultar estado de la cuenta");
    System.out.println("10. Salir");
  }
  
  public void listarCuentas(){
    if (cantidadCuentas == 0) {
      System.out.println("No hay cuentas creadas");
      return;
    }
    
    for (int i =0; i < cantidadCuentas; i++) {
      System.out.println((i+1) + "-" + "Codigo: " + cuentas[i].getCodCuenta() + "\n" +
      "Nombre cuenta habiente: " + cuentas[i].getNombreCuentaHabiente() + "\n" +
      "Saldo: " + cuentas[i].getSaldo());
    }
  }
  
  public void seleccionarCuentaActual() throws java.io.IOException {
    if (cantidadCuentas == 0) {
      System.out.println("No hay cuentas creadas");
      return;
    }
    int posicion;
    listarCuentas();
    System.out.println("Indique la posicion de la cuenta");
    posicion = Integer.parseInt(in.readLine());
    System.out.println();
    if (posicion > 0 && posicion <= cantidadCuentas) {
      posicion -=1;
      posicionCuentaActual = posicion;
    }
    else
    {
      System.out.println("Posicion no valida");
    }
  }
  
  public void consultarSaldoCuentaActual(){
    if (posicionCuentaActual != -1){
      System.out.println("Saldo actual: " + cuentas[posicionCuentaActual].getSaldo());
    }
    else
    {
      System.out.println("Debe seleccionar una cuenta primero");
    }
  }
  
  public void consultarEstadoCuentaActual(){
    if (posicionCuentaActual != -1){
      System.out.println(cuentas[posicionCuentaActual].toString());
    }
    else
    {
      System.out.println("Debe seleccionar una cuenta primero");
    }
  }

  public void depositarACuenta() throws java.io.IOException {
    if (posicionCuentaActual != -1) {
      double montoNuevo;
      System.out.println("Ingrese el monto que desea depositar");
      montoNuevo = Double.parseDouble(in.readLine());
      System.out.println();
      cuentas[posicionCuentaActual].depositar(montoNuevo);
      System.out.println("Deposito exitoso");
    }
    else
    {
      System.out.println("No hay una cuenta seleccionada");
    }
  }
  
  public void retirarACuenta() throws java.io.IOException {
    if (posicionCuentaActual != -1) {
      double montoNuevo;
      System.out.println("Ingrese el monto que desea retirar");
      montoNuevo = Double.parseDouble(in.readLine());
      System.out.println();
      cuentas[posicionCuentaActual].retirar(montoNuevo);
      System.out.println("Retiro exitoso");
    }
    else
    {
      System.out.println("No hay una cuenta seleccionada");
    }
  }
  
  public void asignarNombreCuentaActual() throws java.io.IOException {
    if (posicionCuentaActual != -1) {
      String nombreNuevo;
      System.out.println("Ingrese el nombre de cuenta habiente: ");
      nombreNuevo = in.readLine();
      System.out.println();
      cuentas[posicionCuentaActual].setNombreCuentaHabiente(nombreNuevo);
      System.out.println("Se agregó con exito");
    }
    else 
    {
      System.out.println("No hay una cuenta seleccionada");
    }
  }
  
  public boolean ejecutarAccion (int opcion) throws java.io.IOException {
    boolean noSalir = true;
    
    switch (opcion) {
      case 1:
          crearNuevaCuenta();
          break;
          
      case 2:
          listarCuentas();
          break;
          
      case 3:
          seleccionarCuentaActual();
          break;
          
      case 4:
          depositarACuenta();
          break;
          
      case 5:
          retirarACuenta();
          break;
          
      case 6:
          System.out.println("Cantidad de cuentas creadas: " + Cuenta.getCantCuentasCreadas());
          break;
          
      case 7:
         asignarNombreCuentaActual();
         break;
      
      case 8:
        consultarSaldoCuentaActual();
        break;
       
      case 9:
        consultarEstadoCuentaActual();
        break;
      
      case 10:
        noSalir = false;
        break;
      
      default:
        System.out.println("Opción no válida");
        break;
    }
    return (noSalir);
  }

}