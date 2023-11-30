var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

//  ******* ODONTOLOGOS
//////////////////////////////////////////////
// CREACION DE ODONTOLOGOS
//////////////////////////////////////////////

 raw = JSON.stringify({
  "matricula": "123451231231236",
  "nombre": "Anmary",
  "apellido": "Pererira"
});

 requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/odontologos/registrar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));


///////////////////

   raw = JSON.stringify({
    "matricula": "3456734564356",
    "nombre": "Jose",
    "apellido": "Zamora"
  });

   requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };

  fetch("http://localhost:8080/odontologos/registrar", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));


//////////////////////////////////////////////
// LISTAR ODONTOLOGOS
//////////////////////////////////////////////

 requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/odontologos/listar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// BUSCAR POR ID ODONTOLOGO
//////////////////////////////////////////////
 requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/odontologos/1", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// ELIMINAR ODONTOLOGOS
//////////////////////////////////////////////

 requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/odontologos/1", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));


//////////////////////////////////////////////////////////////////////////////////////////////


//  ******* PACIENTES
//////////////////////////////////////////////
// CREACION DE PACIENTES
//////////////////////////////////////////////


 raw = JSON.stringify({
  "nombre": "Luis",
  "apellido": "Perez",
  "dni": "258874196",
  "fechaIngreso": "2023-11-30",
  "domicilioEntradaDto": {
    "calle": "Armando Moock",
    "numero": 100,
    "localidad": "Macul",
    "provincia": "RM"
  }
});

 requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/pacientes/registrar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));


///////////////////

 raw = JSON.stringify({
  "nombre": "Pedro",
  "apellido": "Garcia",
  "dni": "258874196",
  "fechaIngreso": "2023-11-30",
  "domicilioEntradaDto": {
    "calle": "Armando Moock",
    "numero": 100,
    "localidad": "Macul",
    "provincia": "RM"
  }
});

 requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/pacientes/registrar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// LISTAR PACIENTES
//////////////////////////////////////////////

 requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/pacientes/listar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// BUSCAR POR ID PACIENTE
//////////////////////////////////////////////
 requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/pacientes/1", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// ELIMINAR PACIENTES
//////////////////////////////////////////////

 requestOptions = {
  method: 'DELETE',
  redirect: 'follow'
};

fetch("http://localhost:8080/pacientes/eliminar/1", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));


//////////////////////////////////////////////////////////////////////////////////////////////


//  ******* TURNOS
//////////////////////////////////////////////
// CREACION DE TURNOS
//////////////////////////////////////////////


 raw = JSON.stringify({
  "fechaYHora": "2023-11-30T23:00:00",
  "paciente": 1,
  "odontologo": 1
});

 requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/turnos/registrar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

///////////////////


 raw = JSON.stringify({
  "fechaYHora": "2023-11-30T23:00:00",
  "paciente": 2,
  "odontologo": 2
});

 requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/turnos/registrar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// LISTAR TURNOS
//////////////////////////////////////////////

 requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/turnos/listar", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// BUSCAR POR ID TURNO
//////////////////////////////////////////////
 requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/turnos/1", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));

//////////////////////////////////////////////
// ELIMINAR TURNOS
//////////////////////////////////////////////

 requestOptions = {
  method: 'DELETE',
  redirect: 'follow'
};

fetch("http://localhost:8080/turnos/eliminar/1", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));