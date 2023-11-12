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
    @GetMapping("/scientific")
    public ResponseEntity<String> calculateScientific(
            @RequestParam("value") double value,
            @RequestParam("operation") String operator
    ){
        Resultado resultado;

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
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid operator");
        }
        if (resultado.temErro()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado.mensagemErro);
        }
        return ResponseEntity.ok("ok");
    }
}
