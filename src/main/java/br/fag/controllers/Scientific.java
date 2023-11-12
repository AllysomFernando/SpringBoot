package br.fag.controllers;

import br.fag.model.Resultado;
import br.fag.services.Cos;
import br.fag.services.Sin;
import br.fag.services.Sqrt;
import br.fag.services.Tan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Scientific {

    /**
     * Método que lida com requisições GET na rota "/scientific" para realizar operações científicas.
     *
     * @param value     O valor sobre o qual a operação científica será realizada.
     * @param operator  A operação científica a ser executada (sin, cos, sqrt, tan, ^).
     * @return          ResponseEntity contendo o resultado da operação ou uma mensagem de erro.
     */
    @GetMapping("/scientific")
    public ResponseEntity<Double> calculateScientific(
            @RequestParam("value") double value,
            @RequestParam("operation") String operator
    ){
        // Variável para armazenar o resultado da operação
        Resultado resultado;

        // Switch para determinar a operação científica com base no operador fornecido
        switch (operator) {
            case "sin":
                resultado = new Resultado(Sin.calcularSeno(value));
                break;
            case "cos":
                resultado = new Resultado(Cos.calcularCos(value));
                break;
            case "sqrt":
                resultado = new Resultado(Sqrt.calcularRaizQuadrada(value));
                break;
            case "tan":
                resultado = new Resultado(Tan.calcularTangente(value));
                break;
            case "^":
                resultado = new Resultado(Tan.calcularTangente(value));  // Este caso parece um erro, pois está usando a tangente novamente.
                break;
            default:
                // Se a operação não for válida, retorna uma resposta de erro
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Se houver erro na operação, retorna uma resposta de erro
        if (resultado.temErro()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Retorna o resultado da operação científica bem-sucedida
        return ResponseEntity.ok(resultado.valor);
    }
}
