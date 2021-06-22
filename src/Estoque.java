
import java.awt.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lecox
 */
public class Estoque {

    int codProduto;
    String nome;
    double preco;
    int quantidade;
    double totalPreco;
    int totalQuantidade;
    int quantidadeItens;


    public Estoque() {

    }

    public int getCodProduto() {
        return codProduto;

    }

    public void setPreco(double p) {
        preco = p;
      
    }

    public void setNome(String string) {
        nome = string;
        
    }

    public void setCodProduto(int parseInt) {
        codProduto = parseInt;
    }

    public double getPreco() {

        return preco;
    }
 public void setTotal(double tot){
     totalPreco = tot;
     
 }
 public double getTotal(){
     return totalPreco;
 }
    public String getNome() {

        return nome;
    }

    int getQuantidade() {
        return quantidade;
    }

    void setQuantidade(int aInt) {
        quantidade = aInt;
    }

    void setTotalQuantidade(int tot) {
      totalQuantidade=  tot; 
    }
    int getTotalQuantidade(){
    return totalQuantidade;
}

    void setQuantidadeItens(int qtdItens) {
       quantidadeItens = qtdItens;
    }
    int getQuantidadeItens(){
        return quantidadeItens;
    }
}
