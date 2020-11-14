package br.edu.usj.lpii.ads.calculadorahistorico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Calculadora {
    

    @Autowired
    HistoricoRepository historicoRepository;

    @PostMapping(value="/somar")
    public ModelAndView postSomar(@RequestParam String a, @RequestParam String b) {
        

        Double aDouble = Double.valueOf(a);
        Double bDouble = Double.valueOf(b);
        Double op1 = Double.valueOf(a);
        Double op2 = Double.valueOf(b);

        Double resultado = aDouble + bDouble;
        String operacao = a + " + " + b + " = " + resultado;

        Double resultado2 = op1 - op2;
        String operacao2 = a + " - " + b + " = " + resultado2;

        
        Historico item = new Historico();
        item.setOperacao(operacao);
        historicoRepository.save(item);

        Historico item2 = new Historico();
        item2.setOperacao(operacao2);
        historicoRepository.save(item2);

        List<Historico> historico = historicoRepository.findAll();


        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", operacao);
        modelAndView.addObject("historico", historico);
        modelAndView.addObject("resultado2", operacao2);
       

        return modelAndView;
    }
    
}