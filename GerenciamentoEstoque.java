import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoEstoque {

    public List<Produto> produtos = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GerenciamentoEstoque gEst = new GerenciamentoEstoque();
        int opcao;

        do{
            System.out.println("Menu");
            System.out.println();
            System.out.println("1 -  Cadastrar Produto");
            System.out.println("2 -  Entrada estoque");
            System.out.println("3 -  Saida estoque");
            System.out.println("4 -  Listar estoque");
            System.out.println("5 -  Valor patrimonio liquido");
            System.out.println("9 -  Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(gEst.sc.nextLine());
            System.out.println();

            switch (opcao){
                case 1:
                    gEst.cadastrarProduto();
                    break;
                case 2:
                    gEst.controlaEntrada();
                    break;
                case 3:
                    gEst.controleSaida();
                    break;
                case 4:
                    gEst.execListaProduto();
                    break;
                case 5:
                    gEst.execPatrimonioLiq();
                    break;
                case 9:
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }while (opcao != 9);

    }

    public void cadastrarProduto(){
        Produto produto = new Produto();
        System.out.print("Digite o código: ");
        produto.setCodigo(Long.parseLong(sc.nextLine()));
        System.out.println();
        System.out.print("Descreva o produto: ");
        produto.setDescricao(sc.nextLine());
        System.out.println();
        System.out.print("Insira o preço de custo: ");
        produto.setPrecoCusto(Double.parseDouble(sc.nextLine()));
        System.out.println();

        System.out.print("Insira % do produto a ser calculado em cima do preco \n" +
                "Por exemplo 10% \n" +
                "Insira o valor: ");
        produto.setPreco(((Double.parseDouble(sc.nextLine())/100)+1) * produto.getPrecoCusto());
        System.out.println();

        produtos.add(produto);
    }
    public void controlaEntrada(){
        long cod;

        System.out.print("Digite o codigo do produto: ");
        cod = Long.parseLong(sc.nextLine());
        System.out.println();

        for(Produto produto : produtos){
            if (produto.getCodigo() == cod){
                int quantidade;

                System.out.print("Digite a quantidade de entrada: ");
                quantidade = Integer.parseInt(sc.nextLine());
                System.out.println();

                    produto.controlaEntrada(quantidade);

            }

        }
    }

    public void controleSaida(){
        long cod;

        System.out.print("Digite o código do produto: ");
        cod = Long.parseLong(sc.nextLine());
        System.out.println();

        for (Produto produto : produtos){
            if (produto.getCodigo() == cod){
                int quantidade;

                System.out.print("Digite a quantidade de saida: ");
                quantidade = Integer.parseInt(sc.nextLine());
                System.out.println();

                produto.controlaSaida(quantidade);
            }
        }
    }

    public void execListaProduto(){
        for (Produto produto : produtos){
            System.out.print(produto.toString());
            System.out.println();
        }
    }

    public void execPatrimonioLiq(){
        double valorPatrimonio = 0;

        for (Produto produto : produtos){
            double total;

            total = produto.getQuantidade() * produto.getPrecoCusto();

            valorPatrimonio += total;
        }

        System.out.println("Patrimonio total e de $" + valorPatrimonio);
        System.out.println();
    }
}