import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Cuenta{
  private String codCuenta = "cta-";
  private double saldo;
  private String nombreCuentaHabiente;
  private String fechaCreacion;
  private int cantDepositosRealizados;
  private int cantRetirosExitososRealizados;
  private static int cantCuentasCreadas = 0;
  
  public Cuenta (String nombreCuentaHabiente, double pSaldo){
    this(pSaldo);
    this.nombreCuentaHabiente = nombreCuentaHabiente;
  }
  
  public Cuenta (double pSaldo){
    saldo = pSaldo; 
    cantCuentasCreadas++;
    codCuenta = "cta-" + cantCuentasCreadas;
    
    LocalDateTime fecha = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    fechaCreacion = fecha.format(formato);
  }
  
  public void setNombreCuentaHabiente (String pNombreCuentaHabiente){
    nombreCuentaHabiente = pNombreCuentaHabiente;  
  }
  
  public String getCodCuenta (){
    return (codCuenta);
  }
  
  public double getSaldo (){
    return (saldo);
  } 
  
  public double depositar (double monto){
    if (monto > 0){
      saldo += monto;  
      cantDepositosRealizados++;
      return (saldo);
    }
    else
    {
      System.out.println("Valor invalido");
      return (saldo);
    }
  }
  
  public double retirar (double monto){
    if (monto > 0){
      if (validarRetiro(monto)){
        saldo -= monto; 
        cantRetirosExitososRealizados++;
        return (saldo);
      }
      else
      {
        System.out.println("Fondos insuficientes");
        return (saldo);
      }
    }
    else
    {
      System.out.println("Valor invalido");
      return (saldo);
    }
  }
  
  private boolean validarRetiro (double monto){
    if (saldo - monto >= 0){
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public static int getCantCuentasCreadas (){
    return(cantCuentasCreadas);
  }
  
  public String getNombreCuentaHabiente(){
    return(nombreCuentaHabiente);  
  }
  
  public String toString(){
    return ("Codigo : " + codCuenta + "\n" +
    "Su saldo es de: " + saldo + "\n" +
    "Nombre cuenta habiente: " + nombreCuentaHabiente + "\n" +
    "Fecha de creación: " + fechaCreacion + "\n" +
    "Cantidad de depositos realizados: " + cantDepositosRealizados + "\n" +
    "Cantidad de retiros exitosos realizados: " + cantRetirosExitososRealizados + "\n" +
    "Cantidad de cuentas creadas: " +  cantCuentasCreadas);
  }
}