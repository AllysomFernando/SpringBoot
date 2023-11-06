package br.fag.controllers;
import br.fag.model.Resultado;
import br.fag.services.Divisao;
import br.fag.services.Multiplicacao;
import br.fag.services.Somar;
import br.fag.services.Substracao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorResource {
    @GetMapping("/calculate")
    public ResponseEntity<String>  calculate(@RequestParam("first") float first, @RequestParam("second") float second, @RequestParam("operator") String operator){
        Divisao divisao = new Divisao();
        Somar somar = new Somar();
        Substracao substracao = new Substracao();
        Multiplicacao multiplicacao = new Multiplicacao();
        Resultado resultado;
        switch (operator) {
            case "+":
                resultado = new Resultado(somar.operacao(first, second));
                break;
            case "-":
                resultado = new Resultado(substracao.operacao(first,second));
                break;
            case "*":
                resultado = new Resultado(multiplicacao.operacao(first,second));
                break;
            case "/":
                resultado = divisao.operacao((int)first, (int)second);
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid operator");
        }
        if (resultado.temErro()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado.mensagemErro);
        }

        return ResponseEntity.ok(String.valueOf(resultado.valor));
    }
}
