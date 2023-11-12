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

    /**
     * Método que lida com requisições GET na rota "/calculate".
     *
     * @param first     O primeiro operando da operação.
     * @param second    O segundo operando da operação.
     * @param operator  O operador da operação (+, -, *, /).
     * @return          ResponseEntity contendo o resultado da operação ou uma mensagem de erro.
     */
    @GetMapping("/calculate")
    public ResponseEntity<String> calculate(
            @RequestParam("first") float first,
            @RequestParam("second") float second,
            @RequestParam("operator") String operator
    ){
        // Instância de serviços para operações matemáticas
        Divisao divisao = new Divisao();
        Somar somar = new Somar();
        Substracao substracao = new Substracao();
        Multiplicacao multiplicacao = new Multiplicacao();

        // Variável para armazenar o resultado da operação
        Resultado resultado;

        // Switch para determinar a operação com base no operador fornecido
        switch (operator) {
            case "+":
                resultado = new Resultado(somar.operacao(first, second));
                break;
            case "-":
                resultado = new Resultado(substracao.operacao(first, second));
                break;
            case "*":
                resultado = new Resultado(multiplicacao.operacao(first, second));
                break;
            case "/":
                resultado = divisao.operacao((int) first, (int) second);
                break;
            default:
                // Se o operador não for válido, retorna uma resposta de erro
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid operator");
        }

        // Se houver erro na operação, retorna uma resposta de erro
        if (resultado.temErro()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado.mensagemErro);
        }

        // Retorna o resultado da operação bem-sucedida
        return ResponseEntity.ok(String.valueOf(resultado.valor));
    }
}
