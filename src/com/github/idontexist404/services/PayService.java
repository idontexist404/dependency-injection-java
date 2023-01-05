package com.github.idontexist404.services;

public class PayService {
    private DeductionService deductionService = new MGDeductionService();
    // alto acoplamento entre os dois serviços     ->      ^^^
    // caso seja necessário trocar o serviço de MG para outro estado, como SP, isso vai ter que ser
    // feito de forma manual, mudando a classe instanciada e recompilando.
    // eu não quero recompilar a classe PayService só para mudar uma dependencia dele. o que
    // fazer? injetar essa dependencia c/ inversão de controle a partir de um construtor.

    public double tax(double amount) {
        amount = amount - deductionService.deduction(amount);
        return amount * 0.2;
    }
}
