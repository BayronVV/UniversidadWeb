async function enviarFormulario() {
  const formulario = document.getElementById("loginForm");
  const formData = new FormData(formulario);

  const url = "http://localhost:8080/rest/auth/login";

  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: new URLSearchParams(formData).toString(),
    });

    if (!response.ok) {
      throw new Error(`Error de red - ${response.statusText}`);
    }

    const data = await response.json();
    console.log("Respuesta del servidor:", data);
  } catch (error) {
    console.error("Error al realizar la solicitud:", error);
  }
}
