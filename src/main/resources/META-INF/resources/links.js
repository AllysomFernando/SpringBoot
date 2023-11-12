// Estado da calculadora
let inputBuffer = "";
let operator = "";
let firstInput = "";

// Elementos DOM
const display = document.getElementById("display");
const buttons = document.getElementById("botoes");
const scientificSection = document.querySelector(".calculadora-cientifica");

// Função para atualizar o display
function updateDisplay() {
    display.value = inputBuffer;
}



// Função para realizar operações básicas
async function performBasicOperation(value) {
    if (firstInput !== "") {
        const response = await fetch(`http://localhost:8080/calculate?first=${encodeURIComponent(firstInput)}&second=${encodeURIComponent(inputBuffer)}&operator=${encodeURIComponent(value)}`);
        if (response.ok) {
            inputBuffer = await response.text();
            firstInput = "";
            operator = "";
        } else {
            alert("Error: " + await response.text());
        }
        updateDisplay();
    }
}
// Função para realizar operações científicas
async function performScientificOperation(value) {
    if (inputBuffer !== "") {
        // Exibir a expressão no display
        const expression = `${value}(${inputBuffer})`;
        display.value = expression;

        // Enviar solicitação para o servidor
        const response = await fetch(`http://localhost:8080/scientific?value=${encodeURIComponent(inputBuffer)}&operation=${encodeURIComponent(value)}`);
        if (response.ok) {
            inputBuffer = await response.text();
        } else {
            alert("Error: " + await response.text());
        }

        // Atualizar o display com a expressão completa e o resultado
        display.value = `${expression} = ${inputBuffer}`;
    }
}

// Adicionar evento de clique para os botões científicos
const scientificButtons = document.getElementById("botoesCientificos");
scientificButtons.addEventListener("click", async function (event) {
    const value = event.target.innerText;
    await performScientificOperation(value);
});

// Adicionar evento de clique para os botões
buttons.addEventListener("click", async function (event) {
    const value = event.target.innerText;

    if (!isNaN(value) || value === ".") {
        // Números e ponto decimal
        inputBuffer += value;
    } else if (["/", "*", "+", "-"].includes(value)) {
        // Operadores básicos
        if (firstInput === "") {
            firstInput = inputBuffer;
            inputBuffer = "";
            operator = value;
        }
    } else if (value === "=") {
        // Sinal de igual
        await performBasicOperation(operator);
    } else if (value === "CE") {
        // Limpar
        inputBuffer = "";
        firstInput = "";
        operator = "";
        updateDisplay();
    } else if (["sin", "cos", "tan", "sqrt", "^"].includes(value)) {
        // Operações científicas
        await performScientificOperation(value);
    } else if (value === "^") {
        // Potenciação
        await performScientificOperation("power");
    }

    updateDisplay();
});

// Adicionar evento de clique para o botão de troca para a calculadora científica
const scientificButton = document.getElementById("scientificButton");
scientificButton.addEventListener("click", function () {
    scientificSection.style.display = (scientificSection.style.display === "none") ? "block" : "none";
    updateDisplay();
});
