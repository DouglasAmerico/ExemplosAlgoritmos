package ContaBanco;

public class ClasseContaBanco {
    public Double numeroConta;
    public String nomeCliente;
    public Double saldoConta;

    public ClasseContaBanco(){
        this.saldoConta= 1000.00;
    }

    public Boolean cadastroCliente(Double conta, String nome){
        this.numeroConta= conta;
        this.nomeCliente= nome;
        return true;
    }

    public Boolean inserirSaldo(Double valor){
        this.saldoConta+= valor;
        return true;
    }

    public Boolean sacarSaldo(Double valor){
        if((this.saldoConta - valor) >= 0){
            this.saldoConta-= valor;
            return true;
        }else {
            return false;
        }
    }
}
