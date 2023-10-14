import model.Pessoa;

public class App {
    public static void main(String[] args){
        Pessoa nova = new Pessoa();
        nova.setId(4);
        nova.setNome("Ricardo");
        nova.exibe();
    }
}
 