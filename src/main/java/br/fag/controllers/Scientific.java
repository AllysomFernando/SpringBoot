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
            @RequestParam("value") float value,
            @RequestParam("operation") String operator
    ){
        Cos cos = new Cos();
        Sin sin = new Sin();
        Sqrt sqrt = new Sqrt();
        Tan tan = new Tan();
        Resultado resultado;

        switch (operator) {
            case "sin":
                resultado = new Resultado(sin);
                break;
            case "cos":
                resultado = new Resultado(cos);
                break;
            case "sqrt":
                resultado = new Resultado(sqrt);
                break;
            case "tan":
                resultado = new Resultado(tan);
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
