public class Produto {

    //Atributos
    private long codigo;
    private String descricao;
    private int quantidade;
    private boolean temEstoque;
    private double preco;
    private double precoCusto;

    //Gets e Sets
    public long getCodigo() {
        return codigo;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isTemEstoque() {
        return temEstoque;
    }

    public void setTemEstoque(boolean temEstoque) {
        this.temEstoque = temEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //Métodos
    public void controlaEntrada(int quantidade){
        if(quantidade > 0){
            this.quantidade += quantidade;
            System.out.println("Entrada com sucessso!");
            temEstoque = true;
        }else{
            System.out.println("Quatidade tem que ser maior que zero!");
        }
        return;
    }

    public void controlaSaida(int quantidade){
            if (quantidade <= this.quantidade){
                this.quantidade -= quantidade;
            }else {
                System.out.println("Não há quantidade suficiente em estoque!");
            }

            if (this.quantidade == 0){
                temEstoque = false;
            }else {
                temEstoque = true;
            }
    }

    @Override
    public String toString() {
        return "Produto\n" + "\n" +
                "Codigo produto: " + codigo + "\n" +
                "Descricao produto: " + descricao + "\n" +
                "Quantidade produto: " + quantidade + "\n" +
                "Preco prouto: $" + preco + "\n" +
                "Preco de custo: $" + precoCusto + "\n" +
                (temEstoque ? "Possui em estoque" : "Não tem estoque") + "\n";
    }
}
