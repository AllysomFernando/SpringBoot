// Evento de clique para os botões
let inputBuffer = "";
let operator = "";
let firstInput = "";

// Capturando elementos
const display = document.getElementById("display");
const buttons = document.getElementById("botoes");

// Função para atualizar o display
function updateDisplay() {
    display.value = inputBuffer;
}
buttons.addEventListener("click", async function(event) {
    const value = event.target.innerText;

    if (!isNaN(value) || value === ".") {
        // Se o valor é um número ou um ponto
        inputBuffer += value;
    } else if (["/", "*", "+", "-"].includes(value)) {
        // Se o valor é um operador
        if (firstInput === "") {
            firstInput = inputBuffer;
            inputBuffer = "";
            operator = value;
        }
    } else if (value === "=") {
        // Se o valor é o sinal de igual
        if (firstInput !== "") {
            const response = await fetch(`http://localhost:8080/calculate?first=${encodeURIComponent(firstInput)}&second=${encodeURIComponent(inputBuffer)}&operator=${encodeURIComponent(operator)}`);
            if (response.ok) {
                inputBuffer = await response.text();
                firstInput = "";
                operator = "";
            } else {
                alert("Error: " + await response.text());
            }
        }
    } else if (value === "CE") {
        // Se o valor é "CE" (Limpar)
        inputBuffer = "";
        firstInput = "";
        operator = "";
    } else if (value === "sin" || value === "cos" || value === "tan" || value === "sqrt") {
        // Se o valor é uma operação científica
        if (inputBuffer !== "") {
            const response = await fetch(`http://localhost:8080/scientific?value=${encodeURIComponent(inputBuffer)}&operation=${encodeURIComponent(value)}`);
            if (response.ok) {
                inputBuffer = await response.text();
            } else {
                alert("Error: " + await response.text());
            }
        }
    } else if (value === "^") {
        // Se o valor é "^" (potenciação)
        if (firstInput !== "") {
            const response = await fetch(`http://localhost:8080/scientific?base=${encodeURIComponent(firstInput)}&exponent=${encodeURIComponent(inputBuffer)}`);
            if (response.ok) {
                inputBuffer = await response.text();
                firstInput = "";
                operator = "";
            } else {
                alert("Error: " + await response.text());
            }
        }
    }

    updateDisplay();
});
