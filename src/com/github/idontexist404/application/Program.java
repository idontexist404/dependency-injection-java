package com.github.idontexist404.application;

import com.github.idontexist404.services.PayService;
import com.github.idontexist404.services.SPDeductionService;

public class Program {
    public static void main(String[] args) {
        PayService payService = new PayService(new SPDeductionService());
        //                                                ^^^
        // a implementação agora é feita pela classe do programa principal.
        // usa-se o construtor PayService para instaciar o objeto que é
        // a dependência. dessa forma realiza-se a IoC, pois a classe
        // PayService não precisa saber internamente a dependência instanciada. 

        double tax = payService.tax(1000.0);

        System.out.println(tax);
    }
}
