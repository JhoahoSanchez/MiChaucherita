// INCOME
var btnAbrirPopup1 = document.getElementById('btn-abrir-popup1'),
	overlay = document.getElementById('overlay'),
	popup = document.getElementById('popup'),
	btnCerrarPopup1 = document.getElementById('btn-cerrar-popup1');

btnAbrirPopup1.addEventListener('click', function() {
	overlay.classList.add('active');
	popup.classList.add('active');
});

btnCerrarPopup1.addEventListener('click', function(e) {
	e.preventDefault();
	overlay.classList.remove('active');
	popup.classList.remove('active');
});


//EXPENSE

var btnAbrirPopup2 = document.getElementById('btn-abrir-popup2'),
	overlay2 = document.getElementById('overlay2'),
	popup2 = document.getElementById('popup2'),
	btnCerrarPopup2 = document.getElementById('btn-cerrar-popup2');

btnAbrirPopup2.addEventListener('click', function() {
	overlay2.classList.add('active');
	popup2.classList.add('active');
});

btnCerrarPopup2.addEventListener('click', function(e) {
	e.preventDefault();
	overlay2.classList.remove('active');
	popup2.classList.remove('active');
});


//DATE

var btnAbrirPopup4 = document.getElementById('btn-abrir-popup4'),
	overlay4 = document.getElementById('overlay4'),
	popup4 = document.getElementById('popup4'),
	btnCerrarPopup4 = document.getElementById('btn-cerrar-popup4');

btnAbrirPopup4.addEventListener('click', function() {
	overlay4.classList.add('active');
	popup4.classList.add('active');
});

btnCerrarPopup4.addEventListener('click', function(e) {
	e.preventDefault();
	overlay4.classList.remove('active');
	popup4.classList.remove('active');
});


//TRANSFER

var btnAbrirPopup3 = document.getElementById('btn-abrir-popup3'),
	overlay3 = document.getElementById('overlay3'),
	popup3 = document.getElementById('popup3'),
	btnCerrarPopup3 = document.getElementById('btn-cerrar-popup3');

btnAbrirPopup3.addEventListener('click', function() {
	overlay3.classList.add('active');
	popup3.classList.add('active');
});

btnCerrarPopup3.addEventListener('click', function(e) {
	e.preventDefault();
	overlay3.classList.remove('active');
	popup3.classList.remove('active');
});

const inputField = document.getElementById('importe1');
inputField.addEventListener('input', addMinusSign);

function addMinusSign() {
	const currentValue = inputField.value;
	if (!currentValue.startsWith('-')) {
		inputField.value = '-' + currentValue;
	}
}
