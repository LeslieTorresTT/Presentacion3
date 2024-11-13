(function() {
    'use strict'

    //Obtiene los formularios para aplicar los estilos de validación de Bootstrap personalizados
    var forms = document.querySelectorAll('.needs-validation')

    Array.prototype.slice.call(forms)
        .forEach(function(form) {
            form.addEventListener('submit', function (event){
                if (!form.checkValidity()){
                    Event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            },false)
        })
})()

function Ingresar(){
    //alert('¡Ups! Parece que ha ocurrido un problema. Estamos trabajando en ello 🛠️👨🏻‍💻. Por favor, vuelva a intentarlo mas tarde');
    //window.location.href = "../index.html";
  }

var boton = document.getElementById('Ingresar');

boton.onclick = Ingresar;