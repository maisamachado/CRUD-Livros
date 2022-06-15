package project.model;


    public class Produto {
        public  double valorProduto;
        public  Integer quantidade;

        public Produto(double valorProduto, Integer quantidade){
                this.valorProduto = valorProduto;
                this.quantidade = quantidade;
        }

        public double getValorProduto() {
            return valorProduto;
        }

        public void setValorProduto(double valorProduto) {
            this.valorProduto = valorProduto;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }
    }
