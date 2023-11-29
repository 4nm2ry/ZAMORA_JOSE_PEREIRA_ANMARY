////// Creación de Odontologo

var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "matricula": "12345678910",
  "nombre": "Anmary",
  "apellido": "Pereira"
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/odontologos/registrar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));


  ////// Creación de Paciente


var raw = JSON.stringify({
  "nombre": "Luis",
  "apellido": "Perez",
  "dni": "258874196",
  "fechaIngreso": "2023-11-27",
  "domicilioEntradaDto": {
    "calle": "Armando Moock",
    "numero": 100,
    "localidad": "Macul",
    "provincia": "RM"
  }
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/pacientes/registrar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));


