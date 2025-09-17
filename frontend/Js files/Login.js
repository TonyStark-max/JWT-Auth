function Login() {
    event.preventDefault(); // Stop default form submit
    const errorBox = document.getElementById("loginError");
    errorBox.textContent = "";
    errorBox.style.color = "red";

    const email = document.getElementById("login-email").value.trim();
    const password = document.getElementById("login-password").value.trim();

    if (!email||!password) {
        errorBox.textContent = "⚠ Please enter both email and password!";
        return;
    }
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        errorBox.textContent = "⚠ Invalid email format!";
        return;
    }
    const loginData = { email, password };
    fetch("http://localhost:8080/api/login",{
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(loginData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Invalid credentials!");
            }
            return response.json();
        })
        .then(data => {
            errorBox.style.color ="green";
            errorBox.textContent ="✅ Login successful!";
            localStorage.setItem("token",data.token);

            setTimeout(()=>{
                window.location.href="Index.html";
            }, 1000);
        })
        .catch(error=>{
            errorBox.textContent = "❌"+error.message;
        });
}
