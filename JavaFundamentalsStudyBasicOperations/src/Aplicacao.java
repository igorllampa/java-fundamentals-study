import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import static java.lang.System.out;

/**
 * 
 * @author Igor Luiz Lampa
 *
 */
public class Aplicacao {

	private enum Sexo{
		MASCULINO,
		FEMININO
	}
	
	public static void main(String[] args) {
		
		out.print("teste");
		System.out.println("Esse é o meu primeiro projeto");
		
		double d = 1100.25;
		
		NumberFormat nf1 = NumberFormat.getNumberInstance();
		String s1 = nf1.format(d);
		System.out.println("Número exibido no padrão do computador atual:"+s1);
		
		NumberFormat nf2 = NumberFormat.getNumberInstance(new Locale("en", "US"));
		String s2 = nf2.format(d);
		System.out.println("Número exibido no padrão Inglês - United States:"+s2);
		
		NumberFormat nf3 = NumberFormat.getCurrencyInstance();
		String s3 = nf3.format(d);
		System.out.println("Número exibido no padrão moeda do computador atual:"+s3);
		
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		String s4 = nf4.format(d);
		System.out.println("Número exibido no padrão moeda Inglês - United States:"+s4);
		
		DecimalFormat df1 = new DecimalFormat("00,000.000");
		df1.setGroupingUsed(true);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		df1.setDecimalFormatSymbols(dfs);
		String s5 = df1.format(d);
		System.out.println(s5);
		
		Date date = new Date();
		long mili = date.getTime();
		System.out.println("Hora em milisegundos:"+mili);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 25);
		Date d1 = cal.getTime();
		System.out.println("Data: "+d1);
		
		Calendar cal2 = Calendar.getInstance();
		cal.set(2020, 0, 25, 7, 30, 10);
		Date d2 = cal.getTime();
		System.out.println("Data:"+d2);
		
		//Subtrair um ano
		cal.add(Calendar.YEAR, -1);
		d2 = cal.getTime();
		System.out.println("Data: "+d2);
		
		//Incrementar um mês
		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.DAY_OF_WEEK, 1);
		d2 = cal.getTime();
		System.out.println("Data: "+d2);
		
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT);
		String f1 = df2.format(d2);
		System.out.println("Data no padrão SHORT:"+f1);
		
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String f3 = df3.format(d2);
		System.out.println("Data no padrão MEDIUM :"+f3);
		
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.LONG);
		String f4 = df4.format(d2);
		System.out.println("Data no padrão LONG :"+f4);
		
		DateFormat df5 = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "US"));
		String f5 = df5.format(d2);
		System.out.println("Data no padrão LONG em inglês dos Estados Unidos: "+f5);
		
		SimpleDateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
		String f6 = df6.format(d2);
		System.out.println(f6);
		
		String sd1 = "2030-07-01 08:47:13";
		SimpleDateFormat df7 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date d3 = df7.parse(sd1);
			System.out.println(d3);
			
			SimpleDateFormat formatoExibicao = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			String f7 = formatoExibicao.format(d3);
			System.out.println("Data formatada: "+f7);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String dataNascimento = "25/01/1993 07:30";
		LocalDateTime ldt1 = LocalDateTime.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		LocalDateTime ldt2 = LocalDateTime.now();
		
		Duration drt = Duration.between(ldt1, ldt2);
		
		System.out.println("Horas:"+ drt.toHours());
		System.out.println("Dias:"+drt.toDays());
		
		Period p = Period.between(ldt1.toLocalDate(), ldt2.toLocalDate());
		System.out.println("Meses: "+ p.toTotalMonths());
		

		
		System.out.println("Semanas:"+ChronoUnit.WEEKS.between(ldt1, ldt2));
		System.out.println("Anos:"+ChronoUnit.YEARS.between(ldt1, ldt2));
		
		System.out.println("Número randômico:" + gerarInt(50, 100));
		
		StatusDoPedido status = StatusDoPedido.PEDIDO_CONCLUIDO;
		System.out.println("Status selecionado: " + status);
		System.out.println("Código do Status selecionado: " + status.getCodigo());
		
		StatusDoPedido statusNovo = StatusDoPedido.valueOf("PEDIDO_PENDENTE");
		System.out.println("Novo status selecionado: "+statusNovo);
		System.out.println("Código do novo status selecionado: "+statusNovo.getCodigo());
		
		Sexo sexo = Sexo.MASCULINO;
		System.out.println("Sexo selecionado: "+sexo);
		
		Integer numeroInteger = Integer.valueOf(18);
		Double numeroDouble = Double.valueOf("18.3");
		
		
		
	}
	
	static int gerarInt(int inicio, int fim) {
		int intervalo = fim - inicio;
		int n = (int) (Math.random() * intervalo) + inicio;
		return n;		
			
	}
}
