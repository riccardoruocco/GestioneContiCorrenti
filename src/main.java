import Boundary.*;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BoundaryClienteAutenticatoOnline cliente = new BoundaryClienteAutenticatoOnline();
		String codiceIBAN;
		
		/*test-case eseguiti*/
		//IBAN esistente
		//cliente.VisualizzaListaMovimenti("IT32O1234987650000001543216");
		//IBAN non esistente
		//cliente.VisualizzaListaMovimenti("IT34O5244987650000001545236");
		//Input malformato
		//cliente.VisualizzaListaMovimenti("#A@b3428");
		System.out.println("Buongiorno");
		System.out.println("Prego inserire l'IBAN del conto per visualizzare la lista movimenti");
		codiceIBAN=sc.nextLine();
		cliente.VisualizzaListaMovimenti(codiceIBAN);
	}
	

}
