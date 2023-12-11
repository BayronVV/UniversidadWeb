/* ******************** Variables ****************************** */
const GET_DOCENTES = "http://localhost:8080/docentes";
const GET_DOCENTE = "http://localhost:8080/docentes/";
const CREATE_DOCENTE = "http://localhost:8080/docentes";
const UPDATE_DOCENTE = "http://localhost:8080/docentes";
const DELETE_DOCENTE = "http://localhost:8080/docentes/";

const GET_MATERIAS = "http://localhost:8080/materias";
const CREATE_MATERIA = "http://localhost:8080/materias";
const DELETE_MATERIA = "http://localhost:8080/materias/";

/* ****************** Metodos Comunes ************************** */
async function obtenerTodos(link) {
  const respuesta = await fetch(link);
  const datos = await respuesta.json();
  return datos;
}

async function obtenerPorId(id, link) {
  try {
    const respuesta = await fetch(`${link}${id}`);
    if (respuesta.ok) {
      const docente = await respuesta.json();
      return docente;
    } else {
      // Manejar errores, por ejemplo, si el docente no existe
      console.error("Error al obtener el docente por ID.");
      return null;
    }
  } catch (error) {
    console.error("Error de red:", error);
    return null;
  }
}

async function eliminarElemento(id, link) {
  await fetch(`${link}${id}`, {
    method: "DELETE",
  });
}

/* *********** Para los Docentes  **************** */
async function cargarDatosEnTabla(url) {
  try {
    const todos = await obtenerTodos(url); // Usa tu función para obtener datos
    const tabla = document.getElementById("tablaDatos");

    // Limpiar la tabla
    tabla.innerHTML =
      "<tr><th>ID</th><th>Nombre</th><th>Apellido</th><th>Direccion</th><th>Actualizar</th><th>Eliminar</th></tr>";

    // Llenar la tabla con los datos obtenidos
    todos.forEach((elemento) => {
      const fila = document.createElement("tr");
      fila.innerHTML = `<td>${elemento.id}</td><td>${elemento.nombre}</td><td>${elemento.apellido}</td><td>${elemento.direccion}</td><td><button class=btn id=updateDoc data-idUpdDoc=${elemento.id}>↩️</button></td><td><button class=btn id=deleteDocente data-idDoc=${elemento.id}>🗑️</button></td>`;
      // Añade más celdas según tus datos
      tabla.appendChild(fila);
    });
  } catch (error) {
    console.error("Error:", error);
  }
}
cargarDatosEnTabla(GET_DOCENTES);

async function crearDocente() {
  try {
    const formulario = document.getElementById("formularioDocente");
    const nombre = formulario.elements["nombre"].value;
    const apellido = formulario.elements["apellido"].value;
    const direccion = formulario.elements["direccion"].value;

    const nuevoDocente = {
      nombre: nombre,
      apellido: apellido,
      direccion: direccion,
    };

    // Realizar la solicitud POST para crear el docente
    const respuesta = await fetch(CREATE_DOCENTE, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(nuevoDocente),
    });
  } catch (error) {
    console.error("Error:", error);
  }
}

async function actualizarDocente(idDocente, link) {
  try {
    const titulo = document.getElementById("formDocTitle");
    titulo.textContent = "Actualizar Docente";
    editDocente = await obtenerPorId(idDocente, link);

    const formulario = document.getElementById("formularioDocente");

    formulario.elements["nombre"].value = docenteSeleccionado.nombre;
    formulario.elements["apellido"].value = docenteSeleccionado.apellido;
    formulario.elements["direccion"].value = docenteSeleccionado.direccion;

    const nombre = formulario.elements["nombre"].value;
    const apellido = formulario.elements["apellido"].value;
    const direccion = formulario.elements["direccion"].value;

    const actualizarDocente = {
      id: idDocente,
      nombre: nombre,
      apellido: apellido,
      direccion: direccion,
    };

    // Realizar la solicitud POST para crear el docente
    const respuesta = await fetch(UPDATE_DOCENTE, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(actualizarDocente),
    });
  } catch (error) {
    console.error("Error:", error);
  }
}

/* ******** Para las Materias ******** */
async function cargarDatosEnTablaMateria(url) {
  try {
    const todos = await obtenerTodos(url); // Usa tu función para obtener datos
    const tabla = document.getElementById("tablaMaterias");

    // Limpiar la tabla
    tabla.innerHTML =
      "<tr><th>ID</th><th>Nombre</th><th>Creditos</th><th>Docente</th><th>Actualizar</th><th>Eliminar</th></tr>";

    // Llenar la tabla con los datos obtenidos
    todos.forEach((elemento) => {
      const fila = document.createElement("tr");
      fila.innerHTML = `<td>${elemento.id}</td><td>${elemento.nombre}</td><td>${elemento.creditos}</td><td>${elemento.docente.nombre}</td><td><button class=btn id=update>↩️</button></td><td><button class=btn id=deleteMateria data-idMat=${elemento.id}>🗑️</button></td>`;
      // Añade más celdas según tus datos
      tabla.appendChild(fila);
    });
  } catch (error) {
    console.error("Error:", error);
  }
}
cargarDatosEnTablaMateria(GET_MATERIAS);

const llenarSelect = async () => {
  const docentes = await obtenerTodos(GET_DOCENTES);
  const $select = document.getElementById("disabledSelect");
  docentes.forEach((docente) => {
    const opcion = document.createElement("option");
    opcion.value = docente.id;
    opcion.textContent = `${docente.nombre} ${docente.apellido}`;
    $select.appendChild(opcion);
  });
};

async function crearMateria() {
  try {
    const formulario = document.getElementById("formularioMateria");
    const nombre = formulario.elements["nombre"].value;
    const creditos = formulario.elements["creditos"].value;
    const docente = formulario.elements["docente"].value;

    const nuevaMateria = {
      nombre: nombre,
      creditos: creditos,
      docente: docente,
    };

    // Realizar la solicitud POST para crear el docente
    const respuesta = await fetch(CREATE_MATERIA, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(nuevaMateria),
    });
  } catch (error) {
    console.error("Error:", error);
  }
}

/* *********** Manejo De los Eventos *************** */
document.addEventListener("click", (e) => {
  if (e.target.matches("#deleteMateria")) {
    let idMateria = e.target.getAttribute("data-idMat");
    eliminarElemento(idMateria, DELETE_MATERIA);
    setTimeout(() => {
      window.location.reload();
    }, 3000);
  }

  if (e.target.matches("#deleteDocente")) {
    let idDocente = e.target.getAttribute("data-idDoc");
    eliminarElemento(idDocente, DELETE_DOCENTE);
    setTimeout(() => {
      window.location.reload();
    }, 3000);
  }

  if (e.target.matches("#guardarDoc")) {
    crearDocente();
    setTimeout(() => {
      window.location.href = "index.html";
    }, 1000);
  }

  if (e.target.matches("#guardarMat")) {
    crearMateria();
    setTimeout(() => {
      window.location.href = "index.html";
    }, 1000);
  }

  if (e.target.matches("#updateDoc")) {
    let idDocente = e.target.getAttribute("data-idUpdDoc");
    actualizarDocente(idDocente, GET_DOCENTE);
    window.location.href = "createDoc.html";
    setTimeout(() => {
      window.location.href = "index.html";
    }, 1000);
  }
});

document.addEventListener("DOMContentLoaded", (e) => {
  llenarSelect();
});
